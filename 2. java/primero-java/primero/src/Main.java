public class Main {
    public static void main(String[] args) {

        String [] ciudades = {"Londres","Madrid","Nueva york","Buenos aires","Asuncion","Sao Pablo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int [][] temp = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int temp_min = temp[0][0];
        int temp_max = temp[0][1];
        String ciudad_record_min = "";
        String ciudad_record_max = "";

        for(int i = 0; i< ciudades.length; i++)
        {
            if(temp_min > temp[i][0])
            {
                ciudad_record_min = ciudades[i];
                temp_min = temp[i][0];
            }

            if(temp_max < temp[i][1])
            {
                ciudad_record_max = ciudades[i];
                temp_max = temp[i][1];
            }
        }

        System.out.println("La menor temperatura de todas es " + temp_min + " en la ciudad de -> " + ciudad_record_min);
        System.out.println("La temperatura mayor de todas es " + temp_max + " en la ciudad de -> " + ciudad_record_max);









    }
}