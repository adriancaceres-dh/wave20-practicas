package com.example.links.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LinkResponseDto {
    private long id;
    private String url;
    private boolean valid;
    private int amountOfRedirects;
}
