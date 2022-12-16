import java.util.*;

public class Main {
    public static void main(String[] args)
    {

        // Agrego datos de participantes
        List<String> DatosParticipante1 = new ArrayList<>();
        DatosParticipante1.add("5010");
        DatosParticipante1.add("Santiago");
        DatosParticipante1.add("Valdez");
        DatosParticipante1.add("25");
        DatosParticipante1.add("09918");
        DatosParticipante1.add("1234");
        DatosParticipante1.add("A");

        List<String> DatosParticipante2 = new ArrayList<>();
        DatosParticipante2.add("1111");
        DatosParticipante2.add("Luis");
        DatosParticipante2.add("Suarez");
        DatosParticipante2.add("35");
        DatosParticipante2.add("09911");
        DatosParticipante2.add("1234");
        DatosParticipante2.add("B");

        List<String> DatosParticipante3 = new ArrayList<>();
        DatosParticipante3.add("2222");
        DatosParticipante3.add("Lionel");
        DatosParticipante3.add("Messi");
        DatosParticipante3.add("34");
        DatosParticipante3.add("09922");
        DatosParticipante3.add("4321");
        DatosParticipante3.add("C");

        List<String> DatosParticipante4 = new ArrayList<>();
        DatosParticipante4.add("3333");
        DatosParticipante4.add("Gabriel");
        DatosParticipante4.add("Jesus");
        DatosParticipante4.add("34");
        DatosParticipante4.add("099333");
        DatosParticipante4.add("2131");
        DatosParticipante4.add("H");


        // Agrego participantes con sus claves.
        Map<Integer, List<String>> Participantes = new TreeMap<>();
        Participantes.put(1,DatosParticipante1);
        Participantes.put(2,DatosParticipante2);
        Participantes.put(3,DatosParticipante3);
        Participantes.put(4,DatosParticipante4);


        // Inscribo participantes
        Map<Integer, List> InscritposCircuitoChico = new TreeMap<>();
        InscritposCircuitoChico.put(1, Participantes.get(1));

        Map<Integer, List> InscritposCircuitoMedio = new TreeMap<>();
        InscritposCircuitoMedio.put(2, Participantes.get(2));
        InscritposCircuitoMedio.put(3, Participantes.get(3));

        Map<Integer, List> InscritposCircuitoAvanzado = new TreeMap<>();
        InscritposCircuitoAvanzado.put(4, Participantes.get(4));


        // Desincribo un participante
        InscritposCircuitoMedio.remove(3);


        // Listado de participantes inscriptos
        System.out.println("INSCRIPCIONES.");

        System.out.println("Circuito Chico : ");
        for(Map.Entry<Integer, List> insC : InscritposCircuitoChico.entrySet())
        {
            System.out.println(" -> " + insC);
            System.out.println(insC.getValue().get(3));

            /*if(insC.getValue().get(3) > 18)
            {
                System.out.println("Es mayor de edad");
            }
            else
            {
                System.out.println("No es mayor");
            }*/

        }

        System.out.println("Circuito Medio : ");
        for(Map.Entry<Integer, List> insM : InscritposCircuitoMedio.entrySet())
        {
            System.out.println(" -> " + insM);
        }

        System.out.println("Circuito Avanzado : ");
        for(Map.Entry<Integer, List> insA : InscritposCircuitoAvanzado.entrySet())
        {
            System.out.println(" -> " + insA);
        }
    }
}