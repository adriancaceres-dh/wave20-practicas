package com.bootcamp.sistema.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class numerosRomano {
    //Practica  Clase en Vivo
   /* @GetMapping()
    public String saludar(){
        return "hola mundo";
    }*/
    @GetMapping("/{nombre}")
    public String saludarAlguien(@PathVariable String nombre){
        return "hola  " + nombre;
    }
    @GetMapping("/numero/{n}")
  public String numero(@PathVariable double n) {
      int numeroIngresado = (int) Math.round(n);
      int miles, centenas, decenas, unidades;
      int resto = numeroIngresado;
      String resultado = "";

      miles = resto / 1000;
      resto = resto % 1000;

      centenas = resto / 100;
      resto = resto % 100;

      decenas = resto / 10;
      resto = resto % 10;

      unidades = resto;

      for (int i = 1; i <= miles; i++) {
          resultado += "M";
      }
      switch (centenas) {
          case 1:
              resultado += "C";
              break;
          case 2:
              resultado += "CC";
              break;
          case 3:
              resultado += "CCC";
              break;
          case 4:
              resultado += "CD";
              break;
          case 5:
              resultado += "D";
              break;
          case 6:
              resultado += "DC";
              break;
          case 7:
              resultado += "DCC";
              break;
          case 8:
              resultado += "DCCC";
              break;
          case 9:
              resultado += "CM";
              break;
      }
      switch (decenas) {
          case 1:
              resultado += "X";
              break;
          case 2:
              resultado += "XX";
              break;
          case 3:
              resultado += "XXX";
              break;
          case 4:
              resultado += "XL";
              break;
          case 5:
              resultado += "L";
              break;
          case 6:
              resultado += "LX";
              break;
          case 7:
              resultado += "LXX";
              break;
          case 8:
              resultado += "LXXX";
              break;
          case 9:
              resultado += "XC";
              break;
      }
      switch (unidades) {
          case 1:
              resultado += "I";
              break;
          case 2:
              resultado += "II";
              break;
          case 3:
              resultado += "III";
              break;
          case 4:
              resultado += "IV";
              break;
          case 5:
              resultado += "V";
              break;
          case 6:
              resultado += "VI";
              break;
          case 7:
              resultado += "VII";
              break;
          case 8:
              resultado += "VIII";
              break;
          case 9:
              resultado += "IX";
              break;
      }
      return "El número " + n + " en números romanos es: " + resultado;
  }
   @GetMapping("/morse")
   public String morse(@RequestParam String mensaje) {
        //morse de ejemplo (mercado libre) = -- . .-. -.-. .- -.. --- / .-.. .. -... .-. .
       String letras = "abcdefghijklmnopqrstuvwxyz 0123456789.,?!()[]&:;=+-_$@";
       String codigo[] = new String[60];
       String morse = " ";

       codigo[0] = ".-"; //a
       codigo[1] = "-...";//b
       codigo[2] = "-.-.";//c
       codigo[3] = "-..";//d
       codigo[4] = ".";//e
       codigo[5] = "..-.";//f
       codigo[6] = "--.";//g
       codigo[7] = "....";//h
       codigo[8] = "..";//i
       codigo[9] = ".---";//j
       codigo[10] = "-.-";//k
       codigo[11] = ".-..";//l
       codigo[12] = "--";//m
       codigo[13] = "-.";//n
       codigo[14] = "---";//o
       codigo[15] = ".--.";//p
       codigo[16] = "--.-";//q
       codigo[17] = ".-.";//r
       codigo[18] = "...";//s
       codigo[19] = "-";//t
       codigo[20] = "..-";//u
       codigo[21] = "...-";//v
       codigo[22] = ".--";//w
       codigo[23] = "-..-";//x
       codigo[24] = "-.--";//y
       codigo[25] = "--..";//z
       codigo[26] = "/";//espacio
       codigo[27] = "-----";//0
       codigo[28] = ".----";//1
       codigo[29] = "..---";//2
       codigo[30] = "...--";//3
       codigo[31] = "....-";//4
       codigo[32] = ".....";//5
       codigo[33] = "-....";//6
       codigo[34] = "--...";//7
       codigo[35] = "---..";//8
       codigo[36] = "----.";//9
       codigo[37] = ".-.-.-";//.
       codigo[38] = "--..--";//,
       codigo[39] = "..--..";//?
       codigo[40] = ".-.-..";//!
       codigo[41] = "-.--.";//(
       codigo[42] = "-.--.-";//)
       codigo[43] = "-.--.";//[
       codigo[44] = "-.--.-";//]
       codigo[45] = ".-...";//&
       codigo[46] = "---...";//:
       codigo[47] = "-.-.-.";//;
       codigo[48] = "-...-";//=
       codigo[49] = ".-.-.";//+
       codigo[50] = "-....-";//-
       codigo[51] = "..--.-";//_
       codigo[52] = "...-..-";//$
       codigo[53] = ".--.-.";//@

       String oracion[] = mensaje.split(" ");
       int max = oracion.length;

       for  (int i = 0; i < max; i++){
           for (int j = 0; j < 60; j++)
               if (oracion[i].equals(codigo[j])) {
                   morse = morse+letras.charAt(j);
                   break;
               }
       }
        morse = morse.substring(1,morse.length());
       return morse.toUpperCase();
   }


}
