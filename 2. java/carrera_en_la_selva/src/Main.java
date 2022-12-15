import java.util.*;

public class Main {
    final Scanner inputGetter = new Scanner(System.in);
    int counter = 0;
    HashMap<String, HashMap<Integer,String[]>> categorias;
    Set<String> dnisDeParticipantes = new HashSet<>();

    public void mostrarPorCategoria(String categoria){
        for(Map.Entry<Integer, String[]> participante : categorias.get(categoria).entrySet())
            System.out.println(participante.getKey() + ": " + participante.getValue());
    }

    public void borrarParticipante(){
        System.out.println("En que categoria se encuentra el participante que desea eliminar?");
        String categoria = getCategoria();
        System.out.println("Que participante desea eliminar?");
        mostrarPorCategoria(categoria);
        Integer idAEliminar = inputGetter.nextInt();
        var participantesDeCategoria = categorias.get(categoria);
        if(participantesDeCategoria.remove(idAEliminar) == null){
            System.out.println("No se encontro el participante en la categoria seleccionada.");
        }
    }

    public String getCategoria(){
        System.out.println("Categoria: 1 (Chico), 2 (Medio), 3 (Avanzado)");

        boolean check = false;
        String categoria = "";
        while(!check){
            switch (inputGetter.nextLine()) {
                case "Chico":
                case "1":
                    categoria = "Chico";
                    check = true;
                    break;
                case "Medio":
                case "2":
                    categoria = "Medio";
                    check = true;
                    break;
                case "Avanzado":
                case "3":
                    categoria = "Avanzado";
                    check = true;
                    break;
                default:
            }
        }
        return categoria;
    }

    public void agregarParticipante(){
        System.out.println("Ingrese el nombre:");
        String nombre = inputGetter.nextLine();
        System.out.println("Ingrese el apellido:");
        String apellido = inputGetter.nextLine();
        System.out.println("Ingrese el dni:");
        String dni = inputGetter.nextLine();
        System.out.println("Ingrese la edad:");
        Integer edad = inputGetter.nextInt();
        String categoria = getCategoria();

        if(dnisDeParticipantes.add(dni)){
            String[] participante = {nombre, apellido, dni};
            var participantesPorCategoria = categorias.get(categoria);
            participantesPorCategoria.put(counter++, participante);
        }else{
            System.out.println("El participante ya se encuentra inscripto.");
        }
    }
    public static void main(String[] args) {


    }
}