package com.DtoYResponseEntityP2PG.Covid19;

import java.io.Serializable;
import java.util.List;

public class SintomasDto implements Serializable {
    String sintomas;

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas += " , " + sintomas;
    }

}
