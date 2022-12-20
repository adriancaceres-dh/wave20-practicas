package objetos;

import java.util.ArrayList;
import java.util.List;

public class Curriculum {
    private Persona atributos;
    private List<String> habilidades;

    public Curriculum(Persona atributos) {
        this.atributos = atributos;
        this.habilidades = new ArrayList<>();
    }

    public Persona getAtributos() {
        return atributos;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setAtributos(Persona atributos) {
        this.atributos = atributos;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    public void addHabilidad(String habilidad){
        habilidades.add(habilidad);
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "atributos=" + atributos +
                ", habilidades=" + habilidades +
                '}';
    }
}
