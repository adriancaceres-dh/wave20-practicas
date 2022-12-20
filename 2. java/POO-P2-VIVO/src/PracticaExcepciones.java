public class PracticaExcepciones
{
    int a = 0;
    int b = 300;

   public void calcularCociente()
   {
       double resultado = b / a;

       if(a == 0)
       {
           throw new IllegalArgumentException("No se puede dividir por cero");
       }

       System.out.println(" Cociente: " + resultado);
   }
}
