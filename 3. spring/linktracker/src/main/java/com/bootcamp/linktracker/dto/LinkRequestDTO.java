package com.bootcamp.linktracker.dto;

import lombok.Getter;

@Getter
public class LinkRequestDTO {
    private String link;
    private String password;

    public LinkRequestDTO() {
    }
}
