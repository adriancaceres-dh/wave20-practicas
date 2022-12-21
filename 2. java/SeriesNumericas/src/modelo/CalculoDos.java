package modelo;

import prototipo.Prototipo;

public class CalculoDos extends Prototipo {

    private int numero2;
    private int valorInicial= 0;
    @Override
    public int valorSiguiente() {

            this.numero2 = this.numero2 +valorInicial;
            return this.numero2;
    }

    @Override
    public void reiniciarSerie() {

        this.numero2= 0;
        this.valorInicial=0;

    }

    @Override
    public void establecerValorInicial(int i) {

        this.valorInicial =i;
    }
}
