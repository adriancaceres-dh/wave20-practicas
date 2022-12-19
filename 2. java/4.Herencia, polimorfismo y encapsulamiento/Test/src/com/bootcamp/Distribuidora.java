package com.bootcamp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Distribuidora {
    public static void main(String[] args) {
        Producto productoPerecederoPan = new Perecedero("Pan", 6000, 3);
        Producto productoPerecederoLeche = new Perecedero("Leche", 4500, 2);
        Producto productoNoPerecederoAtun = new NoPerecedero("Atún", 5500, "Pescado");
        Producto productoNoPerecederoMaiz = new NoPerecedero("Maiz", 2800, "Lata");
        List<Producto> lista = Arrays.asList(productoNoPerecederoMaiz, productoNoPerecederoAtun, productoPerecederoLeche, productoNoPerecederoMaiz, productoNoPerecederoAtun, productoPerecederoPan, productoNoPerecederoMaiz, productoNoPerecederoAtun, productoPerecederoLeche, productoNoPerecederoMaiz, productoPerecederoPan, productoPerecederoLeche, productoNoPerecederoMaiz, productoNoPerecederoAtun, productoPerecederoPan, productoPerecederoLeche, productoPerecederoPan, productoNoPerecederoMaiz, productoNoPerecederoAtun, productoPerecederoLeche, productoPerecederoPan);
        Set<Producto> set = new HashSet<Producto>(lista);
        for (Producto setProducts : set) {
            List<Producto> nombreP = lista.stream().filter(producto -> setProducts.getNombre().equals(producto.getNombre())).collect(Collectors.toList());
            if (nombreP.size() == 5 && setProducts.getClass() == Perecedero.class) {
                System.out.println("Hay 5 productos de " + setProducts.getNombre() + ", caduca en " + ((Perecedero) setProducts).getDiasPorCaducar() + " días y su precio total es: " + setProducts.calcular(5));
            } else if (nombreP.size() == 5 && setProducts.getClass() == NoPerecedero.class) {
                System.out.println("Hay 5 productos no perecederos de " + setProducts.getNombre() + " y su precio total es: " + setProducts.calcular(5));
            } else {
                System.out.println("Solo puede comprar 5 productos de " + setProducts.getNombre());
            }
        }
    }


}
