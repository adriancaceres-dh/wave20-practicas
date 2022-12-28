package com.bootcamp.springp1integradorlinktracker.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LinkRequestDTO {
    private String url;

    public String getUrl() {
        return url;
    }

    public LinkRequestDTO(String url) {
        this.url = url;
    }
}
