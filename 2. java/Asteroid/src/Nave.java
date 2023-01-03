public class Nave implements ICalcularDistancia{
    String nombreNave;
    int [] ubicacionNave;
    int puntuacion;

    public String getNombreNave() {
        return nombreNave;
    }

    public void setNombreNave(String nombreNave) {
        this.nombreNave = nombreNave;
    }

    public int[] getUbicacionNave() {
        return ubicacionNave;
    }


    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Nave(String nombreNave, int[]ubicacionNave) {
        this.nombreNave = nombreNave;
        this.puntuacion=0;
        this.ubicacionNave = ubicacionNave;
    }

    @Override
    public int calcularDistancia(int x, int y) {

        return (int) Math.sqrt(Math.pow((x-this.ubicacionNave[0]),2) + Math.pow((y-this.ubicacionNave[1]),2));
    }
}
