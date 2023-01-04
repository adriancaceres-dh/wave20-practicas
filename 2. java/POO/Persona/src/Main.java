public class Main {
    public static void main(String[] args) {

       Persona personaSinParam = new Persona();
       Persona persona3Params = new Persona("Jill", 35, "35666728");
       Persona personaTodosParams = new Persona("Claire", 20, "66378112", 55, 170);

       System.out.println(personaTodosParams.calcularIMC());
    }
}