package com.telefonica.gal.SRV_DYNAMICCONF.repository.model.spain.routing;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.telefonica.gal.SRV_DYNAMICCONF.repository.model.common.Flow;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SpainTdHelpdeskRoute {
    @JsonProperty("operationTD")
    private String operationTD;
    @JsonProperty("flows")
    private Flow flows;
    @JsonProperty("endpoints")
    private List<SpainTdHelpdeskEndpoint> endpoints;
}
