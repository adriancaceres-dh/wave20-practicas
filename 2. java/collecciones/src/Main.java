import java.util.*;

public class Main {

    public static Map<Integer,List<String>> listaCircuitoChico = new TreeMap<>();
    public static Map<Integer,List<String>> listaCircuitoMedio = new TreeMap<>();
    public static Map<Integer,List<String>> listaCircuitoGrande = new TreeMap<>();


    public static void main(String[] args) {

        //int numero[] = {10,12,-2,3};
        // Listas
       /* List<Integer> numeros = new ArrayList<>();
        numeros.add(10);
        numeros.add(12);
        numeros.add(-2);
        numeros.add(30);
        numeros.add(13);

        for(int numero : numeros){
            System.out.println(numero);
        }
        System.out.println(numeros.get(3));*/

        //Set(No admite objetos repetidos)
        //El HashSet no garantiza el orden
       /* Set<Integer> numeros = new HashSet<>();
        numeros.add(10);
        numeros.add(10);
        numeros.add(-2);
        numeros.add(30);
        numeros.add(13);

        for(int numero : numeros){
            System.out.println(numero);
        }*/
        //System.out.println(numeros.get(3));

        //El TreeSet si garantiza el orden
        /*Set<Integer> numeros = new HashSet<>();
        numeros.add(10);
        numeros.add(10);
        numeros.add(-2);
        numeros.add(30);
        numeros.add(13);

        for(int numero : numeros){
            System.out.println(numero);
        }

        //Como organizar un array??
        int ns[] = {3,2,8,-8};
        System.out.println(Arrays.stream(ns).sorted());

        //LinkedList
        List<Integer> numerosLinked = new LinkedList<>();
        numerosLinked.add(10);
        numerosLinked.add(10);
        numerosLinked.add(-2);
        numerosLinked.add(30);
        numerosLinked.add(13);

        for(int numero : numerosLinked){
            System.out.println(numero);
        }

        //Mapas o Diccionario
        //HAshmap es sin orden y treemap es con orden;
        //Equipo de futbol y si llego al mundial
        Map<String, Boolean> mundial = new HashMap<>();
        mundial.put("Brasil",true);
        mundial.put("Mexico",false);
        mundial.put("Colombia",false);
        mundial.put("EEUU",true);
        mundial.put("Corea del Sur",true);

        System.out.println(mundial.get("EEUU"));*/

        //Ejercicio Practicos
        menu();


    }

    public static void menu(){
        boolean enMenu = true;
        Scanner opcionMenu = new Scanner(System.in);
        String menu = " \n CARRERA DE LA SELVA \n 1. Inscribir \n 2. Mostrar inscritos \n 3. Desinscribir participante \n 4. Determinar monto \n 5. Salir";
        while(enMenu){
            System.out.println(menu);
            int opcion = opcionMenu.nextInt();

            switch (opcion){
                case(1):
                    inscribir();
                    break;
                case(2):
                    mostrarInscritos();
                    break;
                case(3):
                    //desinscribir();
                    break;
                case(4):
                    //5calcularMonto();
                    break;
                case(5):
                    enMenu = false;
                    System.out.println("Gracias por utilizar el software");
            }
        }
    }

    public static void inscribir(){
        List<String> participante = new ArrayList<>();
        String dni;
        Scanner dato = new Scanner(System.in);
        Scanner opcionMenu = new Scanner(System.in);

        System.out.println("Por favor ingrese el DNI del participante");
        dni = dato.next();
        participante.add(dni);
        if(yaInscrito(dni)){
            System.out.println("El participante con DNI "+ dni +" ya se encuentra inscrito en alguna de las carreras");
            return;
        }
        System.out.println("Por favor ingrese el nombre del participante");
        participante.add(dato.next());
        System.out.println("Por favor ingrese el apellido del participante");
        participante.add(dato.next());
        System.out.println("Por favor ingrese el edad del participante");
        participante.add(dato.next());
        System.out.println("Por favor ingrese el celular del participante");
        participante.add(dato.next());
        System.out.println("Por favor ingrese el numero de emergencia del participante");
        participante.add(dato.next());
        System.out.println("Por favor ingrese el grupo sanguineo del participante");
        participante.add(dato.next());

        String tipoCarrera = " Seleccione el tipo de carrera al cual se desea incribir \n 1. Circuito Chico \n 2. Circuito Medio \n 3. Circuito Grande";
        System.out.println(tipoCarrera);
        int opcion = opcionMenu.nextInt();

        switch (opcion){
            case(1):
                listaCircuitoChico.put(listaCircuitoChico.size(), participante);
                break;
            case(2):
                listaCircuitoMedio.put(listaCircuitoMedio.size(), participante);
                break;
            case(3):
                listaCircuitoGrande.put(listaCircuitoGrande.size(), participante);
                break;
        }
    }

    public static void mostrarInscritos(){
        Scanner opcionMenu = new Scanner(System.in);
        String tipoCarrera = " Seleccione el tipo de carrera del cual desea ver los participantes \n 1. Circuito Chico \n 2. Circuito Medio \n 3. Circuito Grande";
        System.out.println(tipoCarrera);
        int opcion = opcionMenu.nextInt();

        switch (opcion){
            case(1):
                System.out.println(listaCircuitoChico);
                break;
            case(2):
                System.out.println(listaCircuitoMedio);
                break;
            case(3):
                System.out.println(listaCircuitoGrande);
                break;
        }
    }

    public static boolean yaInscrito(String dni){
        boolean yaInscrito = false;
        for(int i = 0; i < listaCircuitoChico.size(); i++){
            if(listaCircuitoChico.get(i).get(0).equals(dni)){
                yaInscrito = true;
                break;
            }
        }
        for(int i = 0; i < listaCircuitoMedio.size(); i++){
            if(listaCircuitoMedio.get(i).get(0).equals(dni)){
                yaInscrito = true;
                break;
            }
        }
        for(int i = 0; i < listaCircuitoGrande.size(); i++){
            if(listaCircuitoGrande.get(i).get(0).equals(dni)){
                yaInscrito = true;
                break;
            }
        }

        return yaInscrito;

    }

}