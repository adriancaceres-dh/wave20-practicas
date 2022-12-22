package com.bootcamp;

import java.util.*;

public class App {

    public static void main(String[] args) {
        List<Localizador> localizadores =Repositorio.getLocalizadores();

        //crear localizador
        Localizador localizador = new Localizador();

        //tipos de items
        HashMap<String,Tipo> tipos = new HashMap<>();
        tipos.put("Reserva",new Tipo("Reserva"));
        tipos.put("Boleto",new Tipo("Boleto"));
        tipos.put("Comida",new Tipo("Comida"));
        tipos.put("Transporte",new Tipo("Transporte"));

        Item item1 = new Item(tipos.get("Reserva"),2000);
        Item item2 = new Item(tipos.get("Boleto"),500);
        Item item3 = new Item(tipos.get("Comida"),200);
        Item item4 = new Item(tipos.get("Transporte"),450);
        List<Item> items = new ArrayList<>(Arrays.asList(item1,item2,item3,item4));
        Cliente cliente = new Cliente(12341234,"Fede","Veron");

        localizador.setCliente(cliente);
        localizador.setItems(items);
        localizador.calcularTotal();

        //segundo localizador
        Localizador localizador1 = new Localizador();
        localizador1.setCliente(cliente);

        Item itemLocalizador = new Item(tipos.get("Reserva"),300);
        Item itemLocalizador2 = new Item(tipos.get("Reserva"),300);
        Item itemLocalizador3 = new Item(tipos.get("Boleto"),250);
        Item itemLocalizador4 = new Item(tipos.get("Boleto"),260);

        List<Item> items2 = new ArrayList<>(Arrays.asList(itemLocalizador,itemLocalizador2,itemLocalizador3,itemLocalizador4));
        localizador1.setItems(items2);


        localizadores.add(localizador);
        localizadores.add(localizador1);
        //imprimir
        System.out.println(localizador.toString());

        int descuentos = Repositorio.calcularDescuentos(localizador1,cliente);
        System.out.println(descuentos);
        if(descuentos > 0){
            localizador1.calcularTotalDescuento(descuentos);
        }

    }
}
