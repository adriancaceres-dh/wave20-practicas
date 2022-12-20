package objetos;

public class Mensaje <V>{
    //Para crear una clase generica :)

    private V unObjeto;

    public Mensaje() {

    }

    public Mensaje(V unObjeto) {
        this.unObjeto = unObjeto;
    }

    public V getUnObjeto() {
        return unObjeto;
    }

    public void setUnObjeto(V unObjeto) {
        this.unObjeto = unObjeto;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "unObjeto=" + unObjeto +
                '}';
    }
}
