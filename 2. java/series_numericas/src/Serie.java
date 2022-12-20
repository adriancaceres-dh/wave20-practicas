public abstract class Serie {

    public static int valorInicial;
    public static int valorActual;

    abstract void siguiente();
    abstract  void reiniciarSerie();
    void establecerValorInicial(int i){
        valorInicial = i;
        reiniciarSerie();
    }
}
