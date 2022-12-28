package com.bootcamp.link_tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateLinkRequestDto {
    private final String link;
    private final String password;
}
