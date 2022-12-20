package Complementarios_EJ2;

public class Nave {
    private String nombre;
    private int[][] coordenadas;
    private int puntuacion;

    public Nave(String nombre, int[][] coordenadas, int puntuacion) {
        this.nombre = nombre;
        this.coordenadas = coordenadas;
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int[][] getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(int[][] coordenadas) {
        this.coordenadas = coordenadas;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}
