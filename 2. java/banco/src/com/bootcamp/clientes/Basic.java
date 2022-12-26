package com.bootcamp.clientes;

import com.bootcamp.transacciones.ConsultaSaldo;
import com.bootcamp.transacciones.PagoServicios;
import com.bootcamp.transacciones.RetiroEfectivo;

public class Basic {

    ConsultaSaldo servicioConsultaSaldo;
    PagoServicios serviciosPagoServicios;
    RetiroEfectivo servicioRetiroEfectivo;

    public Basic() {
        this.servicioConsultaSaldo = new ConsultaSaldo();
        this.serviciosPagoServicios = new PagoServicios();
        this.servicioRetiroEfectivo = new RetiroEfectivo();
    }

    public ConsultaSaldo getServicioConsultaSaldo() {
        return servicioConsultaSaldo;
    }

    public void setServicioConsultaSaldo(ConsultaSaldo servicioConsultaSaldo) {
        this.servicioConsultaSaldo = servicioConsultaSaldo;
    }

    public PagoServicios getServiciosPagoServicios() {
        return serviciosPagoServicios;
    }

    public void setServiciosPagoServicios(PagoServicios serviciosPagoServicios) {
        this.serviciosPagoServicios = serviciosPagoServicios;
    }

    public RetiroEfectivo getServicioRetiroEfectivo() {
        return servicioRetiroEfectivo;
    }

    public void setServicioRetiroEfectivo(RetiroEfectivo servicioRetiroEfectivo) {
        this.servicioRetiroEfectivo = servicioRetiroEfectivo;
    }

    @Override
    public String toString() {
        return "Basic{" +
                "servicioConsultaSaldo=" + servicioConsultaSaldo +
                ", serviciosPagoServicios=" + serviciosPagoServicios +
                ", servicioRetiroEfectivo=" + servicioRetiroEfectivo +
                '}';
    }
}
