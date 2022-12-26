package com.bootcamp.clientes;

import com.bootcamp.transacciones.ConsultaSaldo;
import com.bootcamp.transacciones.RetiroEfectivo;

public class Cobrador {

    RetiroEfectivo servicioRetiroEfectivo;
    ConsultaSaldo servicioConsultaSaldo;

    public Cobrador() {
        this.servicioRetiroEfectivo = new RetiroEfectivo();
        this.servicioConsultaSaldo = new ConsultaSaldo();
    }

    public RetiroEfectivo getServicioRetiroEfectivo() {
        return servicioRetiroEfectivo;
    }

    public void setServicioRetiroEfectivo(RetiroEfectivo servicioRetiroEfectivo) {
        this.servicioRetiroEfectivo = servicioRetiroEfectivo;
    }

    public ConsultaSaldo getServicioConsultaSaldo() {
        return servicioConsultaSaldo;
    }

    public void setServicioConsultaSaldo(ConsultaSaldo servicioConsultaSaldo) {
        this.servicioConsultaSaldo = servicioConsultaSaldo;
    }

    @Override
    public String toString() {
        return "Cobrador{" +
                "servicioRetiroEfectivo=" + servicioRetiroEfectivo +
                ", servicioConsultaSaldo=" + servicioConsultaSaldo +
                '}';
    }
}
