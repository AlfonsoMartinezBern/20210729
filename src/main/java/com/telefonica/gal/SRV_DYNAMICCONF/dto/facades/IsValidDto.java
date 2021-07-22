package com.telefonica.gal.SRV_DYNAMICCONF.dto.facades;

import com.telefonica.gal.SRV_DYNAMICCONF.config.FileType;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class IsValidDto {
    private FileType fileType;
    private String instance;
}
