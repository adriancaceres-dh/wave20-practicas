import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Hello!");
        int maxTempIndex = GetMaxTemperatureIndex(Temperatures.MinMaxTemperatures);
        int minTempIndex = GetMinTemperatureIndex(Temperatures.MinMaxTemperatures);
        System.out.print(String.format("La temperatura minima fue %d ", Temperatures.MinMaxTemperatures[minTempIndex][0]));
        System.out.println(String.format("en %s", Cities.CityName[minTempIndex]));

        System.out.print(String.format("La temperatura maxima fue %d ", Temperatures.MinMaxTemperatures[maxTempIndex][1]));
        System.out.println(String.format("en %s", Cities.CityName[maxTempIndex]));

        teclado.nextLine();
        teclado.close();
    }

    public static int GetMaxTemperatureIndex(int[][] temperatures)
    {
        int maxTemperature = temperatures[0][1];
        int maxTemperatureIndex = 0;

        for (int i =0; i<temperatures.length; i++)
        {
            if(maxTemperature<temperatures[i][1])
            {
                maxTemperature = temperatures[i][1];
                maxTemperatureIndex = i;
            }

        }
        return maxTemperatureIndex;
    }
    public static int GetMinTemperatureIndex(int[][] temperatures)
    {
        int minTemperature = temperatures[0][0];
        int minTemperatureIndex = 0;

        for (int i =0; i<temperatures.length; i++)
        {
            if(minTemperature>temperatures[i][0])
            {
                minTemperature = temperatures[i][0];
                minTemperatureIndex = i;
            }

        }
        return minTemperatureIndex;
    }
}