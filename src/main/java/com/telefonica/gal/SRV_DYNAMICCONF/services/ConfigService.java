package com.telefonica.gal.SRV_DYNAMICCONF.services;

import com.telefonica.gal.SRV_DYNAMICCONF.config.FileType;
import com.telefonica.gal.SRV_DYNAMICCONF.dto.facades.IsValidDto;

import java.io.IOException;

public interface ConfigService {
    boolean isValidChargeConf(FileType fileType, String instance);
    boolean chargeConf(FileType fileType, String instance);
}
