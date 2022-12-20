package com.bootcamp;

public class Cobradores implements RetiroEfectivo,ConsultaSaldo{

    @Override
    public void consultaSaldo() {
        System.out.println("consulta saldos");
    }

    @Override
    public void retiroEfectivo() {
        System.out.println("retiro efectivos");
    }
}
