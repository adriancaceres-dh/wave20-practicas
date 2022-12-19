package animales;

import alimentacion.AlimentacionHerbivora;

public class Vaca extends Animal{
    public Vaca() {
        this.tipoAlimentacion = new AlimentacionHerbivora();
    }

    @Override
    public void hacerRuido() {
        System.out.println("Muuu");
    }
}
