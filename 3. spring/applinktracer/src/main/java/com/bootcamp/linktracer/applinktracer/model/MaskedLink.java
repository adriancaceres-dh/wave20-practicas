package com.bootcamp.linktracer.applinktracer.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MaskedLink {

    private int id;
    private String url;
    private String password;
    private int clicked;
    private boolean valid;

    public MaskedLink(int id, String url, String password, boolean valid) {
        this.id = id;
        this.url = url;
        this.password = password;
        this.valid = valid;
    }
}
