public class PracticaExcepciones {

    int a = 0;
    int b = 300;

    public double calcularCociente() {
        try {
            if(this.a == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("El programa se ha finalizado");
        }
        return this.b/this.a;
    }

}
