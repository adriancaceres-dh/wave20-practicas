public class Main {
    public static void main(String[] args) {

        String cities[] = {"Londres","Madrid","Nueva York","Buenos Aires","Asunción","Sao Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int temperatures[][] = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int tempMin=temperatures[0][0], tempMax=temperatures[0][1];
        String minCity="", maxCity="";

        for (int i = 0; i < cities.length; i++) {
            if (tempMin > temperatures[i][0]) {
                tempMin = temperatures[i][0];
                minCity = cities[i];
            }
            if (tempMax < temperatures[i][1]) {
                tempMax = temperatures[i][1];
                maxCity = cities[i];
            }
        }

        System.out.println("Ciudad con menor temperatura: " + minCity + " " + tempMin +"ºC");
        System.out.println("Ciudad con mayor temperatura: " + maxCity + " " + tempMax +"ºC");

    }
}