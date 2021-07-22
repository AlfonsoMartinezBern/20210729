package com.telefonica.gal.SRV_DYNAMICCONF.repository.model.spain.routing;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SpainTdHelpdeskEndpoint {
    @JsonProperty("id")
    private String id;
    @JsonProperty("instanceID")
    private Integer instanceID;
    @JsonProperty("platformID")
    private Integer platformID;
    @JsonProperty("targetEndpoint")
    private String targetEndpoint;
    @JsonProperty("endpointType")
    private String endpointType;
}
