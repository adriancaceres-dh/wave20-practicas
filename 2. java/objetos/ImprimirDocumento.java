package objetos;

public class ImprimirDocumento {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Tammara", "26", "1111111", 60, 1.67);
        Curriculum nuevocurriculum = new Curriculum(persona1);
        Informe nuevoInforme = new Informe(50, "Rodolfo", "Maria", "Aqui encontraras toda la informacion sobre las diferencias entre lenguajes");
        LibroEnPDF nuevolibro = new LibroEnPDF(20, "sofia", "viendo el mundo cambiar", "Accion");
        IMostrarDocumento<Curriculum> mostrarDoc = new Mostrardocumento<Curriculum>();
        IMostrarDocumento<Informe> mostrarInforme = new Mostrardocumento<Informe>();
        IMostrarDocumento<LibroEnPDF> mostrarLibro = new Mostrardocumento<LibroEnPDF>();
        mostrarDoc.imprimirDocumento(nuevocurriculum);
        mostrarInforme.imprimirDocumento(nuevoInforme);
        mostrarLibro.imprimirDocumento(nuevolibro);
    }
}
