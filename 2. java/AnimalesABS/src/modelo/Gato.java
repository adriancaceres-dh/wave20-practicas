package modelo;

public class Gato extends Animal{

    public Gato(String tipo) {
        super(tipo);
    }

    @Override
    public void emitirSonido() {
        System.out.println("MIAU!!!");
    }
}
