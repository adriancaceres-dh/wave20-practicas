
class Temperatura {
    public static void main(String[] args) {
        String nombrePaises[] = new String[10];
        nombrePaises[0]="Londres";
        nombrePaises[1]="Madrid";
        nombrePaises[2]="Nueva York";
        nombrePaises[3]="Buenos Aires";
        nombrePaises[4]="Asuncion";
        nombrePaises[5]="Sao Paulo";
        nombrePaises[6]="Lima";
        nombrePaises[7]="Santiago de Chile";
        nombrePaises[8]="Lisboa";
        nombrePaises[9]="Tokio";

        int temperaturas[][] = new int[10][10];

        temperaturas[0][0]=-2;
        temperaturas[0][1]=33;
        temperaturas[1][0]=-3;
        temperaturas[1][1]=32;
        temperaturas[2][0]=-8;
        temperaturas[2][1]=27;
        temperaturas[3][0]=4;
        temperaturas[3][1]=37;
        temperaturas[4][0]=6;
        temperaturas[4][1]=42;
        temperaturas[5][0]=5;
        temperaturas[5][1]=43;
        temperaturas[6][0]=0;
        temperaturas[6][1]=39;
        temperaturas[7][0]=-7;
        temperaturas[7][1]=26;
        temperaturas[8][0]=-1;
        temperaturas[8][1]=31;
        temperaturas[9][0]=-10;
        temperaturas[9][1]=35;

        int min = temperaturas[0][0];
        int max = temperaturas[0][1];
        String nomPaisTemMax = nombrePaises[0];
        String nomPaisTemMin = nombrePaises[0];

        for(int f=0; f<=9; f=f+1){
            for(int c=0; c<=1; c=c+1){

                if(c==1){
                    if(max < temperaturas[f][c]){
                        max = temperaturas[f][c];
                        nomPaisTemMax = nombrePaises[f];
                    }
                }
                if(c==0){
                    if(min > temperaturas[f][c]){
                        min = temperaturas[f][c];
                        nomPaisTemMin = nombrePaises[f];
                    }
                }
            }
        }
        System.out.println("La temperatura mas baja es: " + min + "\n");
        System.out.println("El nombre de la ciudad que tiene la temperatura mas baja es: " + nomPaisTemMin + "\n");
        System.out.println("La temperatura mas alta es: " + max + "\n");
        System.out.println("El nombre de la ciudad que tiene la temperatura mas alta es: " + nomPaisTemMax + "\n");

    }

}