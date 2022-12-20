public abstract class Proto {
    protected Integer numero_actual;
    private Integer numero_inicial;

    public void iniciar(Integer numero){
        numero_inicial = numero;
        reiniciar();
    }

    public void reiniciar(){
        numero_actual = numero_inicial;
    }

    public abstract Integer siguiente();
}
