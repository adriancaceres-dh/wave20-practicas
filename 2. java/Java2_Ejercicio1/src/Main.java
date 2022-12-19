import java.util.*;

public class Main {

  public static void addNewParticipant( List<String>  participant ,  Map<Integer,  List<String>> participantList){
       for(Map.Entry<Integer,  List<String>> curPar : participantList.entrySet()){

          String curId = curPar.getValue().get(0);
          String curCat = curPar.getValue().get(7);

         if(curId.equals(participant.get(0))) {
             System.out.println("El participante ya esta inscrito en la categoria: "+curCat);
             menu(participantList);
         }
      }

      participantList.put(participantList.size()+1, participant);
      System.out.println("El participante fue inscrito exitosamente.");

      menu(participantList);
    }

    public static void  deleteParticipant( String participantDNI ,  Map<Integer,  List<String>> participantList){
        Map<Integer,  List<String>> auxParticipantList = new HashMap<>();

        for(Map.Entry<Integer,  List<String>> curPar : participantList.entrySet()){
            String curId = curPar.getValue().get(0);
            if(!curId.equals(participantDNI) ){
                auxParticipantList.put(curPar.getKey(), curPar.getValue());
            }
        }

        System.out.println(" EL participant fue eliminado exitosamente.");
        menu(auxParticipantList);
    }

    public static void showParticipantsXCategory( String category ,  Map<Integer,  List<String>> participantList) {
        System.out.println("_________________________"
                +'\n'+"Lista de participantes en categoría "
                +category
        );

        for(Map.Entry<Integer,  List<String>> curPar : participantList.entrySet()){
            String curCat = curPar.getValue().get(7);
            if(curCat.equals(category) ){
                System.out.println(curPar.getKey()+": "+curPar);
            }
        }
        menu(participantList);
    }

    public static void inscriptionProcess( Map<Integer,  List<String>> participantList){
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("Ingresar DNI:");
        String dni = scannerObj.nextLine();
        System.out.println("Ingresar nombres:");
        String name = scannerObj.nextLine();
        System.out.println("Ingresar apellidos:");
        String lastName = scannerObj.nextLine();
        System.out.println("Ingresar edad:");
        String age = scannerObj.nextLine();
        System.out.println("Ingresar celular:");
        String phoneNumber = scannerObj.nextLine();
        System.out.println("Ingresar número de emergencia:");
        String emergencyPhoneNumber = scannerObj.nextLine();
        System.out.println("Ingresar grupo sanguinio:");
        String bloodType = scannerObj.nextLine();
        String category = "";

        if(Integer.parseInt(age)<18){
            System.out.println("Menores de edad pueden partiicpar en 2 circuitos");
            System.out.println("Circuito chico es una carrera de 2 km por selva y arroyos.");
            System.out.println("Circuito medio es una carrera de 5 km por selva, arroyos y barro.");
            System.out.println("Ingresar 1 para seleccionar la categoría circuito chico y 2 para seleccionar circuito medio:");
            category = scannerObj.nextLine();
        }else{
            System.out.println("Mayores de edad pueden participar en 3 circuitos");
            System.out.println("Circuito chico es una carrera de 2 km por selva y arroyos.");
            System.out.println("Circuito medio es una carrera de 5 km por selva, arroyos y barro.");
            System.out.println("Circuito avanzado es una carrera de 10 km por selva, arroyos, barro y escalada en piedra.");
            System.out.println("Ingresar 1 para seleccionar la categoría circuito chico"+'\n'+" 2 para seleccionar circuito medio"+'\n'+" 3 para seleccionar circuito avanzado:");
            category = scannerObj.nextLine();
        }

        List<String>  participant = Arrays.asList(dni, name, lastName, age, phoneNumber, emergencyPhoneNumber, bloodType, category);


        if((Integer.parseInt(category) == 1)){
            if(Integer.parseInt(age)<18){
                System.out.println("Menores de edad deben abonar $1300 por el circuito chico.");
            }else{
                System.out.println("Mayores de edad deben abonar $1500 por el circuito chico.");
            }
        } else if(Integer.parseInt(category) == 2){
            if(Integer.parseInt(age)<18){
                System.out.println("Menores de edad deben abonar $2000 por el circuito medio.");
            }else{
                System.out.println("Mayores de edad deben abonar $2300 por el circuito medio.");
            }
        } else System.out.println("Se debe abonar $2800 por el circuito avanzado.");
        addNewParticipant(participant, participantList);
    }


    public static void menu (  Map<Integer,  List<String>> participantList){
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("Selecciona 1 si quieres agregar un participante nuevo");
        System.out.println("Selecciona 2 si quieres eliminar un participante");
        System.out.println("Selecciona 3 si quieres ver los participante inscritos en una categoría");
        System.out.println("Selecciona 4 si quieres salir del programa");

        String selectedOption = scannerObj.nextLine();
        if(selectedOption.equals("1")) inscriptionProcess(participantList);
        else if(selectedOption.equals("2")) {
            System.out.println("Para eliminar un participante por favor ingresar el DNI de lo contrario ingrese 1.");
            String dni = scannerObj.nextLine();
            if(dni.equals("0")) menu(participantList);
           else deleteParticipant(dni, participantList);
        }
        else if(selectedOption.equals("3")) {
            System.out.println("Para mostrar la lista de participantes inscritos ingrese 1 para ver categoría chico, 2 para ver categoría medio o 3 para ver categoría avanzada");
            String category = scannerObj.nextLine();
            showParticipantsXCategory(category, participantList);
        }
        else{
            throw new RuntimeException("El programa se cerro correctamente.");
        }

    }

    public static void main(String[] args) {
        Map<Integer,  List<String>> participantList = new HashMap<>();
        Main.menu(participantList);
    }
}