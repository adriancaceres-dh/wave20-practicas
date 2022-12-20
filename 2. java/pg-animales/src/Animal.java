public abstract class Animal {
    public abstract String emitirSonido();
    public abstract void comer();
    public void comerAnimal(Animal animal) {
        //System.out.println("Gato comiendo un/a " + animal.getClass());
        animal.comer();
    }
}
