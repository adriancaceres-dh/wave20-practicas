package poo.java;

import java.time.LocalDate;

public class Partido {
    Equipos local;
    Equipos visitante;
    LocalDate fecha;
    int golesDeLocal;
    int golesDeVisitante;

    public Partido(Equipos local, Equipos visitante, LocalDate fecha, int golesDeLocal, int golesDeVisitante) {
        this.local = local;
        this.visitante = visitante;
        this.fecha = fecha;
        this.golesDeLocal = golesDeLocal;
        this.golesDeVisitante = golesDeVisitante;
    }

    public void marcarGolVisitante(){
        golesDeVisitante++;
    }
    public void marcarGolLocal(){
        golesDeLocal++;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "local=" + local +
                ", visitante=" + visitante +
                ", fecha=" + fecha +
                ", golesDeLocal=" + golesDeLocal +
                ", golesDeVisitante=" + golesDeVisitante +
                '}';
    }
}
