import java.awt.*;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.List;
import java.util.regex.Pattern;

public class Main {
    private static Map<Integer, String[]> Circuitos = new IdentityHashMap<>();
    private static List<String[]> Participantes = new LinkedList<>() {
    };

    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args)
    {

        Circuitos.put(1, new String[]{"Circuito chico", "UnaDescripción", "1300", "1500"});
        Circuitos.put(2, new String[]{"Circuito chico", "UnaDescripción", "2000", "2300"});
        Circuitos.put(3, new String[]{"Circuito chico", "UnaDescripción", "NO_MENORES", "2800"});
        Circuitos = Collections.unmodifiableMap(Circuitos);

        System.out.println("Bienvenido!");
        boolean continuar = true;
        do
        {
            imprimirMenu();
            int opcionSeleccionada = input.nextInt();
            input.nextLine();

            switch (opcionSeleccionada) {
                case 1:
                    for(String[] p : Participantes)
                    {
                        if(p[0].equals("ACTIVO"))
                        {
                            System.out.println("Numero de inscripcion "+Participantes.indexOf(p));
                            for(String s : p)
                                System.out.print(s +" - ");
                            System.out.println("Precio abonado: " + GetPrecio(Integer.valueOf(p[1]), Integer.valueOf(p[5])));
                            System.out.print("-----------------------");
                        }
                    }
                    break;

                case  2:

                    System.out.println("Ingrese DNI/CI");
                    String dni = input.nextLine();

                    System.out.println("Ingrese su primer nombre");
                    String nombre = input.nextLine();

                    System.out.println("Ingrese apellido");
                    String apellido = input.nextLine();

                    System.out.println("Ingrese celular");
                    String celular = input.nextLine();

                    System.out.println("Contacto de emergencia");
                    String contactoEmergencia = input.nextLine();

                    System.out.println("Grupo sanguineo");
                    String grupoSanguineo = input.nextLine();

                    System.out.println("Ingrese edad del participante en años");
                    int edad = input.nextInt();
                    input.nextLine();
                    System.out.println("A que circuito desea inscribirse?");
                    int circuito = input.nextInt();
                    input.nextLine();
                    if(circuito==1||circuito==2||(circuito==3 && edad>=18))
                        Participantes.add(new String[]{"ACTIVO" ,String.valueOf(circuito) , dni , nombre, apellido, String.valueOf(edad), celular, contactoEmergencia, grupoSanguineo});
                    else
                        System.out.println("No se pudo completar la inscricion");
                    break;

                case 3:
                    System.out.println("Ingrese el numero de inscripcion");
                    int nroInscripto = input.nextInt();
                    input.nextLine();
                    try
                    {
                        Participantes.get(nroInscripto)[0] = "INACTIVO";
                    }catch (IndexOutOfBoundsException exc)
                    {
                        System.out.println("No existe un participante con ese numero de inscripcion");
                    }

                    break;

            }
            System.out.println("Desea continuar?");
            continuar = usuarioQuiereContinuar();
        }while(continuar);
    }
    private static void imprimirMenu (){
        System.out.println("Ingrese el nro correspondiente a la opcion que desea seleccionar:");
        System.out.println("1 - Obtener datos de inscriptos a los distintos circuitos");
        System.out.println("2 - Inscribir un participante a una categoria");
        System.out.println("3 - Desinscribir un participante de una categoria");
    }
    private static boolean usuarioQuiereContinuar (){
        System.out.println("Y/n");
        char c = Character.toLowerCase(input.next(Pattern.compile("[yn]", Pattern.CASE_INSENSITIVE)).charAt(0));
        return Character.compare(c, 'y')==0;
    }
    private static double GetPrecio (int keyCircuito, int edad){
        if(edad>=18)
            return Double.valueOf(Circuitos.get(keyCircuito)[3]);
        return Double.valueOf(Circuitos.get(keyCircuito)[2]);

    }
}