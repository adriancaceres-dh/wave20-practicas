package Ejercicio3.Clases;

public abstract class Animal {

    private Animal animal;
    private String gustoAlimenticio;

    public String getGustoAlimenticio() {
        return gustoAlimenticio;
    }
    private AdaptadorComer adaptadorComer;

    public void setGustoAlimenticio(String gustoAlimenticio) {
        this.gustoAlimenticio = gustoAlimenticio;
    }

    public Animal(String gustoAlimenticio) {
        this.gustoAlimenticio = gustoAlimenticio;


    }
    public AdaptadorComer getAdaptadorComer() {
        return adaptadorComer;
    }

    public void setAdaptadorComer(AdaptadorComer adaptadorComer) {
        this.adaptadorComer = adaptadorComer;
    }


}
