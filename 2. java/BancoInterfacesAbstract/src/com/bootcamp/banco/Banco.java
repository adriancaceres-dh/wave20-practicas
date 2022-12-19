package com.bootcamp.banco;

import com.bootcamp.banco.modelo.Basic;
import com.bootcamp.banco.modelo.Cobrador;
import com.bootcamp.banco.modelo.Ejecutivo;
import com.bootcamp.banco.modelo.Persona;

public class Banco {
    public static void main(String[] args) {
        Ejecutivo ejecutivo1 = new Ejecutivo("Pedro", "Perez", "213312");
        ejecutivo1.realizarDesposito(500000);
        ejecutivo1.realizarTransferencia(1302, "551232");

        Cobrador cobrador1 = new Cobrador("Camilo", "Arango","768312");
        cobrador1.realizarConsulta("132");
        cobrador1.realizarRetiro(300);

        Basic basic1 = new Basic("Alejandra", "Gil", "123124");
        basic1.realizarConsulta("123asd");
        basic1.realizarRetiro(588);
        basic1.PagarServicios(300,"Serivicios publicos");
        basic1.PagarServicios(1273,null);

    }


}
