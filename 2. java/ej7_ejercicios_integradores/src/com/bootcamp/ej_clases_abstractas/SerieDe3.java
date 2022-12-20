package com.bootcamp.ej_clases_abstractas;

public class SerieDe3 extends Prototipo<Double>{

    public SerieDe3(){
        super(3.0,0.0);
    }

    @Override
    public Double devolverSiguiente() {
        super.valor_actual+=super.numero_serie;
        return super.valor_actual;
    }

    @Override
    public void reiniciarSerie() {
        super.valor_actual=0.0;
    }

    @Override
    public void establecerValorInicial(Double valor) {
        super.valor_actual=valor;
    }
}
