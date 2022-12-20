package objetos;

public class Hierba <TIPO extends Animal> implements IHierba<TIPO>{
    @Override
    public void comerHierba(TIPO animal){
        System.out.println("Este animal come Hierba y emite el siguiente sonido: ");
        animal.emitirSonido();
    }
}
