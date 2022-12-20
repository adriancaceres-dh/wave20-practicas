package prototipo;

public class SusesionUnoGenValor extends Prototipo <Integer>{
    private Integer valorInicial;
    private Integer valorSerie;
    private Integer valorActual;

    public SusesionUnoGenValor(Integer valorInicial, Integer valorSerie, Integer valorActual) {
        this.valorInicial = valorInicial;
        this.valorSerie = valorSerie;
        this.valorActual = valorActual;
    }

    public Integer getValorInicial() {
        return valorInicial;
    }

    public Integer getValorSerie() {
        return valorSerie;
    }

    public Integer getValorActual() {
        return valorActual;
    }

    public void setValorInicial(Integer valorInicial) {
        this.valorInicial = valorInicial;
    }

    public void setValorSerie(Integer valorSerie) {
        this.valorSerie = valorSerie;
    }

    public void setValorActual(Integer valorActual) {
        this.valorActual = valorActual;
    }

    public Integer valorSiguienteDeLaSerie(){
        this.valorActual = this.valorActual + this.valorSerie;
        return this.valorActual;
    }


    public void reiniciarSerie(){
        this.valorActual = 0;
        this.valorInicial =0;
        this.valorSerie = 0;
    }

    public void establecerValorInicialSerie(Integer valorInicial){
        this.valorInicial = valorInicial;
        this.valorActual = valorInicial;

    }
}
