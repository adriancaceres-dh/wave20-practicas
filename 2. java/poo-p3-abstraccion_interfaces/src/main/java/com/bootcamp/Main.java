package com.bootcamp;

public class Main {
    public static void main(String[] args) {
        String p = "H O L A   F L A V I O";
        String[] sep = p.split(" ");
        for (String s : sep) {
            System.out.println(s);
        }
    }
}