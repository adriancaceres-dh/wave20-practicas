package modelo;

public class Vaca extends Animal{

    public Vaca(String tipo) {
        super(tipo);
    }

    @Override
    public void emitirSonido() {
        System.out.println("MUUU!!!");
    }

}
