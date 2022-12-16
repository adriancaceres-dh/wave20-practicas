package com.bootcamp.app;


import java.util.*;

public class app {
    public static void main(String[] args) {

        int indexParticipante = 0, fila = 0;
        boolean bandera = true;
        Map<String,List<Integer>> listadoPorCircuito = new HashMap<>();
        //"Chico" = {1,2,4,6}
        Map<Integer, String[]> participantes = new HashMap<>();
        List<Integer> numeroParticipanteChico = new ArrayList<>();
        List<Integer> numeroParticipanteMedio = new ArrayList<>();
        List<Integer> numeroParticipanteAvanzado = new ArrayList<>();
        String[][] nuevoParticipante = new String[4][8];

        //dni, nombre, apellido, edad, celular, número de emergencia y grupo sanguíneo, precio

        String tipoCircuito ="";
        Scanner s = new Scanner(System.in);

        while(bandera){
            System.out.println("Tipo de circuito para el participantes | Chico-Medio-Avanzado");
            tipoCircuito = s.nextLine();
            if(!tipoCircuito.equals("Chico") && !tipoCircuito.equals("Medio") && !tipoCircuito.equals("Avanzado")){
                System.out.println("Circuito invalido, por favor intente de nuevo");
                continue;
            }
            if(numeroParticipanteChico.contains(fila) || numeroParticipanteMedio.contains(fila)
                    || numeroParticipanteAvanzado.contains(fila)){
                System.out.println("El participante ya esta inscrito");
                continue;
            }
            System.out.println("Ingrese dni del participante "+ fila+1);
            nuevoParticipante[fila][0] = s.nextLine();
            System.out.println("Ingrese nombre del participante "+ fila+1);
            nuevoParticipante[fila][1] = s.nextLine();
            System.out.println("Ingrese apellido del participante "+ fila+1);
            nuevoParticipante[fila][2] = s.nextLine();
            System.out.println("Ingrese edad del participante "+ fila+1);
            nuevoParticipante[fila][3] = s.nextLine();
            System.out.println("Ingrese celular del participante "+ fila+1);
            nuevoParticipante[fila][4] = s.nextLine();
            System.out.println("Ingrese numero de emergencia del participante "+ fila+1);
            nuevoParticipante[fila][5] = s.nextLine();
            System.out.println("Ingrese grupo sanguineo del participante "+ fila+1);
            nuevoParticipante[fila][6] = s.nextLine();
            //agregar precio por participante
            nuevoParticipante[fila][7] = precioPorParticipante(nuevoParticipante[fila][3],tipoCircuito);
            while (nuevoParticipante[fila][7] == null){
                System.out.println("El participante es menor de edad no puede ingresar a este tipo de circuito, ingrese otro tipo");
                System.out.println("Tipo de circuito para el participantes ");
                tipoCircuito = s.nextLine();
                nuevoParticipante[fila][7] = precioPorParticipante(nuevoParticipante[fila][3],tipoCircuito);
            }
            participantes.put(fila,nuevoParticipante[fila]);
            switch (tipoCircuito){
                case("Chico"):
                    numeroParticipanteChico.add(fila);
                    listadoPorCircuito.put(tipoCircuito,numeroParticipanteChico);
                    break;
                case("Medio"):
                    numeroParticipanteMedio.add(fila);
                    listadoPorCircuito.put(tipoCircuito,numeroParticipanteMedio);
                    break;
                default:
                    numeroParticipanteAvanzado.add(fila);
                    listadoPorCircuito.put(tipoCircuito,numeroParticipanteAvanzado);
                    break;
            }

            System.out.println("Desea ingresar un nuevo participante? y/n");
            String respuesta = s.nextLine();
            bandera = (respuesta.equals("n"))? false:true;
            fila++;

        }
        System.out.println("Ingrese el tipo de carrera para ver sus participantes | Chico-Medio-Avanzado");
        String buscarPorCarrera = s.nextLine();
        mostrarParticipantesPorCategoria(listadoPorCircuito,participantes,buscarPorCarrera);

        //Borrar un participante
        System.out.println("El id del participante a eliminar");
        Integer idParticipante = Integer.valueOf(s.nextLine());
        System.out.println("Ingrese la categoria donde se desea eliminar");
        String categoriaCarrera = s.nextLine();
        listadoPorCircuito = mostrarParticipantesPorCategoria(listadoPorCircuito,idParticipante,categoriaCarrera);
        mostrarParticipantesPorCategoria(listadoPorCircuito,participantes,"Chico");


    }
    public static String precioPorParticipante(String edad, String circuito){
        String precio ="0";
        switch (circuito){
            case("Chico"):
                if(Integer.parseInt(edad)<18){
                    precio = "1300";
                }
                else{
                    precio = "1500";
                }
                break;
            case("Medio"):
                if(Integer.parseInt(edad)<18){
                    precio= "2000";
                }
                else{
                    precio = "2300";
                }
                break;
            default:
                if(Integer.parseInt(edad)<18){
                    precio =null;

                }
                else{
                    precio = "2300";
                }

        }
        return precio;
    }

    public static void  mostrarParticipantesPorCategoria(Map<String,List<Integer>> listadoPorCircuito
                ,Map<Integer, String[]> participantes,String tipoCircuito){

        List<Integer> ids =listadoPorCircuito.get(tipoCircuito);
        for (Integer id:ids) {
            String[] datosParticipante = participantes.get(id);

                StringBuilder sb = new StringBuilder();
                sb.append("\nid del participante").append("\t").append(id)
                        .append("\ndni del participante").append("\t").append(datosParticipante[0])
                        .append("\nNombre del participante").append("\t").append(datosParticipante[1])
                        .append("\nApellido del participante").append("\t").append(datosParticipante[2])
                        .append("\nEdad del participante").append("\t").append(datosParticipante[3])
                        .append("\nNumero de celular del participante").append("\t").append(datosParticipante[4])
                        .append("\nNumero de emergencia del participante").append("\t").append(datosParticipante[5])
                        .append("\nSanguineo del participante").append("\t").append(datosParticipante[6])
                        .append("\nPrecio de incripcion del participante").append("\t").append(datosParticipante[7]).append("\n");

            System.out.println("Datos del participante = " + sb.toString());
        }
    }

    public static Map<String, List<Integer>>  mostrarParticipantesPorCategoria(
            Map<String,List<Integer>> listadoPorCircuito,
            Integer id,String categoriaCarrera){

        List<Integer> pista = listadoPorCircuito.get(categoriaCarrera);

        if(pista.contains(id)){

            pista.remove(id);
            listadoPorCircuito.put(categoriaCarrera,pista);
            return listadoPorCircuito;
        }
        return listadoPorCircuito;
    }
}
