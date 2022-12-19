package model;

public class PracticaExcepciones {
    String a = "f";
    int b = 300;

    public double calculoCociente(){
        int cociente=0;
        try{
             cociente =  b/Integer.parseInt(a);
        }catch (IllegalArgumentException exception){
            System.out.println("no se puede dividir por 0: " + exception.getMessage());
        }
        System.out.println("programa finalizado");
        return cociente;
    }

}
