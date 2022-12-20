package objetos;

public class Generico <TIPO>{
    private final TIPO tipoObjeto;

    public Generico(TIPO tipoObjeto) {
        this.tipoObjeto = tipoObjeto;
    }

    public void mostrar(){
        System.out.println("Esta es la clase del generico" + tipoObjeto.getClass().getName());
    }
}
