import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    // ⚠️ No se aplica nada de POO, es solo utilizando lo visto hasta el momento ⚠️

    final static String CIRCUITO_CHICO = "Circuito chico";
    final static String CIRCUITO_MEDIO = "Circuito medio";
    final static String CIRCUITO_AVANZADO = "Circuito avanzado";
    static int currentRegistrationNumber = 0;

    static List<Integer> inscriptionNumbers = new ArrayList<>();
    static List<Integer> dnis = new ArrayList<>();
    static List<String> names = new ArrayList<>();
    static List<String> surnames = new ArrayList<>();
    static List<Integer> ages = new ArrayList<>();
    static List<Integer> cellphones = new ArrayList<>();
    static List<Integer> emergencyNumbers = new ArrayList<>();
    static List<String> bloodTypes = new ArrayList<>();
    static List<Integer> registrationCosts = new ArrayList<>();

    static Map<String, List<Integer>> circuitosInscriptions = new HashMap<>();

    private static void addCompetitorAndDisplay(String circuit, int dni, String name, String surname, int age, int cellphone, int emergencyNumber, String bloodType) throws Exception {
        int newInscriptionNumber = currentRegistrationNumber + 1;
        currentRegistrationNumber++;
        int registrationCost = getRegistrationCostIfPossible(circuit, age);

        inscriptionNumbers.add(newInscriptionNumber);
        dnis.add(dni);
        names.add(name);
        surnames.add(surname);
        ages.add(age);
        cellphones.add(cellphone);
        emergencyNumbers.add(emergencyNumber);
        bloodTypes.add(bloodType);
        registrationCosts.add(registrationCost);

        updateCircuitoInscriptions(circuit, newInscriptionNumber);
        displayCompetitorData(newInscriptionNumber, dni, surname, registrationCost);
    }

    private static void removeCompetitorFromCircuitoInscriptions(String circuit, int inscriptionNumberIndex) {
        List<Integer> circuitInscriptions = circuitosInscriptions.get(circuit);
        int indexToBeRemoved = circuitInscriptions.indexOf(inscriptionNumberIndex);
        circuitInscriptions.remove(indexToBeRemoved);
    }

    private static void removeCompetitorByInscriptionNumber(String circuit, int inscriptionNumber) {
        int inscriptionNumberIndex = inscriptionNumbers.indexOf(inscriptionNumber);
        removeCompetitorFromCircuitoInscriptions(circuit, inscriptionNumber);

        dnis.remove(inscriptionNumberIndex);
        names.remove(inscriptionNumberIndex);
        surnames.remove(inscriptionNumberIndex);
        ages.remove(inscriptionNumberIndex);
        cellphones.remove(inscriptionNumberIndex);
        emergencyNumbers.remove(inscriptionNumberIndex);
        bloodTypes.remove(inscriptionNumberIndex);
        registrationCosts.remove(inscriptionNumberIndex);
    }

    private static void updateCircuitoInscriptions(String circuit, int inscriptionNumber) {
        List<Integer> currentInscriptionsInCircuit = circuitosInscriptions.get(circuit);
        currentInscriptionsInCircuit.add(inscriptionNumber);
        circuitosInscriptions.put(circuit, currentInscriptionsInCircuit);
    }

    private static void displayCompetitorData(int inscriptionNumber, int dni, String surname, int registrationCost) {
        System.out.println("Se ha registrado un nuevo participante");
        System.out.println("Numero de inscripción: " + inscriptionNumber);
        System.out.println("DNI: " + dni + " Apellido: " + surname + " deberá pagar: " + registrationCost);
        System.out.println("- - - - -");
    }

    private static void displayCompetitorsByCircuit(String circuit) {
        List<Integer> competitorsByCircuit = circuitosInscriptions.get(circuit);
        if (competitorsByCircuit.size() == 0) {
            System.out.println("No hay competidores en esta categoría");
        } else {
            System.out.println("PARTICIPANTES DE: " + circuit);
            for (int inscriptionNumber : competitorsByCircuit) {
                int inscriptionNumberIndex = inscriptionNumbers.indexOf(inscriptionNumber);
                System.out.println("DNI " + dnis.get(inscriptionNumberIndex));
                System.out.println("Nombre " + names.get(inscriptionNumberIndex));
            }
        }
    }


    private static int getRegistrationCostIfPossible(String circuit, int age) throws Exception {
        int registrationCost;
        if (circuit.equals(CIRCUITO_CHICO)) {
            registrationCost = age > 18 ? 1500 : 1300;
        } else if (circuit.equals(CIRCUITO_MEDIO)) {
            registrationCost = age > 18 ? 2300 : 2000;
        } else {
            if (age < 18) throw new Exception("No puede participar al circuito avanzado por ser menor de edad");
            registrationCost = 2800;
        }
        return registrationCost;
    }

    public static void main(String[] args) throws Exception {
        circuitosInscriptions.put(CIRCUITO_CHICO, new ArrayList<>());
        circuitosInscriptions.put(CIRCUITO_MEDIO, new ArrayList<>());
        circuitosInscriptions.put(CIRCUITO_AVANZADO, new ArrayList<>());

        addCompetitorAndDisplay(CIRCUITO_CHICO, 38409631, "Esteban", "Dem", 28, 351633312, 351688876, "0+");
        addCompetitorAndDisplay(CIRCUITO_MEDIO, 38409632, "Juan", "Perez", 22, 351633312, 351688876, "0+");
        addCompetitorAndDisplay(CIRCUITO_AVANZADO, 38409633, "Martin", "Gonzales", 28, 351633312, 351688876, "0+");
        addCompetitorAndDisplay(CIRCUITO_CHICO, 38409634, "Joaquin", "Demar", 10, 351633312, 351688876, "0+");
        addCompetitorAndDisplay(CIRCUITO_MEDIO, 38409635, "Manuel", "Peretti", 15, 351633312, 351688876, "0+");
        addCompetitorAndDisplay(CIRCUITO_AVANZADO, 38409636, "Lautaro", "Gonz", 28, 351633312, 351688876, "0+");

        displayCompetitorsByCircuit(CIRCUITO_AVANZADO);
        removeCompetitorByInscriptionNumber(CIRCUITO_AVANZADO, 6);
        displayCompetitorsByCircuit(CIRCUITO_AVANZADO);
    }

}