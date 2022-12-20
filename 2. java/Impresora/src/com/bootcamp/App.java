package com.bootcamp;

public class App {
    public static void main(String[] args) {
        Curriculum curriculum=new Curriculum("david",20);
        PDF pdf=new PDF(12,"ddd","sss","accion");
        Impresion<Informes> informe =new Informes(3,"dda,","dede","dede");
        Impresion.imprimir(curriculum);
        Impresion.imprimir(pdf);
        Impresion.imprimir(informe);

    }
}
