package com.bootcamp.imprimirdocs;

public interface IPrintDocs {
    default <T> void printDoc(T obj) {
        System.out.println(obj.toString());
    }
}
