package objetos;

public class Mostrardocumento<TIPO> implements IMostrarDocumento<TIPO>{

    public Mostrardocumento() {
    }

    @Override
    public void imprimirDocumento( TIPO documento){
        System.out.println("Imprimo el documento correspondiente: " + documento.toString());

    }
}
