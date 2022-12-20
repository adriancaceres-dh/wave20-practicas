package com.bootcamp.ejercicio2;

public class Distribuidora {

    public static void main(String[] args) {
        Producto perecedero1 = new Perecedero("milanesa",20.5,2);
        Producto perecedero2 = new Perecedero("hamburguesa",10,1);
        Producto perecedero3 = new Perecedero("salchicha",24,3);
        Producto perecedero4 = new Perecedero("pizza",50,2);
        Producto perecedero5 = new Perecedero("tarta",5.5,4);

        Producto noPerecedero1 = new NoPerecedero("arroz",10,"tipo");
        Producto noPerecedero2 = new NoPerecedero("fideos",20,"tipo");
        Producto noPerecedero3 = new NoPerecedero("choclo",5,"tipo");
        Producto noPerecedero4 = new NoPerecedero("chaucha",15.5,"tipo");
        Producto noPerecedero5 = new NoPerecedero("poroto",25,"tipo");

        Producto [] productos = {perecedero1,perecedero2,perecedero3,perecedero4,perecedero5,noPerecedero1,noPerecedero2,noPerecedero3,noPerecedero4,noPerecedero5};

        double precioTotal = 0;

        for (Producto p: productos) {
            precioTotal = precioTotal + p.calcular(5);
        }

        System.out.println("El precio total es de: "+precioTotal);

    }

}
