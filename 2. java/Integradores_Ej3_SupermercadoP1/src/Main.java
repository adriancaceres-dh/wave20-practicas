import java.util.*;

public class Main {

    public static Cliente clienteNuevo(){
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("Ingresar DNI:");
        String dni = scannerObj.nextLine();
        System.out.println("Ingresar nombres:");
        String name = scannerObj.nextLine();
        System.out.println("Ingresar apellidos:");
        String lastName = scannerObj.nextLine();

        return new Cliente(dni,name,lastName);
    }

    public static Item itemNuevo(){
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("Ingresar código:");
        String codigo = scannerObj.nextLine();
        System.out.println("Ingresar nombre:");
        String nombre = scannerObj.nextLine();
        System.out.println("Ingresar costo:");
        String costo = scannerObj.nextLine();

        return new Item(Integer.parseInt(codigo), nombre, Integer.parseInt(costo));
    }

    public static Factura facturaNueva(Supermercado supermercado){
        Factura factura1 = new Factura();
        if(supermercado.getClientes().size()>0 && supermercado.getItems().size()>0){
            Scanner scannerObj = new Scanner(System.in);
            System.out.println("Ingresar DNI del cliente:");
            String dni = scannerObj.nextLine();
            Cliente infoCliente = supermercado.mostrarUnCliente(dni);
            if(infoCliente.getDni() != null){
                boolean agregarOtroItem = true;
                List<int[]> itemsSeleccionados = new ArrayList<>();
                int total = 0;

                while(agregarOtroItem){
                    System.out.println("Ingresar codigo de item comprado:");
                    String codigo = scannerObj.nextLine();
                    Item infoItem = supermercado.mostrarUnItem(Integer.parseInt(codigo));
                    if(infoItem.getNombre()!= null){
                        System.out.println("Ingresar la cantidad comprada del item "+infoItem.getNombre());
                        String cantidad = scannerObj.nextLine();
                        int totalItem = Integer.parseInt(cantidad) * infoItem.getCosto();
                        int[] itemAgregado = {infoItem.getCodigo(), Integer.parseInt(cantidad), totalItem};
                        itemsSeleccionados.add(itemAgregado);
                        total= total + totalItem;
                        supermercado.actualiarCantidadCompradaItem(infoItem.getCodigo(), Integer.parseInt(cantidad));
                        System.out.println("Pulse 1 para agregar otro item de lo contrario pulse 0.");
                        String agregarOtro = scannerObj.nextLine();
                        agregarOtroItem = !agregarOtro.equals("0");
                    }else{
                        System.out.println("Código no corresponde a item registrado.");
                        break;
                    }
                }
                factura1.setItemsComprados(itemsSeleccionados);
                factura1.setDniCliente(infoCliente.getDni());
                factura1.setTotal(total);
            }
            else{
                System.out.println("El cliente no existe");
            }
        }
        return factura1;
    }

    public static void menu (  Supermercado supermercado){
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("Gestión de clientes: ");
        System.out.println("Selecciona 1 si quieres agregar un cliente nuevo");
        System.out.println("Selecciona 2 si quieres eliminar un cliente");
        System.out.println("Selecciona 3 si quieres ver los clientes inscritos en el supermercado");
        System.out.println("Gestión de items: ");
        System.out.println("Selecciona 4 si quieres agregar un item nuevo");
        System.out.println("Selecciona 5 si quieres eliminar un item");
        System.out.println("Selecciona 6 si quieres ver los items registrados en el supermercado");
        System.out.println("Gestión de facturas: ");
        System.out.println("Selecciona 7 si quieres agregar una factura nuevo");
        System.out.println("Selecciona 8 si quieres ver las facturas registradas en el supermercado");

        System.out.println("_____________________________");
        System.out.println("Selecciona 9 si quieres salir del programa");
        String selectedOption = scannerObj.nextLine();

        switch (selectedOption) {
            case "1":
                Cliente cliente1 = clienteNuevo();
                supermercado.agregarCliente(cliente1);
                menu(supermercado);
                break;
            case "2":
                System.out.println("Ingresar DNI de cliente a eliminar:");
                String dniEliminar = scannerObj.nextLine();
                supermercado.eliminarCliente(dniEliminar);
                System.out.println("Cliente eliminado.");
                menu(supermercado);
                break;
            case "3":
                String listaMostrable = supermercado.mostrarClientes();
                System.out.println(listaMostrable);
                menu(supermercado);
                break;
            case "4":
                Item item1 = itemNuevo();
                supermercado.agregarItem(item1);
                menu(supermercado);
                break;
            case "5":
                System.out.println("Ingresar DNI de cliente a eliminar:");
                String codigoEliminar = scannerObj.nextLine();
                supermercado.eliminarItem(codigoEliminar);
                System.out.println("Item eliminado.");
                menu(supermercado);
                break;
            case "6":
                String listaMostrable1 = supermercado.mostrarItems();
                System.out.println(listaMostrable1);
                menu(supermercado);
                break;
            case "7":
                Factura factura1 = facturaNueva(supermercado);
                supermercado.agregarFactura(factura1);
                menu(supermercado);
                break;
            case "8":
                String listaMostrable2 = supermercado.mostrarFacturas();
                System.out.println(listaMostrable2);
                menu(supermercado);
                break;
            case "9":
                break;
        }


    }


    public static void main(String[] args) {
        Scanner scannerObj = new Scanner(System.in);

        Cliente cliente0 = new Cliente("123", "Pepito", "Perez");
        Cliente cliente1 = new Cliente("456", "Maria", "Lopez");
        Cliente cliente2 = new Cliente("789", "Juan", "Leon");
        Item item0 = new Item(100, "Pera", 1200);
        Item item1 = new Item(101, "Manzana", 1000);

        List<Cliente> listaClientes = Arrays.asList(cliente0, cliente1, cliente2);
        List<Item> listaItems = Arrays.asList(item0, item1);
        Supermercado elEconomico = new Supermercado();

        elEconomico.setClientes(listaClientes);
        elEconomico.setItems(listaItems);
    elEconomico.setFacturas(new ArrayList<>());
        menu(elEconomico);




      // if(clienteConsultado.getDni()!= null) System.out.println(clienteConsultado);
      // else System.out.println("No hay cliente con ese DNI registrado.");


    }
}