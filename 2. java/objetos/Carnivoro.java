package objetos;

public class Carnivoro<TIPO extends Animal> implements ICarnivoro<TIPO>{

    public Carnivoro() {
    }
    @Override
    public void comerCarne(TIPO animal){
        System.out.println("Este animal come carne y emite el siguiente sonido: ");
        animal.emitirSonido();
    }

}
