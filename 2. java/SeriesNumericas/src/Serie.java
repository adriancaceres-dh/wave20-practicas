public abstract class Serie<T extends Number> {
    T vrInicial;
    T vrSiguiente;

    public Serie() {
        this.vrInicial = (T)Integer.valueOf(0);
        this.vrSiguiente = (T)Integer.valueOf(0);
    }


    /**
     * Se establece un valor inicial distinto a 0 para la serie
     * @param vrInicial
     */
    public void setVrInicial(T vrInicial) {
        this.vrInicial = vrInicial;
    }

    /**
     *
     * @return el siguiente valor de la serie
     */
    public abstract T getVrSiguiente();

    /**
     * Reinicia la serie
     */
    public void reiniciarSerie() {
        vrSiguiente = vrInicial;
    }
}
