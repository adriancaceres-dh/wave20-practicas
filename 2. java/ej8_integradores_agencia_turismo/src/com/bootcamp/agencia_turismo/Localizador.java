package com.bootcamp.agencia_turismo;

import com.bootcamp.agencia_turismo.reservas.Reserva;

import java.util.List;

public class Localizador extends Cliente{

    private int total;
    private List<Reserva> listaReserva;

    public Localizador(Cliente cliente, List<Reserva> listaReserva){
        super(cliente.getDni(),cliente.getNombre(),cliente.getEdad());
        this.listaReserva=listaReserva;
        this.total=listaReserva.size();
        RepositorioLocalizador.addLocalizador(this);
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "total=" + total +
                ", listaReserva=" + listaReserva +
                "} " + super.toString();
    }
}
