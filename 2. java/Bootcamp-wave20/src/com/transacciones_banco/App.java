package com.transacciones_banco;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        //CREO CLIENTES DE CADA TIPO
        List<ICliente> clientes = new ArrayList<>();
        ICliente clienteBasic = new Basico("Soy un cliente basico");
        ICliente clienteEjecutivo = new Ejecutivo("Soy un cliente ejecutivo");
        ICliente clienteCobrador = new Cobrador("Soy un cliente cobrador");
        //LOS AGREGO A UNA LISTA
        clientes.add(clienteBasic);
        clientes.add(clienteEjecutivo);
        clientes.add(clienteCobrador);

        //CREO ACCIONES QUE PUEDEN REALIZAR
        List<ITransaccion> transacciones = new ArrayList<>();
        PagarServicios servicios = new PagarServicios();
        RealizarDeposito deposito = new RealizarDeposito();
        RealizarTransferencia transferencia = new RealizarTransferencia();
        ConsultarSaldo saldo = new ConsultarSaldo();
        RetirarEfectivo efectivo = new RetirarEfectivo();
        //LAS AGREGO A UNA LISTA
        transacciones.add(servicios);
        transacciones.add(deposito);
        transacciones.add(transferencia);
        transacciones.add(saldo);
        transacciones.add(efectivo);

        //ITERO LOS CLIENTES Y LAS TRANSACCIONES PARA QUE CADA UNO REALICE LAS QUE TIENE PERMITIDAS.
        for (ICliente cliente : clientes) {
            for (ITransaccion transaccion : transacciones) {
                System.out.println("El cliente que se encuentra operando es: "+ cliente.getNombre());
                TransactionVisitorImpl<ICliente> visitor = new TransactionVisitorImpl<>(cliente);
                System.out.println("Comienza a realizarse la transaccion");
                transaccion.aceptar(visitor);
            }
        }

    }
}
