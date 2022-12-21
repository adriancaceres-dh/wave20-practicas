package com.bootcamp;

public class Main {
    public static void main(String[] args) {

        SerieInteger s1 = new SerieInteger(0, 2);
        System.out.println(s1.siguiente());
        System.out.println(s1.siguiente());
        System.out.println(s1.siguiente());
        System.out.println(s1.siguiente());

        s1.setInicio(1);
        System.out.println(s1.siguiente());
        System.out.println(s1.siguiente());
        System.out.println(s1.siguiente());
        System.out.println(s1.siguiente());

        SerieDouble s2 = new SerieDouble(0.0, 3.0);
        System.out.println(s2.siguiente());
        System.out.println(s2.siguiente());
        System.out.println(s2.siguiente());
        System.out.println(s2.siguiente());
    }
}