package com.RecapitulandoSpringP2VIVO.LinkTracer.dto;

public class DtoRequest {
    String link;
    String password;

    public DtoRequest(String link, String password) {
        this.link = link;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getLink() {
        return link;
    }
}
