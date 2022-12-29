package com.example.link_tracker.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Link {

    private Long id;
    private String url;
    private int numberOfRedirections;
    private String password;
}
