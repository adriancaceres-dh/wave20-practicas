package com.bootcamp;

public class PracticaExepciones{
    public static void dividir(int a)throws IllegalArgumentException {
           if(a>0){
               int b = 300;
               System.out.println(b/a);
           }else{
               throw new IllegalArgumentException("No se puede dividir por 0");
           }


    }

}
