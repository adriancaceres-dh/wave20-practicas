package com.bootcamp;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Repositorio
{
    private static List<Localizador> localizadores;
    private static HashMap<String,Tipo> tipos;
    public static List<Localizador> getLocalizadores(){
        if(localizadores == null){
            localizadores = new ArrayList<>();
        }
        return localizadores;

    }



    public static HashMap<String,Tipo> getTipos(){
        if(tipos == null)
        {
            tipos = new HashMap<>();
            tipos.put("Reserva",new Tipo("Reserva"));
            tipos.put("Boleto",new Tipo("Boleto"));
            tipos.put("Comida",new Tipo("Comida"));
            tipos.put("Transporte",new Tipo("Transporte"));

        }

        return tipos;
    }

    public static int calcularDescuentos(Localizador localizador,Cliente cliente){
        int desc = 0;
        ArrayList<Localizador> localizadores_cliente = (ArrayList<Localizador>) localizadores.stream()
                .filter(x->x.getCliente().getDni()==cliente.getDni()).collect(Collectors.toList());
        long cant = localizadores_cliente.size();
        if(cant >= 2){
            desc += 5;
        }

        HashMap<String,Tipo> tiposAux = (HashMap<String, Tipo>) getTipos().clone();
        HashMap<String,Integer> apariciones = new HashMap<>();
        for (Map.Entry<String, Tipo> tip: tiposAux.entrySet()
             ) {
            apariciones.put(tip.getKey(),0);
        }
        System.out.println(tiposAux.toString());


        for (Item item: localizador.getItems())
        {
            if(tiposAux.get(item.getTipo().getNombre()) != null){
                tiposAux.remove(item.getTipo().getNombre());
            }
            apariciones.put(item.getTipo().getNombre()
                    ,apariciones.get(item.getTipo().getNombre()) + 1);


        }

        if(tiposAux.size() == 0){
            desc += 10;
        }else
            {
            if(apariciones.get("Reserva") >= 2
            ){
                List<Item> reservas = localizador.getItems().stream()
                        .filter(x->x.getTipo().getNombre() == "Reserva")
                        .collect(Collectors.toList());
                for (Item reserv: reservas
                     ) {
                    reserv.aplicarDescuento();
                }
                List<Item> itemsAnteriores =localizador.getItems().stream()
                        .filter(x->x.getTipo().getNombre() != "Reserva")
                        .collect(Collectors.toList());
                itemsAnteriores.addAll(reservas);
                localizador.setItems(itemsAnteriores);
            }

                if(apariciones.get("Boleto") >= 2
                ){
                    List<Item> boletos = localizador.getItems().stream()
                            .filter(x->x.getTipo().getNombre() == "Reserva")
                            .collect(Collectors.toList());
                    for (Item bol: boletos
                    ) {
                        bol.aplicarDescuento();
                    }
                    List<Item> itemsAnteriores =localizador.getItems().stream()
                            .filter(x->x.getTipo().getNombre() != "Boleto")
                            .collect(Collectors.toList());
                    itemsAnteriores.addAll(boletos);
                    localizador.setItems(itemsAnteriores);
                }

        }

        return desc;
    }
}
