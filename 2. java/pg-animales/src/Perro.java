public class Perro extends Animal implements Carnivoro{
    @Override
    public String emitirSonido() {
        return "¡Guau!";
    }

    @Override
    public void comerCarne() {
        System.out.println("Perro desgarrando carne...");
    }

    @Override
    public void comer(){
        comerCarne();
    }
}
