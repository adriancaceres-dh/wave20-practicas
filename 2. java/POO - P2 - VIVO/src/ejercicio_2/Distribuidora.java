package ejercicio_2;

import java.util.ArrayList;

public class Distribuidora {

   ArrayList<Producto> productos = new ArrayList<Producto>();

   public void calcularPrecio() {
      double total = 0;
      for (int i=0; i < productos.size(); i++) {
         total+= productos.get(i).calcular(5);
      }
      System.out.println(total);
   }


   public Distribuidora (){
      productos.add(new Perecedero ("Yogurt", 200, 120));
      productos.add(new Perecedero ("Yogurt en oferta", 200, 1));
      productos.add(new NoPerecedero ("Fideos integrales", 300, "Almacen"));
      productos.add(new NoPerecedero ("Detergente", 1200, "Limpieza"));
      productos.add(new Perecedero ("Queso azul", 600, 2));
   }

   public static void main(String[] args) {
      Distribuidora pepito = new Distribuidora();

      pepito.calcularPrecio();
   }

}
