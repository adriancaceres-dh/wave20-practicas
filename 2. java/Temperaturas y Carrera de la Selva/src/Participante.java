/**
 * Esta clase define los objetos que contendrán los datos de cada participante.

 * @author: Emanuel Fonseca
*/
public class Participante {

    // Variable que almacena el valor del DNI de la persona.
    private int dni;

    // Nombre de la persona.
    private String nombre;

    // Apellido de la persona.
    private String apellido;

    // Edad de la persona.
    private int edad;

    // Celular de la persona.
    private int celular;

    // Numero de emergencia en caso de llamar para la persona.
    private int numEmergencia;

    // Grupo sanguineo de la persona.
    private String grupoSanguineo;

    // Monto a pagar por la categoria ingresada del participante.
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

    // Obtención de los datos en un String entero del participante.
    public String getDatosParticipante(){
        return getDni() +" - "+ getNombre() +" - "+ getApellido() +" - "+ getEdad() +" - "+ getCelular() +" - "+ getNumEmergencia() +" - "+ getGrupoSanguineo();
    }
}
