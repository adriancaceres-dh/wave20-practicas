public class Main {
    public static void main(String[] args) {
        Par par = new Par();
        par.setValorInicial(2);

        Impar impar = new Impar();
        impar.setValorInicial(3);
        for (int i = 0; i < 5; i++) {
            impar.getSiguienteNumero();

        }
    }
}