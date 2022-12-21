import java.util.List;

public class Cliente {
    private String dni;
    private List<Localizador> localizadores;

    public Cliente(String dni, List<Localizador> localizadores) {
        this.dni = dni;
        this.localizadores = localizadores;
    }


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }
}