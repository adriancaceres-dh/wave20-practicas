package ej3;

public class Main {

    public static void main(String[] args) {
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

        vaca.emitirSonido();
        perro.emitirSonido();
        gato.emitirSonido();

        perro.comerAnimal(gato);
        gato.comerAnimal(perro);

    }
}
