package com.mercadolibre;

public class SeriePotenciaDeDos extends SerieNumerica <Integer> {
  private Integer current;

  public SeriePotenciaDeDos(Integer valorInicial) {
    this.current = nextPowerOf2(valorInicial);
  }

  public SeriePotenciaDeDos() {
    this.current = 0;
  }

  static int nextPowerOf2(int n)
  {
    int count = 0;

    // First n in the below
    // condition is for the
    // case where n is 0
    if (n > 0 && (n & (n - 1)) == 0)
      return n;

    while(n != 0)
    {
      n >>= 1;
      count += 1;
    }

    return 1 << count - 1;
  }

  @Override
  public Integer siguienteValor() {
    this.current = this.current * 2;
    return this.current;
  }

  @Override
  public void reiniciarSerie() {
    this.current = 0;
  }

  @Override
  public void definirValorInicial(Integer valor) {
    //next power of two
    this.current = nextPowerOf2(valor);
  }
}
