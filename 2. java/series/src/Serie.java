public class Serie extends Prototipo<Integer>{

    public Serie(Integer valorIncremento) {
        super(0, valorIncremento, 0);
    }

    @Override
    public Integer valorSiguiente() {
        super.setValorActual(super.getValorActual() + super.getValorIncremento());
        return super.getValorActual();
    }

    @Override
    public void reiniciarSerie() {
        super.setValorInicial(0);
        super.setValorActual(0);
    }

    @Override
    public void valorInicial(Integer valor) {
        super.setValorInicial(valor);
        super.setValorActual(valor);
    }
}
