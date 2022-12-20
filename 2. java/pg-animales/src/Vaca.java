public class Vaca extends Animal implements Hervivoro{
    @Override
    public String emitirSonido() {
        return "¡Muuu!";
    }

    @Override
    public void comerHierva() {
        System.out.println("Vaca comiendo hierva...");
    }

    @Override
    public void comer() {
        comerHierva();
    }
}
