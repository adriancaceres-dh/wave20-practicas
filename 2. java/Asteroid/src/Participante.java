import java.util.List;

public class Participante {
    String nombre;
    Nave nave;
    FlotaNaves flotaDeNaves;

    public Participante(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Nave getNave() {
        return nave;
    }

    public void setNave(Nave nave) {
        this.nave = nave;
    }

    public FlotaNaves getFlotaDeNaves() {
        return flotaDeNaves;
    }

    public void setFlotaDeNaves(FlotaNaves flotaDeNaves) {
        this.flotaDeNaves = flotaDeNaves;
    }
}
