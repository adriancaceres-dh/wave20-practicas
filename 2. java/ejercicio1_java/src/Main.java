public class Main {
    public static void main(String[] args) {

        String[] ciudades ={"Londres","Madrid","Nueva York","Buenos Aires",
                "Asunción","Sao Paulo","Lima","Santiago de Chile",
                "Lisboa","Tokio"};
        int [][] temperaturas={{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43}
                ,{0,39},{-7,26},{-1,31},{-10,35}};

        int [] indices=new int[2];

        for (int i = 0; i < ciudades.length; i++) {
            if (temperaturas[i][0]<temperaturas[indices[0]][0]){
                indices[0]=i;
            }
            if (temperaturas[i][1]>temperaturas[indices[1]][1]){
                indices[1]=i;
            }
        }
        int minTemperatura=temperaturas[indices[0]][0];
        System.out.println("La ciudad con temperatura minima es : "+ciudades[indices[0]]+", con una temperatura de: "+minTemperatura);

        int maxTemperatura=temperaturas[indices[1]][1];
        System.out.println("La ciudad con temperatura maxima es : "+ciudades[indices[1]]+", con una temperatura de: "+maxTemperatura);

    }
}