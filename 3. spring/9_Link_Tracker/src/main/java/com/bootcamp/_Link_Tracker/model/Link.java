package com.bootcamp._Link_Tracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Link {

    private Long id;
    private String url, password;
    private int redirects;
    private boolean valid;
}
