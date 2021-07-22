package com.telefonica.gal.SRV_DYNAMICCONF.repository.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Step {
    @JsonProperty("step")
    private int step;
    @JsonProperty("endpointID")
    private String endpointID;
    @JsonProperty("type")
    private String type;
    @JsonProperty("active")
    private boolean active;
}
