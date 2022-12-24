import universidad.*;

public class Main {
    public static void main(String[] args) {
        Universidad universidad = new Universidad();

        Personas soporteTecnico = new SoporteTecnico("Diego", "1000");
        Personas miembrosPersonal = new MiembrosPersonal("Alejandro", "1001");
        Personas estudiantes = new Estudiantes("Camilo", "10002");
        Estudiantes tutor = new Tutores("Alejandro", "1003");

        universidad.agregarPersonal(soporteTecnico);
        universidad.agregarPersonal(miembrosPersonal);
        universidad.agregarPersonal(estudiantes);
        universidad.agregarPersonal(tutor);


    }
}