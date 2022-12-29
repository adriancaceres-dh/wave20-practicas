public class Main {
    public static void main(String[] args) {
      PracticaExcepciones division = new PracticaExcepciones();
      division.dividendo = 0;
      division.divisor = 300;
      try {
          division.calcularCociente();
      }
      catch (Error error){
          System.out.println("Se ha producido un error");
      }
     finally {
          System.out.println("Programa finalizado");
      }

    }
}