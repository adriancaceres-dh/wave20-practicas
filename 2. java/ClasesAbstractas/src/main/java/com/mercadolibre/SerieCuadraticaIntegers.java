package com.mercadolibre;

public class SerieCuadraticaIntegers extends SerieNumerica<Integer> {
  private Integer current;


  public SerieCuadraticaIntegers(Integer valorInicial) {
    this.current = valorInicial;
  }

  public SerieCuadraticaIntegers() {
    this.current = 0;
  }

  @Override
  public Integer siguienteValor() {
    this.current = (int) Math.pow(this.current, 2);
    return this.current;
  }

  @Override
  public void reiniciarSerie() {
    this.current = 0;
  }

  @Override
  public void definirValorInicial(Integer valor) {
    this.current = valor;
  }
}

