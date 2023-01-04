import Productos.*;
import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {

        Repositorio<Cliente> Clientes = new Repositorio<Cliente>();
        Repositorio<Localizador> Localizadores = new Repositorio<Localizador>();

        //Parte 1: Crear un localizador para un cliente completo, almacenar e imprimir resultado

        Clientes.Items.add(new Cliente("Andrea", "Ruiz Zorrilla", "5999999", 21));

        Collection<Producto> auxProdList = new ArrayList<>();

        auxProdList.add(new Hotel(50, "Reserva hotel 1", 2));
        auxProdList.add(new Comida(25, "Reserva ticket comida 1"));
        auxProdList.add(new Transporte(100, "Reserva ticket transporte 1"));
        auxProdList.add(new BoletoViaje(50, "Reserva hotel 1"));

        Localizadores.Items.add(
                new Localizador(
                        Clientes.Items.stream().filter(cli -> "5999999".equals(cli.getDNI())).findFirst().orElseThrow(),
                        auxProdList,
                        Localizadores.Items.stream().filter(localizador -> localizador.Cliente.getDNI()=="5999999").count()>=2));

        //Parte 1: Crear un localizador con dos reservas de transporte y hotel para el cliente anterior


        Collection<Producto> auxProdList2 = new ArrayList<>();

        auxProdList2.add(new Hotel(50, "Reserva hotel 1", 2));
        auxProdList2.add(new Transporte(100, "Reserva ticket transporte 1"));
        auxProdList2.add(new Hotel(50, "Reserva hotel 2", 2));
        auxProdList2.add(new Transporte(100, "Reserva ticket transporte 2"));

        Localizadores.Items.add(
                new Localizador(
                        Clientes.Items.stream().filter(cli -> "5999999".equals(cli.getDNI())).findFirst().orElseThrow(),
                        auxProdList2,
                        Localizadores.Items.stream().filter(localizador -> localizador.Cliente.getDNI()=="5999999").count()>=2));

        Collection<Producto> auxProdList3 = new ArrayList<>();

        auxProdList3.add(new Transporte(100, "Reserva ticket transporte 1"));

        Localizadores.Items.add(
                new Localizador(
                        Clientes.Items.stream().filter(cli -> "5999999".equals(cli.getDNI())).findFirst().orElseThrow(),
                        auxProdList3,
                        Localizadores.Items.stream().filter(localizador -> localizador.Cliente.getDNI()=="5999999").count()>=2));

        Localizadores.Items.stream().forEach(System.out::println);

    }
}