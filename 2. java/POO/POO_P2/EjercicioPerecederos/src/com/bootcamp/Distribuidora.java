package com.bootcamp;

public class Distribuidora {
    public static void main(String[] args) {

        Perecedero prod1 = new Perecedero("Queso fresco",2900,2);
        Perecedero prod2 = new Perecedero("Pavo cocido", 3400, 3);
        Perecedero prod3 = new Perecedero("Pan Linaza",1800, 1);
        Perecedero prod4 = new Perecedero("leche protein +", 3500,2);
        Perecedero prod5 = new Perecedero("Cereal proteina",5200,1);

        NoPerecedero n_prod1 = new NoPerecedero("Lentejas",2000,"legumbre");
        NoPerecedero n_prod2 = new NoPerecedero("Porotos",1500,"legumbre");
        NoPerecedero n_prod3 = new NoPerecedero("Arroz",700,"general");
        NoPerecedero n_prod4 = new NoPerecedero("Fideos",950,"pastas");
        NoPerecedero n_prod5 = new NoPerecedero("arroz integral",2000,"general");

        Producto[] productos  = {prod1,prod2,prod3,prod4,prod5,n_prod1,n_prod2,n_prod3,n_prod4,n_prod5};

        for (int i=0;i<productos.length;i++){
            System.out.println(productos[i].getNombre()+" - precio unitario "
                    +productos[i].getPrecio()+" - x5 = "
                    +productos[i].calcular(5));
        }
    }
}
