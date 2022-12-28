package com.bootcamp;

//Extends Number (Java Generics Bounded Type Parameters) porque
// solo queremos aceptar genericos que sean números
// (restringimos los genericos que podemos recibir)
public abstract class Prototype <T extends Number> {

    //Variables protected para poder compartirlas con subclases
    protected T valorInicial;
    protected T valorActual;
    protected T valorSerie;

    public Prototype(T valorSerie) {
        this.valorSerie = valorSerie;
    }

    public abstract T valorSiguiente();
    public abstract void reiniciarSerie();

    public abstract void iniciarSerie(T nuevoValorInicial);


}
