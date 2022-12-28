package com.bootcamp.linkTracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Link {
    Integer id;
    String url;
    String password;
    boolean isActive;
}
