package animales;

import alimentacion.AlimentacionCarnivora;

public class Perro extends Animal{
    public Perro() {
        this.tipoAlimentacion = new AlimentacionCarnivora();
    }

    @Override
    public void hacerRuido() {
        System.out.println("Guau");
    }
}
