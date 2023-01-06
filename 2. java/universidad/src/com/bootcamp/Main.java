package com.bootcamp;


import com.bootcamp.model.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("INTERFACES:");
        System.out.println(IAprender.class.getSimpleName());
        System.out.println(IAsistente.class.getSimpleName());
        System.out.println(IEducador.class.getSimpleName());
        System.out.println(IReparador.class.getSimpleName());
        System.out.println();

        System.out.println("CLASES ABSTRACTAS:");
        System.out.println(Persona.class.getSimpleName());
        System.out.println();

        System.out.println("CLASES CONCRETAS:");
        System.out.println(Estudiante.class.getSimpleName() + " extends " + Estudiante.class.getSuperclass().getSimpleName() + " implements " + Estudiante.class.getInterfaces()[0].getSimpleName());
        System.out.println(EstudianteTecnico.class.getSimpleName() + " extends " + EstudianteTecnico.class.getSuperclass().getSimpleName() + " implements " + EstudianteTecnico.class.getInterfaces()[0].getSimpleName());
        System.out.println(Tutor.class.getSimpleName() + " extends " + Tutor.class.getSuperclass().getSimpleName() + " implements " + Tutor.class.getInterfaces()[0].getSimpleName());
        System.out.println(Personal.class.getSimpleName() + " extends " + Personal.class.getSuperclass().getSimpleName());
        System.out.println(Profesor.class.getSimpleName() + " extends " + Profesor.class.getSuperclass().getSimpleName() + " implements " + Profesor.class.getInterfaces()[0].getSimpleName());
        System.out.println(PersonalMantenimiento.class.getSimpleName() + " extends " + PersonalMantenimiento.class.getSuperclass().getSimpleName() + " implements " + PersonalMantenimiento.class.getInterfaces()[0].getSimpleName());
        System.out.println(PersonalSoporteTecnico.class.getSimpleName() + " extends " + PersonalSoporteTecnico.class.getSuperclass().getSimpleName() + " implements " + PersonalSoporteTecnico.class.getInterfaces()[0].getSimpleName());
    }
}
