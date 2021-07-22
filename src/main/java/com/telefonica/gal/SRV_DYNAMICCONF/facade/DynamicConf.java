package com.telefonica.gal.SRV_DYNAMICCONF.facade;

import com.telefonica.gal.SRV_DYNAMICCONF.config.FileType;
import com.telefonica.gal.SRV_DYNAMICCONF.dto.MessageResponse;
import com.telefonica.gal.SRV_DYNAMICCONF.dto.facades.ChargeDto;
import com.telefonica.gal.SRV_DYNAMICCONF.dto.facades.IsValidDto;

import java.io.IOException;

public interface DynamicConf {

	 MessageResponse confInfo();
	 MessageResponse isValidConfigFile(IsValidDto isValidDto) throws IOException;
	 MessageResponse chargeConf(ChargeDto chargeDto);
	 MessageResponse confShowData();
	 MessageResponse confValue();
	 MessageResponse showFile();

}
