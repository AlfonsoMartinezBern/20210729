package com.telefonica.gal.SRV_DYNAMICCONF.repository.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Flow{
	@JsonProperty("synchronous")
	private boolean synchronous;
	@JsonProperty("steps")
	private List<Step> steps;
}
