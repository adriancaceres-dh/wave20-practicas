import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Cliente c1 = new Cliente(1234, "Juan", "peres");
        Cliente c2 = new Cliente(123456, "EXE", "Messi");
        Cliente c3 = new Cliente(123123, "Roman", "Riquelme");
        List<Cliente> listaClientes = Arrays.asList(c1,c2,c3);
        listaClientes.stream().forEach(System.out::println);

        Scanner sc = new Scanner(System.in);
        System.out.println("buscar x dni: ");
        Long dniBuscado = sc.nextLong();
        //listaClientes.stream().filter(dni -> dni.getDni() == dniBuscado);
        listaClientes.stream().forEach(
                dni->{
                    if(dni.getDni() == dniBuscado){
                        System.out.println("cliente encontrado: "+dni.toString());
                    }else{
                        System.out.println("Cliente no encontrado");
                    }
                }
        );
        listaClientes.stream().forEach(System.out::println);
    }
}