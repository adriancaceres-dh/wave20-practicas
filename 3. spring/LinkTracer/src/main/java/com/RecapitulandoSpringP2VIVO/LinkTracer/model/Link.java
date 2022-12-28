package com.RecapitulandoSpringP2VIVO.LinkTracer.model;

import lombok.Data;

@Data
public class Link {
    String link;
    int visitas = 0;
    String password;

    public Link(String link, String password) {
        this.link = link;
        this.password = password;
    }

    public boolean incrementarVisitas()
    {
        visitas++;
        return true;
    }

}
