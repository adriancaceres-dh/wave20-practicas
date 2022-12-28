package com.bootcamp.prueba.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Link {
    private String id;
    private String url;
    private int timesRedirected;
    private boolean valid;
}
