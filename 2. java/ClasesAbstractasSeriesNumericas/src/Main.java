import serieNumerica.Impares;

public class Main {
    public static void main(String[] args){
        Impares impar = new Impares();
        impar.iniciarSerie(1);
        System.out.println(impar.numSiguiente());
    }
}