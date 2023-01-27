package com.example.MapeoDeUnaClaveCompuesta.entity;

import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;

@Getter
@Setter
public class CompraKey implements Serializable {
    private Integer clientid;
    private Locale fecha;

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()) return false;
        CompraKey that = (CompraKey) o;
        return Objects.equals(clientid, that.clientid) && Objects.equals(fecha, that.fecha);
    }

}
