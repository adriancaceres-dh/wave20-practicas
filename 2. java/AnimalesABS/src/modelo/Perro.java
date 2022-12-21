package modelo;

public class Perro extends Animal{
    public Perro(String tipo) {
        super(tipo);
    }

    @Override
    public void emitirSonido() {
        System.out.println("GUAU!!!");
    }


}
