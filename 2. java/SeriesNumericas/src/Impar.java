public class Impar extends Prototipo<Integer>{

    Integer valorImparInicial;
    @Override
    public void getSiguienteNumero() {
        System.out.println(this.valorImparInicial+=3);
    }

    @Override
    public String reiniciarSerie() {
        this.valorImparInicial =0;
        return "Serie reiniciada correctamente";
    }

    @Override
    public void setValorInicial(Integer valor) {
        this.valorImparInicial=valor;

    }
}
