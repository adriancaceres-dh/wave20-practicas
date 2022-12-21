package modelo;

import prototipo.Prototipo;

public class Calculo extends Prototipo {

    private int numero;
    private int valorInicial = 0;


    @Override
    public int valorSiguiente() {
            return this.numero = this.numero+this.valorInicial;
    }

    @Override
    public void reiniciarSerie() {
        this.numero = 0;
        this.valorInicial = 0;

    }

    @Override
    public void establecerValorInicial(int i) {
        this.valorInicial= i;
    }


}
