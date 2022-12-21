package ejercicio_2;

public interface Imprimible{
    public static void imprimir(Imprimible imprimible){
        System.out.println("Imprimiendo.." + imprimible.toString());
    }

}
