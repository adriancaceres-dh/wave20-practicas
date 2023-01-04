public class Persona {
    private String DNI;
    private String Name;
    private int Age;
    private double Weight;
    private int HeightInCentimeters;

    public Persona() {
    }

    public Persona(String DNI, String name, int age) {
        this.DNI = DNI;
        Name = name;
        Age = age;
    }

    public Persona(String DNI, String name, int age, double weight, int heightInCentimeters) {
        this.DNI = DNI;
        Name = name;
        Age = age;
        Weight = weight;
        HeightInCentimeters = heightInCentimeters;
    }


    public String getDNI() {
        return DNI;
    }
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public int getAge() {
        return Age;
    }
    public void setAge(int age) {
        Age = age;
    }
    public double getWeight() {
        return Weight;
    }
    public void setWeight(double weight) {
        Weight = weight;
    }
    public int getHeightInCentimeters() {
        return HeightInCentimeters;
    }
    public void setHeightInCentimeters(int heightInCentimeters) {
        HeightInCentimeters = heightInCentimeters;
    }

    public boolean esMayorDeEdad(){
        return Age>=18;
    }
    public int calcularIMC(){
        double imc = 0;
        try
        {
             imc = (Math.pow(Weight, 2))/HeightInCentimeters;
             System.out.println(imc);
        }catch (Exception e){}
        if(imc>25) return 1;
        if (imc>=20) return 0;
        return -1;
    }

    @Override
    public String toString() {
        String EsMayorDeEdad = this.esMayorDeEdad()? "SI": "NO";
        String Peso = "Saludable";
        if (calcularIMC()==1) Peso = "Sobrepeso";
        if (calcularIMC()==-1) Peso = "Infrapeso";

        return "Nombre: "+Name +". Es mayor de edad: "+ EsMayorDeEdad+ ". Peso: " + Peso
        ;
    }
}
