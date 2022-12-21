public class Main {
    public static void main(String[] args) {
        SerieDeDos serieDos = new SerieDeDos();
        for (int i = 0; i < 5; i++) {
            System.out.println(serieDos.getVrSiguiente());
        }
        serieDos.setVrInicial(1);
        serieDos.reiniciarSerie();
        for (int i = 0; i < 5; i++) {
            System.out.println(serieDos.getVrSiguiente());
        }

        SerieDeTres serieTres = new SerieDeTres();

        for (int i = 0; i < 5; i++) {
            System.out.println(serieTres.getVrSiguiente());
        }
    }
}