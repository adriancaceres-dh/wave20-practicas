
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
//solo puede inscribirse a una sola categoria
public class Carrera {
    Map<Integer,String[]> listaInscriptoCircuitoChico = new HashMap<>();
    Map<Integer,String[]> listaInscriptoCircuitoMedio = new HashMap<>();
    Map<Integer,String[]> listaInscriptoCircuitoAvanzado = new HashMap<>();

    Integer contadorInscriptos = 0;

    public void determinarMonto(){
        System.out.println("a cual desea inscribirse?");
        System.out.println("1-Circuito Chico");
        System.out.println("2-Circuito Medio");
        System.out.println("3-Circuito Avanzado");

        Scanner leer=new Scanner(System.in);
        System.out.println("instroduzca un número");
        int num = leer.nextInt();
        if(num == 1){
            System.out.println("Es mayor a 18 años?");
            System.out.println("1-Si");
            System.out.println("2-No");
            Scanner opcion=new Scanner(System.in);
            System.out.println("instroduzca un número");
            int op = opcion.nextInt();
            if(op==1){
                //Mayor a 18 años
                System.out.println("Debe abonar $1300");
            }
            if(op==2){
                System.out.println("Debe abonar $1500");
            }
        }
        if(num==2){
            System.out.println("Es mayor a 18 años?");
            System.out.println("1-Si");
            System.out.println("2-No");
            Scanner opcion=new Scanner(System.in);
            System.out.println("instroduzca un número");
            int op = opcion.nextInt();
            if(op==1){
                //Mayor a 18 años
                System.out.println("Debe abonar $2000");
            }
            if(op==2){
                System.out.println("Debe abonar $2300");
            }
        }
        if(num==3){
            System.out.println("No se aceptan menores de 18 años, usted debe abonar $2800");
        }
        menu();

    }

    public void desinscribir(){
        System.out.println("elije de donde quieres  desinscribir");
        System.out.println("1-Circuito Chico");
        System.out.println("2-Circuito Medio");
        System.out.println("3-Circuito Avanzado");

        Scanner numeroInscripcion=new Scanner(System.in);
        System.out.println("instroduzca el numero de inscripcion que quiere desenscribir");
        int numeroInscrip = numeroInscripcion.nextInt();

        Scanner leer=new Scanner(System.in);
        System.out.println("Ahora instroduzca su eleccion");
        int num = leer.nextInt();

        switch(num) {
            case 1:
                listaInscriptoCircuitoChico.remove(numeroInscrip);
                break;
            case 2:
                listaInscriptoCircuitoMedio.remove(numeroInscrip);
                break;
            case 3:
                 listaInscriptoCircuitoAvanzado.remove(numeroInscrip);
                break;
            default:
                System.out.println("Habitación 5");
        }
        System.out.println("*************Participante desinscripto con exito************");
        menu();
    }
    public void mostrarInscriptos(){
        System.out.println("Que inscriptos desea ver?");
        System.out.println("1-Inscriptos Circuito Chico");
        System.out.println("2-Inscriptos Circuito Medio");
        System.out.println("3-Inscriptos Circuito Avanzado");

        Scanner leer=new Scanner(System.in);
        System.out.println("instroduzca un número");
        int num = leer.nextInt();
        System.out.println("*************Datos de los inscriptos************");
        switch(num) {
            case 1:
                System.out.println("Inscriptos en Chico:");
                for(Map.Entry<Integer,String[]> entrada : listaInscriptoCircuitoChico.entrySet()){
                    System.out.println("numero de inscripcion:" +" "+entrada.getKey());
                    for(int i=0; i<entrada.getValue().length; i++){
                        System.out.println(entrada.getValue()[i] + " ");

                    }
                }
                break;
            case 2:
                System.out.println("Inscriptos en Medio:");
                for(Map.Entry<Integer,String[]> entrada : listaInscriptoCircuitoMedio.entrySet()){
                    System.out.println("numero de inscripcion:" +" "+entrada.getKey() );
                    for(int i=0; i<entrada.getValue().length; i++){
                        System.out.println(entrada.getValue()[i] + " ");

                    }
                }
                break;
            case 3:
                System.out.println("Inscriptos en Avanzado:");
                for(Map.Entry<Integer,String[]> entrada : listaInscriptoCircuitoAvanzado.entrySet()){
                    System.out.println("numero de inscripcion:" +" "+entrada.getKey() );
                    for(int i=0; i<entrada.getValue().length; i++){
                        System.out.println(entrada.getValue()[i] + " ");

                    }
                }
                break;
            default:
                System.out.println("Habitación 5");
        }

        menu();
    }

    public void inscribir() {
        contadorInscriptos++;
        //falta buscar que esa persona que se inscribe ya no este inscripta
        //Eso es hacer una funcion a parte y cuando ingresa el dni, buscar en los 3 arreglos que ya no este inscripto
        String datosDelInscripto[] = datosDeLaInscripcion();
        System.out.println("A cual desea inscribirse?");
        System.out.println("1-Inscripcion Circuito Chico");
        System.out.println("2-Inscripcion Circuito Medio");
        System.out.println("3-Inscripcion Circuito Avanzado");
        Scanner leer=new Scanner(System.in);
        System.out.println("instroduzca un número");
        int num = leer.nextInt();

        switch(num) {
            case 1:
                listaInscriptoCircuitoChico.put(contadorInscriptos,datosDelInscripto);
                break;
            case 2:
                listaInscriptoCircuitoMedio.put(contadorInscriptos,datosDelInscripto);
                break;
            case 3:
                listaInscriptoCircuitoAvanzado.put(contadorInscriptos,datosDelInscripto);
                break;
            default:
                System.out.println("Habitación 5");
        }
        System.out.println("*************La inscripcion ah sido realizada con exito************");
        menu();
    }
    public String[] datosDeLaInscripcion(){
        //dni, nombre, apellido, edad,celular, emergenia, grupo sanguineo, monto
        boolean inscripto = false;
        String dni;
        System.out.println("ingrese el dni del participante");
        Scanner ci = new Scanner(System.in);
        dni = ci.nextLine();
        //Tengo que verificar que el dni no este ya ingresado
        int numerDni = Integer.parseInt(dni);
        boolean yaInscripto = yaInscriptoEnCarrera(numerDni);
        while(yaInscripto){
            System.out.println("El dni ya se encuentra registrado, vuelva a intentarlo, ingrese nuevamente el dni");
            dni = ci.nextLine();
            numerDni = Integer.parseInt(dni);
            yaInscripto = yaInscriptoEnCarrera(numerDni);
        }
        String nombre;
        System.out.println("ingrese el nombre del participante");
        Scanner nom = new Scanner(System.in);
        nombre = nom.nextLine();
        String apellido;
        System.out.println("ingrese el apellido del participante");
        Scanner apelli = new Scanner(System.in);
        apellido = apelli.nextLine();
        String edad;
        System.out.println("ingrese la edad del participante");
        Scanner ed = new Scanner(System.in);
        edad = ed.nextLine();
        String celular;
        System.out.println("ingrese el celular del participante");
        Scanner cel = new Scanner(System.in);
        celular = cel.nextLine();
        String nroEmergencia;
        System.out.println("ingrese el numero de emergencia del participante");
        Scanner emergencia = new Scanner(System.in);
        nroEmergencia = emergencia.nextLine();
        String grupoSanguineo;
        System.out.println("ingrese el grupo sanguineo del participante");
        Scanner sanguineo = new Scanner(System.in);
        grupoSanguineo = sanguineo.nextLine();

        String infoParticipante[] = new String[7];
        infoParticipante[0] = dni;
        infoParticipante[1] = nombre;
        infoParticipante[2] = apellido;
        infoParticipante[3] = edad;
        infoParticipante[4] = celular;
        infoParticipante[5] = nroEmergencia;
        infoParticipante[6] = grupoSanguineo;
        return infoParticipante;
    }

    public boolean yaInscriptoEnCarrera(int dni){
        //Tengo que fijarme en los 3 arreglos a ver si no hay un dni igual al que quiero inscribir (hacerlo mas adeante)
        boolean yaInscripto = false;
        //Me fijo en la primera carrera
        int numerDniArreglo = 0;
        for(Map.Entry<Integer,String[]> entrada : listaInscriptoCircuitoChico.entrySet()){
            numerDniArreglo = Integer.parseInt(entrada.getValue()[0]);
            if( numerDniArreglo == dni){
                yaInscripto = true;
            }
        }
        if(!yaInscripto){
            for(Map.Entry<Integer,String[]> entrada : listaInscriptoCircuitoMedio.entrySet()){
                numerDniArreglo = Integer.parseInt(entrada.getValue()[0]);
                if( numerDniArreglo == dni){
                    yaInscripto = true;
                }
            }
        }
        if(!yaInscripto){
            for(Map.Entry<Integer,String[]> entrada : listaInscriptoCircuitoAvanzado.entrySet()){
                numerDniArreglo = Integer.parseInt(entrada.getValue()[0]);
                if( numerDniArreglo == dni){
                    yaInscripto = true;
                }
            }
        }
        return yaInscripto;
    }

    public void menu(){
        int num;
        System.out.println("Elija una opcion:");
        System.out.println("1-Inscribir a un nuevo participante");
        System.out.println("2-Mostrar inscriptos");
        System.out.println("3-Desinscribir a uno ya inscripto");
        System.out.println("4-determinar el monto a inscribirse");
        System.out.println("5-Salir");
        Scanner leer1=new Scanner(System.in);
        System.out.println("instroduzca un número");
        num = leer1.nextInt();
        switch(num) {
            case 1:
                inscribir();
                break;
            case 2:
                mostrarInscriptos();
                break;
            case 3:
                desinscribir();
                break;
            case 4:
                determinarMonto();
                break;
            default:
                System.out.println("Habitación 6");
        }

    }
    public static void main(String[] args) {
        int num;
        Carrera ejemplo = new Carrera();
        System.out.println("Elija una opcion:");
        System.out.println("1-Inscribir a un nuevo participante");
        System.out.println("2-Mostrar inscriptos");
        System.out.println("3-Desinscribir a uno ya inscripto");
        System.out.println("4-determinar el monto a inscribirse");
        System.out.println("5-Salir");
        Scanner leer=new Scanner(System.in);
        System.out.println("instroduzca un número");
        num = leer.nextInt();

        switch(num) {
            case 1:
                ejemplo.inscribir();
                break;
            case 2:
                ejemplo.mostrarInscriptos();
                break;
            case 3:
                ejemplo.desinscribir();
                break;
            case 4:
                ejemplo.determinarMonto();
                break;
            default:
                System.out.println("Habitación 6");
        }


    }

}
