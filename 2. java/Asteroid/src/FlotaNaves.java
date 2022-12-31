import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FlotaNaves implements ICalcularDistancia {

    List<Nave> flota;
    int []ubicacionNave1P1;
    int []ubicacionNave2P1;


    public FlotaNaves() {
        flota = new ArrayList<>();
        ubicacionNave1P1 = new int[]{(int) (Math.random() * 5 + 1), (int) (Math.random() * 5+ 1)};
        ubicacionNave2P1 = new int[]{(int) (Math.random() * 5 + 1), (int) (Math.random() * 5+ 1)};
        flota.add(new Nave("Nave1P1",ubicacionNave1P1));
        flota.add(new Nave("Nave2P1",ubicacionNave2P1));

    }
    @Override
    public String toString() {
        return "FlotaNaves{" +
                "flota=" + flota +
                '}';
    }

    public List<Nave> getFlota() {
        return flota;
    }

    public int[][] getUbicacionFlota(){

        int [][] ubicacionFlota = {this.ubicacionNave1P1, this.ubicacionNave2P1};

        return ubicacionFlota;
    }
    public void setFlota(List<Nave> flota) {
        this.flota = flota;
    }

    @Override
    public int calcularDistancia(int x, int y) {
        int distanciaNave1 = (int) Math.sqrt(Math.pow((x-flota.get(0).getUbicacionNave()[0]),2) + Math.pow((y-flota.get(0).getUbicacionNave()[1]),2));
        int distanciaNave2 = (int) Math.sqrt(Math.pow((x-flota.get(1).getUbicacionNave()[0]),2) + Math.pow((y-flota.get(1).getUbicacionNave()[1]),2));

        return distanciaNave1 +distanciaNave2/2;
    }
}
