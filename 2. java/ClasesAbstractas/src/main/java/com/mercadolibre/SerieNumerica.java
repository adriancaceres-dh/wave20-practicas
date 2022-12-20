package com.mercadolibre;

public abstract class SerieNumerica <T extends Number> {
  private T current;


  public abstract T siguienteValor();
  public abstract void reiniciarSerie();
  public abstract void definirValorInicial(T valor);

}
