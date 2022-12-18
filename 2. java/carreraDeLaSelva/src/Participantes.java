public class Participantes {

    String dni;
    String nombre;
    String apellido;
    int edad;
    String celular;
    String celularAuxiliar;
    String grupoSanguineo;
    int categoria;

    int inscripcion;

    public Participantes(String dni, String nombre, String apellido, int edad, String celular, String celularAuxiliar, String grupoSanguineo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.celularAuxiliar = celularAuxiliar;
        this.grupoSanguineo = grupoSanguineo;
        this.categoria = 0;
        this.inscripcion=0;
    }

    public boolean agregarCategoria(int categoria){
        if(categoria==1){
            this.categoria =1;
            if(this.edad>18){
                this.inscripcion=1500;
            }else{
                this.inscripcion=1300;
            }
            return true;
        } else if (categoria==2) {
            this.categoria=2;
            if(this.edad>18){
                this.inscripcion=2300;
            }else{
                this.inscripcion=2000;
            }
            return true;
        } else if (categoria==3) {
            if(this.edad>18){
                this.categoria=3;
                this.inscripcion=2800;
                return true;
            }else{
                return false;
            }

        }
        return false;
    }

    @Override
    public String toString() {
        return "Participantes{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", celular='" + celular + '\'' +
                ", celularAuxiliar='" + celularAuxiliar + '\'' +
                ", grupoSanguineo='" + grupoSanguineo + '\'' +
                ", categoria=" + categoria +
                ", inscripcion=" + inscripcion +
                '}';
    }
}
