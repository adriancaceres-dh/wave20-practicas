package bootcamp;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        boolean salir = true;
        boolean eterno = true;
        int contadorParticipante =9;
        int numeroParticipante = 0 ;
        Set<String> unico = new HashSet<String>();
        Map<Integer,String[]> chico = new HashMap<>();
        Map<Integer,String[]> medio = new HashMap<>();
        Map<Integer,String[]> avanzado = new HashMap<>();


        inscribirAutomatico(unico,chico, medio, avanzado);
        while(eterno) {
            System.out.println("----Menu----");
            System.out.println("1.-Listar participantes");
            System.out.println("2.-Agregar participante");
            System.out.println("3.-Eliminar Participante");
            System.out.println("4.-Pago por participantes");
            switch (tec.nextLine()) {
                case "1":
                   listado(chico, medio,avanzado);

                    break;
                case "2":
                    inscribirParticipante(unico, contadorParticipante, tec, salir, chico, medio, avanzado);
                    break;
                case "3":
                    System.out.println("Numero del participante para eliminar");
                    numeroParticipante = tec.nextInt();
                    tec.nextLine();
                    System.out.println(eliminarParticipante(numeroParticipante, chico, medio, avanzado)?"Participante eliminado":"Participante no encontrado");
                    break;
                case "4":
                    System.out.println("Numero del participante para pago");
                    numeroParticipante = tec.nextInt();
                    tec.nextLine();
                    pagos(numeroParticipante, chico, medio, avanzado);
                    break;
                default:
                    break;
            }
        }
    }

    public static void listado(Map chico, Map medio,Map avanzado){
        System.out.println("lista Participantes circuito chico");
        chico.forEach((key, value) -> System.out.println("numero: " + key + " Participante: " + Arrays.toString((String[])value)));
        System.out.println("------------------------");
        System.out.println("lista Participantes circuito medio");
        medio.forEach((key, value) -> System.out.println("numero: " + key + " Participante: " + Arrays.toString((String[])value)));
        System.out.println("------------------------");
        System.out.println("lista Participantes circuito avanzado");
        avanzado.forEach((key, value) -> System.out.println("numero: " + key + " Participante: " + Arrays.toString((String[])value)));
    }
    public static void pagos(int numParticipante, Map chico, Map medio,Map avanzado){
        if(chico.containsKey(numParticipante)){

            String[] encontrado = (String[])chico.get(numParticipante);

            System.out.println( Integer.parseInt(encontrado[3])<18?"El participante debe pagar $1300":
                    "El participante debe pagar $1500");

        }
       else if(medio.containsKey(numParticipante)){
            String[] encontrado = (String[])medio.get(numParticipante);

            System.out.println( Integer.parseInt(encontrado[3])<18?"El participante debe pagar $2000":
                    "El participante debe pagar $2300");
        }
       else if(avanzado.containsKey(numParticipante)){
            System.out.println( "El participante debe pagar $2800");
        }
    }

    public static boolean eliminarParticipante(int numParticipante, Map chico, Map medio,Map avanzado){

        if(chico.containsKey(numParticipante)){
            chico.remove(numParticipante);
            return true;
        }
        if(medio.containsKey(numParticipante)){
            medio.remove(numParticipante);
            return true;
        }
        if(avanzado.containsKey(numParticipante)){
            avanzado.remove(numParticipante);
            return true;
        }
        return false;

    }

    public static void inscribirParticipante(Set unico, int contadorParticipante, Scanner tec, boolean salir, Map chico, Map medio, Map avanzado){
        while(salir){
            String[] person = new String[7];
            System.out.println("Inscribir participante");
            System.out.println("DNI");
            person[0] = tec.nextLine();
            if(!unico.add(person[0])){
                System.out.println("Persona Registrada");
                break;
            }
            System.out.println("Nombre");
            person[1] = tec.nextLine();
            System.out.println("Apellido");
            person[2] = tec.nextLine();
            System.out.println("Edad");
            person[3] = tec.nextLine();
            System.out.println("Fono");
            person[4] = tec.nextLine();
            System.out.println("Fono Emergencia");
            person[5] = tec.nextLine();
            System.out.println("Tipo Sangre");
            person[6] = tec.nextLine();
            System.out.println("Donde desea participar?");
            System.out.println("1:chico");
            System.out.println("2:medio");
            System.out.println("3:avanzado");
            contadorParticipante++;
            switch (tec.nextLine()) {
                case "1":
                    chico.put(contadorParticipante,person);
                    break;
                case "2":
                    medio.put(contadorParticipante,person);
                    break;
                default:
                    if(Integer.parseInt(person[3])>18){
                        avanzado.put(contadorParticipante, person);
                    }else{
                        System.out.println("No es posible por la edad del participante");
                        contadorParticipante--;
                    }

            }
            System.out.println("Inscripcion realizada");

            System.out.println(" Desea inscribir a otra persona? si o no");
            if (tec.nextLine().equals("no")) salir=false;
        }
    }

    public static void inscribirAutomatico(Set unico, Map chico, Map medio, Map avanzado){

        for(int i= 0; i < 10; i++){
            String[] persona = new String[]{"17671173-6", "arm", "bur", "29", "98897897", "976556", "ab+"};
            persona[0]=""+(int)(Math.random()*(22000000-10000000+1)+10000000)+"-"+(int)(Math.random()*9+1);
            unico.add(persona[0]);
            switch ((int)(Math.random()*3+1)) {
                case 1:
                    chico.put(i,persona);
                    break;
                case 2:
                    medio.put(i,persona);
                    break;
                default:
                    avanzado.put(i,persona);
            }

        }
    }
}