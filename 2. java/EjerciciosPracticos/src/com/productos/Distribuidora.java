package com.productos;

import com.productos.models.Productos;
import com.productos.models.ProductosNoPerecederos;
import com.productos.models.ProductosPerecederos;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {

        List<Productos> listaProductos = new ArrayList<>();
        Productos productos = new Productos();
        ProductosPerecederos productosPerecederos;
        ProductosNoPerecederos productosNoPerecederos;
        int tipoProducto = 0;
        int contadorPerecedero = 1;


        for (int i = 0; i < 5 ; i++) {
            tipoProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo de producto: " + "\n" +
                    "1: Perecedero" + "\n" +
                    "2: No perecedero"
                    ));
            productos.setNombre(JOptionPane.showInputDialog("Ingrese nombre del productos: "));
            productos.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto!")));
            listaProductos.add(productos);

            if (tipoProducto == 1){
                productosPerecederos = new ProductosPerecederos();
                productosPerecederos.setDiasPorCaducar(Integer.parseInt(JOptionPane.showInputDialog("Ingrese cuantos dias le faltan por caducar al producto!!")));
                //productosPerecederos.calcular(contadorPerecedero++);


                System.out.println(contadorPerecedero);

                productosPerecederos.toString();
            }
            else {
                productosNoPerecederos = new ProductosNoPerecederos();

                productosNoPerecederos.toString();
            }

            contadorPerecedero++;
        }


    }
}
