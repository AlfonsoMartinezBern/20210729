package com.telefonica.gal.SRV_DYNAMICCONF.repository.model.spain.routing;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SpainTDHelpdesk {
    @JsonProperty("version")
    private String version;
    @JsonProperty("info")
    private String info;
    @JsonProperty("service")
    private String service;
    @JsonProperty("serviceInstance")
    private String serviceInstance;
    @JsonProperty("routes")
    private List<SpainTdHelpdeskRoute> routes;
}
