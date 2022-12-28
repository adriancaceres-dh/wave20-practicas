package com.bootcamp.link_tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class InvalidateLinkResponseDto {
    private final String message;
    private final String link;
}
