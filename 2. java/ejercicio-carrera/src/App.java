import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App
{

    public static ArrayList inscribir_circuito(HashMap atributos,int dificultad,ArrayList inscripciones) {
        String edad = (String) atributos.get("edad");
        Integer edad_int = Integer.parseInt(edad);
        if (edad_int > 18) {
            System.out.println("Precio a pagar para el concursante DNI " + atributos.get("dni") + " es de :  ");
            switch (dificultad) {
                case 1: {
                    System.out.print("$" + 150);
                    ArrayList arr = (ArrayList) inscripciones.get(0);
                    atributos.put("nro",arr.size()+1);
                    arr.add(atributos);

                    inscripciones.set(0, arr);
                    return inscripciones;


                }

                case 2: {
                    System.out.print("$" + 2300);
                    ArrayList arr = (ArrayList) inscripciones.get(1);
                    atributos.put("nro",arr.size()+1);
                    arr.add(atributos);

                    inscripciones.set(1, arr);
                    return inscripciones;

                }

                case 3: {
                    System.out.print("$" + 2800);
                    ArrayList arr = (ArrayList) inscripciones.get(2);
                    atributos.put("nro",arr.size()+1);
                    arr.add(atributos);

                    inscripciones.set(2, arr);
                    return inscripciones;

                }

                default: return inscripciones;

            }

        } else {
            System.out.println("Precio a pagar para el concursante DNI " + atributos.get("dni") + " es de :  ");
            switch (dificultad) {
                case 1: {
                    System.out.print("$" + 1300);
                    ArrayList arr = (ArrayList) inscripciones.get(0);
                    atributos.put("nro",arr.size()+1);
                    arr.add(atributos);

                    inscripciones.set(0, arr);
                    return inscripciones;

                }


                case 2: {
                    System.out.print("$" + 2000);
                    ArrayList arr = (ArrayList) inscripciones.get(1);
                    atributos.put("nro",arr.size()+1);
                    arr.add(atributos);

                    inscripciones.set(1, arr);
                    return inscripciones;
                }

                case 3: {
                    System.out.print("NO CUMPLE LA EDAD MINIMA REQUERIDA");

                    return inscripciones;
                }

                default:
                    {
                        return inscripciones;
                    }
            }

        }
    }


    public ArrayList eliminar_concursante(ArrayList inscripciones ,int nro_participante,int dificultad)
    {
        inscripciones.get(dificultad-1);
        inscripciones.remove(nro_participante-1);

        return inscripciones;

    }
    public static void main(String[] args) {
        HashMap<Integer,String[]> categorias = new HashMap<Integer, String[]>();


        ArrayList<ArrayList<HashMap>> inscripciones = new ArrayList<>();
        inscripciones.add(new ArrayList<>());
        inscripciones.add(new ArrayList<>());
        inscripciones.add(new ArrayList<>());

        HashMap<Integer,HashMap<String,String>> personas = new HashMap<>();
        int asignador_id = 1;

        //agregar un participante
        HashMap atrs = new HashMap();
        atrs.put("dni","42383966");
        atrs.put("edad","20");
        atrs.put("celular","3516247277");
        atrs.put("numero_emergencia","351123412");
        atrs.put("nombre","Juan");

        personas.put(asignador_id,atrs);

        asignador_id++;
        HashMap participante_dos = new HashMap();
        participante_dos.put("dni","41283463");
        participante_dos.put("edad","16");
        participante_dos.put("celular","3513137212");
        participante_dos.put("numero_emergencia","352323111");
        participante_dos.put("nombre","Melisa");


        personas.put(asignador_id,participante_dos);



        // asignar participantes a una carrera
        for (Map.Entry<Integer,HashMap<String,String>> atributo_pers:personas.entrySet()
             ) {

            int dif = (int) ( Math.random() * 3 + 1) ;
             inscripciones= inscribir_circuito(atributo_pers.getValue(),dif,inscripciones);
        }
        System.out.println();
        System.out.println(inscripciones.toString());

    }
}
