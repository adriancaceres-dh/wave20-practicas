package animales;

import alimentacion.AlimentacionCarnivora;

public class Gato extends Animal {
    public Gato() {
        this.tipoAlimentacion = new AlimentacionCarnivora();
    }

    @Override
    public void hacerRuido() {
        System.out.println("Miau");
    }
}
