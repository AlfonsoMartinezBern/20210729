package com.telefonica.gal.SRV_DYNAMICCONF.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.telefonica.gal.SRV_DYNAMICCONF.config.FileType;
import com.telefonica.gal.SRV_DYNAMICCONF.repository.model.spain.routing.SpainTDHelpdesk;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConfigServiceImpl implements ConfigService {

    @Value( "${configFile.spain.td.customerprovision.routing.path}" )
    private String SPAIN_TD_CUSTOMERPROVISION_ROUTING_PATH;

    @Value( "${configFile.spain.td.helpdesk.routing.path}" )
    private String SPAIN_TD_HELPDESK_ROUTING_PATH;

    @Value( "${configFile.spain.td.cdbprovision.routing.path}" )
    private String SPAIN_TD_CDBPROVISION_ROUTING_PATH;

    private List<String> SPAIN_TD_HELPDESK_INSTANCES = List.of("1","2");
    private List<SpainTDHelpdesk> SPAIN_TD_HELPDESK_LIST = new ArrayList<>();

    @Override
    public boolean isValidChargeConf(FileType fileType, String instance) {
        if (instance.isBlank() || instance.isEmpty() || instance == null) {
            // First case: No instance is present. We must validate all json files
            // starting with enum name
            return false;
        } else {
            // SPAIN_TD_HELPDESK_INSTANCES.forEach(sthInstance);
            Resource configFile = selectResource(fileType, instance);
            try {
                InputStream configFileInputStream = configFile.getInputStream();
                ObjectMapper mapper = new ObjectMapper();
                mapper.readValue(configFileInputStream, SpainTDHelpdesk.class);
            } catch(UnrecognizedPropertyException unrecognizedPropertyException) {
                unrecognizedPropertyException.printStackTrace();
                return false;
            } catch(IOException ioException) {
                ioException.printStackTrace();
                return false;
            }
            return true;
        }
    }

    @Override
    public boolean chargeConf(FileType fileType, String instance) {
        // First case: No instance is present. We must charge all json files
        // starting with enum name
        if (instance.isBlank() || instance.isEmpty() || instance == null) {
            // SPAIN_TD_HELPDESK_INSTANCES.forEach(sthInstance);
            return false;
        } else {
            // Second case: Instance is present. We must charge only json file
            // starting with enum name and instance
            Resource configFile = selectResource(fileType, instance);
            try {
                InputStream configFileInputStream = configFile.getInputStream();
                ObjectMapper mapper = new ObjectMapper();
                SpainTDHelpdesk spainTDHelpdesk = mapper.readValue(configFileInputStream, SpainTDHelpdesk.class);
                SPAIN_TD_HELPDESK_LIST.add(spainTDHelpdesk);
            } catch(UnrecognizedPropertyException unrecognizedPropertyException) {
                unrecognizedPropertyException.printStackTrace();
                return false;
            } catch(IOException ioException) {
                ioException.printStackTrace();
                return false;
            }
            return true;
        }
    }

    public Resource selectResource(FileType fileType, String instance) {
        String configPath = null;
        switch (fileType) {
            case SPAIN_TD_HELPDESK:
                configPath = SPAIN_TD_HELPDESK_ROUTING_PATH;
                break;
            case SPAIN_TD_CDBPROVISION:
                configPath = SPAIN_TD_CDBPROVISION_ROUTING_PATH;
                break;
            case SPAIN_TD_CUSTOMERPROVISION:
                configPath = SPAIN_TD_CUSTOMERPROVISION_ROUTING_PATH;
                break;
        }
        Resource configFile = new ClassPathResource(configPath + fileType.name() + "_" + instance + ".json");

        return configFile;
    }
}
