package Ejercicio3;

public abstract class Animal<T extends Animal> {

    public abstract void emitirSonidos();

    public static <T extends Animal> void comerAnimal(T animal){
        animal.emitirSonidos();
    }

}
