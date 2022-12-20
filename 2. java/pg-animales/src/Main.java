public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Perro();
        animals[1] = new Gato();
        animals[2] = new Vaca();

        for (Animal animal: animals) {
            System.out.println(animal.emitirSonido());
            animal.comer();
            animal.comerAnimal(new Perro());
            animal.comerAnimal(new Vaca());
            System.out.println();
        }
    }
}