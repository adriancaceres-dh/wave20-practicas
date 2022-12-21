package Ejercicio3.Clases;

import Ejercicio3.Interfaces.IComer;

public class AdaptadorComer implements IComer {

    private String gustoAlimenticio;
    public AdaptadorComer(String gustoAlimenticio) {
        this.gustoAlimenticio = gustoAlimenticio;
    }

    @Override
    public void comer() {
        if(gustoAlimenticio.equals("Carnivoro")){
            System.out.println("Comiendo carne");
        } else if (gustoAlimenticio.equals("Herviboro")) {
            System.out.println("Comiendo hierbas");
        }
    }
}
