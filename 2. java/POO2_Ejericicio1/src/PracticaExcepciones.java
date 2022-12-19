public class PracticaExcepciones {
    int a;
    int b ;


    public PracticaExcepciones (){
        this.a = 0;
        this.b = 300;
    }

    public void calcularCociente (){
        double resultado;
        try{
            resultado = b/a;
        }catch(Exception e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally{
            System.out.println("Programa finalizado");
        }
    }

}
