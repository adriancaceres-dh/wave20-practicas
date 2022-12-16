package main;

public class Main {
    public static void main(String[] args){
        Persona persona_uno = new Persona ("Ignacio",23,"42192987");
        Persona persona_dos = new Persona ("Julian",24,"42192985",80,1.80);
        Persona persona_tres = new Persona ("Julian",24,"42192985",80,1.50);
        Persona persona_cuatro = new Persona ("Julian",24,"42192985",80,2.1);
        Persona persona_cinco = new Persona ();

        System.out.println(persona_dos.calcularIMC());
        System.out.println(persona_tres.calcularIMC());
        System.out.println(persona_cuatro.calcularIMC());
        System.out.println(persona_cuatro.esMayorDeEdad());
    }
}
