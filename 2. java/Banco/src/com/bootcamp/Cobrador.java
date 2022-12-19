package com.bootcamp;

import com.bootcamp.interfaces.ConsultaDeSaldo;
import com.bootcamp.interfaces.Retiro;

public class Cobrador implements Retiro, ConsultaDeSaldo {

    @Override
    public void realizarConsulta() {
        System.out.println("Realizando su consulta espere un momento");
        if((int)((Math.random()*2)+1) == 1) transaccionOk("consulta de saldo");
        else transaccionNoOk("consulta de saldo");
    }

    @Override
    public void hacerRetiro() {
        System.out.println("Realizando su retiro espere un momento");
        if((int)((Math.random()*2)+1) == 1) transaccionOk("retiro");
        else transaccionNoOk("retiro");
    }

    @Override
    public void transaccionOk(String nombreOperacion) {
        System.out.println(String.format("Su %s ha sido exitoso", nombreOperacion));
    }

    @Override
    public void transaccionNoOk(String nombreOperacion) {
        System.out.println(String.format("Su %s no ha sido exitoso", nombreOperacion));

    }
}
