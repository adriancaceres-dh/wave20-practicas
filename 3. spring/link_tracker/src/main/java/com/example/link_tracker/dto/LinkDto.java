package com.example.link_tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LinkDto {
    private Long id;
    private String url;
    private int numberOfRedirections;
    private String password;

}
