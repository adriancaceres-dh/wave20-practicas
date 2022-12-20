public class Gato extends Animal implements Carnivoro{
    @Override
    public String emitirSonido() {
        return "¡Miau!";
    }

    @Override
    public void comerCarne() {
        System.out.println("Gato comiendo carne...");
    }

    @Override
    public void comer(){
        comerCarne();
    }
}
