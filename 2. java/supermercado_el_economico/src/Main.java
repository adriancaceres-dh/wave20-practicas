import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        RepositorioCliente repositorioCliente = new RepositorioCliente();
        repositorioCliente.save(new Cliente("Tomas","1007414252","Gonzalez"));
        repositorioCliente.save(new Cliente("Fernanda","1007414500","Villamizar"));
        repositorioCliente.save(new Cliente("Ronald","2007414252","Paez"));

        repositorioCliente.findAll().forEach(c -> System.out.println(c));

        repositorioCliente.deleteByDni("1007414500");

        System.out.println(repositorioCliente.findByDni("2007414252"));
    }

}
