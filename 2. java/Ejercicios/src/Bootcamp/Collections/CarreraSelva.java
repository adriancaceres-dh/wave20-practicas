package Bootcamp.Collections;
import java.util.*;

public class CarreraSelva {
    public static void main(String[] args) {

        Map<Integer, Integer> dniMap = new TreeMap<>();
        Map<Integer, String> nameMap = new TreeMap<>();
        Map<Integer, String> secondNameMap = new TreeMap<>();
        Map<Integer, Integer> ageMap = new TreeMap<>();
        Map<Integer, Integer> phoneMap = new TreeMap<>();
        Map<Integer, Integer> emergencyNumberMap = new TreeMap<>();
        Map<Integer, String> bloodTypeMap = new TreeMap<>();

        dniMap.put(1, 423445442);
        dniMap.put(2, 423424232);
        dniMap.put(3, 423342342);

        nameMap.put(1, "Alejandro");
        nameMap.put(2, "Stiven");
        nameMap.put(3, "Ivan");

        secondNameMap.put(1, "Torres");
        secondNameMap.put(2, "Gonzales");
        secondNameMap.put(3, "Amaro");

        ageMap.put(1, 20);
        ageMap.put(2, 26);
        ageMap.put(3, 20);

        phoneMap.put(1, 897986633);
        phoneMap.put(2, 897986633);
        phoneMap.put(3, 897986633);

        emergencyNumberMap.put(1, 2167127);
        emergencyNumberMap.put(2, 34127);
        emergencyNumberMap.put(3, 43127);

        bloodTypeMap.put(1, "O+");
        bloodTypeMap.put(2, "A+");
        bloodTypeMap.put(3, "O-");

        ArrayList<String> circuitoChico = new ArrayList<String>();
        ArrayList<String> circuitoMedio = new ArrayList<String>();
        ArrayList<String> circuitoAvanzado = new ArrayList<String>();
    }


}