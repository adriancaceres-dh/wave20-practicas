package com.example.links.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Link {
    private long id;
    private URL url;
    private String password;
    private boolean valid;
    private int amountOfRedirects;

    public Link(long id, URL url, String password) {
        this.id = id;
        this.url = url;
        this.password = password;
        this.valid = true;
        this.amountOfRedirects = 0;
    }

    public void addRedirect() {
        amountOfRedirects++;
    }
}
