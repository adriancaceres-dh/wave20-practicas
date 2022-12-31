public class Par extends Prototipo<Integer> {

    Integer valorParInicial;
    @Override
    public void getSiguienteNumero() {

        System.out.println(this.valorParInicial +=2);

    }

    @Override
    public String reiniciarSerie() {
        this.valorParInicial=0;
        return "Serie reestablecida correctamente";
    }

    @Override
    public void setValorInicial(Integer valor) {
        this.valorParInicial = valor;
    }


}

