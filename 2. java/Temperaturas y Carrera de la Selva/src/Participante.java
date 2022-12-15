public class Participante {
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private int celular;
    private int numEmergencia;
    private String grupoSanguineo;

    private int montoPagar;

    public Participante(int dni, String nombre, String apellido, int edad, int celular, int numEmergencia, String grupoSanguineo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numEmergencia = numEmergencia;
        this.grupoSanguineo = grupoSanguineo;
        this.montoPagar = 0;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public int getCelular() {
        return celular;
    }

    public int getNumEmergencia() {
        return numEmergencia;
    }

    public int getMontoPagar() {
        return montoPagar;
    }

    public void setMontoPagar(int montoPagar) {
        this.montoPagar = montoPagar;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public String getDatosParticipante(){
        return getDni() +" - "+ getNombre() +" - "+ getApellido() +" - "+ getEdad() +" - "+ getCelular() +" - "+ getNumEmergencia() +" - "+ getGrupoSanguineo();
    }
}
