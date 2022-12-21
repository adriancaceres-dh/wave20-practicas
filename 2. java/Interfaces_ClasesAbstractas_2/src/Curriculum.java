import java.util.ArrayList;
import java.util.List;

public class Curriculum implements IImpresion<Curriculum>{

    Persona persona;
    List<String> habilidades = new ArrayList();

    public Curriculum(Persona persona, List habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    public String getHabilidades() {
        String habilidadesStr="";
        for(String habilidad : this.habilidades){
            habilidadesStr+="\n"+ habilidad;
        }
        return habilidadesStr;
    }

    @Override
    public String toString() {
        return "nombre: " + this.persona.getNombreCompleto()+
                "\nedad: "+ this.persona.getEdad()+
                "\nhabilidades: "+ getHabilidades();
    }

    @Override
    public String imprimir(Curriculum documento) {
        return toString();
    }

}
