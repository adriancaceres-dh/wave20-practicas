public class Main {
    public static void main(String[] args) {
        SerieDeDos serie2 = new SerieDeDos();
        SerieDeTres serie3 = new SerieDeTres();

        serie2.iniciar(0);
        serie3.iniciar(0);

        for (int i=0; i<4; i++) System.out.println(serie2.siguiente());
        for (int i=0; i<4; i++) System.out.println(serie3.siguiente());
        
    }
}