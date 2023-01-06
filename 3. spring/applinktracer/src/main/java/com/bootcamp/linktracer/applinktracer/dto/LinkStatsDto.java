package com.bootcamp.linktracer.applinktracer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LinkStatsDto {
    private String url;
    @JsonProperty("times_redirected")
    private int clicked;
}
