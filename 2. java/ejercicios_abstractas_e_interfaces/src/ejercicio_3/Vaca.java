package ejercicio_3;

public class Vaca extends Animal implements IHerviboro{
    @Override
    public void emitirSonido() {
        System.out.println("Muu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo hierba");
    }
}
