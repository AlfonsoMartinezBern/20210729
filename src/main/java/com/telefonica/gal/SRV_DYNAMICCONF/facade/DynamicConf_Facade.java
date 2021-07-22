package com.telefonica.gal.SRV_DYNAMICCONF.facade;

import com.telefonica.gal.SRV_DYNAMICCONF.dto.MessageResponse;
import com.telefonica.gal.SRV_DYNAMICCONF.dto.facades.ChargeDto;
import com.telefonica.gal.SRV_DYNAMICCONF.dto.facades.IsValidDto;
import com.telefonica.gal.SRV_DYNAMICCONF.services.ConfigService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DynamicConf_Facade implements DynamicConf{

	private ConfigService configService;

	public DynamicConf_Facade(ConfigService configService) {
		this.configService = configService;
	}


	@GetMapping("/isValid")
	@Override
	public MessageResponse isValidConfigFile(IsValidDto isValidDto) {
		return configService.isValidChargeConf(isValidDto.getFileType(), isValidDto.getInstance()) ? new MessageResponse("OK", "The configFile for is valid") : new MessageResponse("KO", "The Routing ConfigFile is NOT valid");
	}

	@PutMapping("/charge")
	public MessageResponse chargeConf(ChargeDto chargeDto) {
		boolean isCharged =  configService.chargeConf(chargeDto.getFileType(), chargeDto.getInstance());
		if (isCharged)
			return new MessageResponse("OK",  "OK");
		else
			return new MessageResponse("KO", "The configFile for was not uploaded");
	}


	@GetMapping("/showData")
	public MessageResponse confShowData(){
		return null;
	}

	@GetMapping("/value")
	public MessageResponse confValue() {
		return null;
	}

	@Override
	public MessageResponse confInfo() {
		return null;
	}

	@GetMapping("/showFile")
	public MessageResponse showFile() {
		return null;
	}
}
