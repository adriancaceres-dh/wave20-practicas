import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Vehiculo fordFiesta = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo fordFocus = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo fordExplorer = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo fiatUno = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo fiatCronos = new Vehiculo("Fiat", "Cronos", 500);
        Vehiculo fiatTorino = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo chevyAveo = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo chevySpin = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo toyotaCorola = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo toyotaFortuner = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo renaultLogan = new Vehiculo("Renault", "Logan", 950);

        List<Vehiculo> vehiculosEnGaraje = Arrays.asList(fordFiesta,fordFocus,fordExplorer,fiatUno,fiatCronos, fiatTorino, chevyAveo, chevySpin,toyotaCorola,toyotaFortuner, renaultLogan);
        Garaje garaje1 = new Garaje(1, vehiculosEnGaraje);

        //sort y stream.sort
      /*  List<Vehiculo> sortedList = vehiculosEnGaraje.stream()
                .sorted(Comparator.comparingInt(Vehiculo::getCosto))
                .collect(Collectors.toList());
*/
        Comparator<Vehiculo> compararCosto = (Vehiculo vehiculo1 , Vehiculo vehiculo2) -> {
            if(vehiculo1.getCosto() < vehiculo2.getCosto()) return -1;
            if(vehiculo1.getCosto() == vehiculo2.getCosto()) return 0;
            return 1;
        };
        Comparator<Vehiculo> compararMarca = (Vehiculo vehiculo1 , Vehiculo vehiculo2) -> {
            if(vehiculo1.getMarca().compareTo(vehiculo2.getMarca())<0) return -1;
            if(vehiculo1.getMarca().compareTo(vehiculo2.getMarca())==0) return 0;
            return 1;
        };

        vehiculosEnGaraje.sort(compararCosto.thenComparing(compararMarca));
        System.out.println("Organizado por marca y costo: "+garaje1.toString());

        List<Vehiculo> menores1000 = vehiculosEnGaraje.stream().filter(vehiculo1 -> vehiculo1.getCosto()<1000).collect(Collectors.toList());
        System.out.println("Menores a 1000: "+menores1000);

        List<Vehiculo> mayores1000 = vehiculosEnGaraje.stream().filter(vehiculo1 -> vehiculo1.getCosto()>=1000).collect(Collectors.toList());
        System.out.println("Mayores a 1000: "+mayores1000);


        int totalCosto = vehiculosEnGaraje.stream().filter(o -> o.getCosto() > 0).mapToInt(o -> o.getCosto()).sum();
       double promedioCosto = totalCosto / vehiculosEnGaraje.size();
        System.out.println( "Promedio de los costos: "+promedioCosto);

        //   garaje1.setVehiculos(vehiculosEnGaraje);
   }
}