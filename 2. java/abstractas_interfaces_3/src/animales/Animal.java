package animales;

import alimentacion.TipoAlimentacion;

public abstract class Animal {
    // Una suerte de patron de diseño Strategy para la alimentacion
    protected TipoAlimentacion tipoAlimentacion;

    public void comer(){
        tipoAlimentacion.alimentarse();
    }

    public abstract void hacerRuido();
}
