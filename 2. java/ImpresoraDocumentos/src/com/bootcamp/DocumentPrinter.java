package com.bootcamp;

public class DocumentPrinter {
    public static void printDocument(ImpresoraInterface document) {
        document.print();
        System.out.println("- - - - -");
    }
}
