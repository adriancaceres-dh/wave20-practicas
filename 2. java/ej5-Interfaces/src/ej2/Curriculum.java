package ej2;

import java.util.List;

public class Curriculum implements IImprimible{
    Persona postulante;
    List<String> habilidades;

    public Curriculum(Persona postulante, List<String> habilidades) {
        this.postulante = postulante;
        this.habilidades = habilidades;
    }

    public Persona getPostulante() {
        return postulante;
    }

    public void setPostulante(Persona postulante) {
        this.postulante = postulante;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "postulante=" + postulante +
                ", habilidades=" + habilidades +
                '}';
    }
}
