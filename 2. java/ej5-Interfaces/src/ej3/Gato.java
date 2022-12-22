package ej3;

public class Gato extends Animal implements ICarnivoro{


    @Override
    public void emitirSonido() {
        System.out.println("miauu");
    }

    @Override
    public void comerCarne() {
        System.out.println("comer carne");
    }

    @Override
    public <T> void comerAnimal(T animal) {
        System.out.println("comiendo: " + animal.toString());
    }
}
