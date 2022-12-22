import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Mundial qatar = new Mundial();
        Equipo visitante = new Equipo("Croacia");
        Equipo local = new Equipo("Japon");


        Partido partido = new Partido(local, visitante, LocalDate.of(2022,12,5),0,0);
        qatar.agregarPartido(partido);
        partido.marcarGolLocal();
        partido.marcarGolVisitante();

        System.out.println(qatar.cantidadPartidos()+ " Cantidad de goles: "+ qatar.cantidadDeGolesTotales());
    }
}