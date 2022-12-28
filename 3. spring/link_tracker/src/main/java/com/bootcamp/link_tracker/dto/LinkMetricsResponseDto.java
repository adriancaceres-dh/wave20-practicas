package com.bootcamp.link_tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LinkMetricsResponseDto {
    private final int redirections;
}
