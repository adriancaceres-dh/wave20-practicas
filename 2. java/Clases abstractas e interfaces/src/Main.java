import Ejercicio1.Banco;
import Ejercicio1.Basic;
import Ejercicio1.Cobradores;
import Ejercicio1.Ejecutivos;
import Ejercicio3.Animal;
import Ejercicio3.Gato;
import Ejercicio3.Perro;
import Ejercicio3.Vaca;

public class Main {
    public static void main(String[] args) {
        System.out.println("##############EJERCICIO 1##############");
        Basic U1 = new Basic("Emanuel", "Fonseca");
        Cobradores C1 = new Cobradores("Adrián", "Cáceres");
        Ejecutivos E1 = new Ejecutivos("Diego", "Forlán");
        Banco ITAU = new Banco("ITAU");
        ITAU.agregarUsuariosBanco(U1);
        ITAU.agregarUsuariosBanco(C1);
        ITAU.agregarUsuariosBanco(E1);
        U1.realizarConsultaDeSaldo(1);
        C1.realizarRetiroDeEfectivo(1);
        E1.realizarTransferencia(1);
        System.out.println();

        System.out.println("##############EJERCICIO 2##############");
        System.out.println();

        System.out.println("##############EJERCICIO 3##############");
        Animal gatitoChico = new Gato("Bombona");
        Animal perroCiego = new Perro("Fatiga");
        Animal vacaLechera = new Vaca("Pompas");

        gatitoChico.emitirSonidos();
        perroCiego.emitirSonidos();
        vacaLechera.emitirSonidos();

        // ¿¿¿¿¿¿¿Cómo se puede hacer la parte extra??????
    }
}