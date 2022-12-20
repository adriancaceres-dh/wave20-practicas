package com.bootcamp.ej_clases_abstractas;

public class SerieDe2 extends Prototipo<Integer>{

    public SerieDe2 (){
        super(2,0);
    }

    @Override
    public Integer devolverSiguiente() {
        super.valor_actual+=super.numero_serie;
        return super.valor_actual;
    }

    @Override
    public void establecerValorInicial(Integer valor) {
        super.valor_actual=valor;
    }

    @Override
    public void reiniciarSerie() {
        super.valor_actual=0;
    }
}
