package bootcamp;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String[] paises = {"Londres","Madrid","Nueva York","Buenos Aires","Asunción","São Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int [][] temp = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};
        int tempMenor=-2;
        int tempMayor = 33;
        String paisMayor="";
        String paisMenor="";
        for (int i=0;i<paises.length;i++){
            if(temp[i][0]<tempMenor){
                tempMenor = temp[i][0];
                paisMenor = paises[i];
            }
            if(temp[i][1]>tempMayor){
                tempMayor = temp[i][1];
                paisMayor = paises[i];
            }
        }
        System.out.println("La menor temperatura fue: "+tempMenor+" en el pais: "+paisMenor);
        System.out.println("La mayor temperatura fue: "+tempMayor+" en el pais: "+paisMayor);
    }
}