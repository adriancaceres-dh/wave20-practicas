import com.bootcamp.Serie2;
import com.bootcamp.Serie3;

public class Main {
    public static void main(String[] args) {
        Serie2 serie2 = new Serie2();
        //Inicializar serie
        System.out.println("-----------Inicializar serie-------------");
        serie2.inicializarSerie(1);
        for (int i = 0; i < 4; i++) {
            System.out.println(serie2.proximoValorSerie());
        }

        //Reiniciar serie
        System.out.println("-----------Reiniciar serie-------------");
        serie2.reiniciarSerie();
        for (int i = 0; i < 4; i++) {
            System.out.println(serie2.proximoValorSerie());
        }

        Serie3 serie3 = new Serie3();
        //Reiniciar serie
        System.out.println("-----------Serie3 serie-------------");
        for (int i = 0; i < 4; i++) {
            System.out.println(serie3.proximoValorSerie());
        }
    }
}