import java.time.LocalDate;

public class Partido {

    Equipo local;
    Equipo visitante;
    LocalDate fecha;
    int golesLocal;
    int golesVisitante;

    public Partido(Equipo local, Equipo visitante, LocalDate fecha, int golesLocal, int golesVisitante) {
        this.local = local;
        this.visitante = visitante;
        this.fecha = fecha;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    public void marcarGolVisitante(){
        golesVisitante++;
    }

    public void marcarGolLocal(){
        golesLocal++;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "local=" + local +
                ", visitante=" + visitante +
                ", fecha=" + fecha +
                ", golesLocal=" + golesLocal +
                ", golesVisitante=" + golesVisitante +
                '}';
    }
}
