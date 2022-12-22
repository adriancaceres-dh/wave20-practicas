package ej3;

public class Vaca extends Animal implements IHervivoro{

    @Override
    public void emitirSonido() {
        System.out.println("muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("comer hierba");
    }
}
