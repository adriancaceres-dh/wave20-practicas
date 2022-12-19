package com.bootcamp;

public class Distribuidora {
    public static void main(String[] args) {

        double precioTotal=0;
        Producto[] productos = new Producto[10];

        productos[0]= new Perecedero("Carne",10.000, 1);
        productos[1]= new Perecedero("Frutas",2.000, 3);
        productos[2]= new Perecedero("Lácteos",3.000, 2);
        productos[3]= new Perecedero("Vegetales",5.000, 2);
        productos[4]= new Perecedero("Pescados",18.000, 3);
        productos[5]= new NoPerecedero("Atun",8.000,"");
        productos[6]= new NoPerecedero("Azuca",6.000, "");
        productos[7]= new NoPerecedero("Harina",2.000, "");
        productos[8]= new NoPerecedero("Miel",9.000, "");
        productos[9]= new NoPerecedero("Café",20.000, "");

        for(Producto p : productos){
           precioTotal+= p.calcular(5);
        }
        
        System.out.println("El precio final es de: " + precioTotal);

    }

}