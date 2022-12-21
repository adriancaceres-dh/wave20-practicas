package EjercIntroduccionJava1y2;

import com.sun.tools.javac.Main;

import java.util.LinkedList;
import java.util.List;

public class SueldoFactura {
    String dni = "12345678"; // dni de ejemplo
    double sueldoBase = 46000; // monto de ejemplo
    double sueldoConAumento;
    double sueldoA = 20000;
    double sueldoB = 45000;

    public void calcularAumento() {
        if (sueldoBase <= sueldoA ) {
            sueldoConAumento = sueldoBase + ((sueldoBase * 20)/100);
        }
        else {
            if (sueldoBase > sueldoA && sueldoBase <= sueldoB){
                sueldoConAumento = sueldoBase + ((sueldoBase * 10)/100);
            }
            else {
                sueldoConAumento = sueldoBase + ((sueldoBase * 5)/100);
            }
        }

        System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);
    }


    // Este tipo de dato sera visto en la siguiente clase en vivo
    List<String> mensajeStrings = new LinkedList<>();
    int seguridadDeCamara = 1500;
    int servicioDePatrullaje = 700;
    int servicio1 = seguridadDeCamara;
    int servicio2= seguridadDeCamara + servicioDePatrullaje;

    int[] serviciosCli = {1,1,2,2,2,1,2};  //vector de 7 posiciones con tipos de servicios
    double totalFactura;

    public void calcularMontoFactura() {
        for (int i = 0; i < serviciosCli.length; i++) {
            if (serviciosCli[i] == 1) {
                totalFactura = servicio1;
                imprimirMensaje("El tipo de servicio es: " + serviciosCli[i]);
                imprimirMensaje ("El monto de la factura es de: " + totalFactura);
            }
            else {
                totalFactura = servicio2;
                imprimirMensaje("El tipo de servicio es: " + serviciosCli[i]);
                imprimirMensaje("El monto de la factura es de: " + totalFactura);
            }
        }
    }

    private void imprimirMensaje(String mensaje) {
        mensajeStrings.add(mensaje);
        System.out.println(mensaje);
    }
    public static void main(String[] args) {
        new SueldoFactura().calcularAumento();
        new SueldoFactura().calcularMontoFactura();
    }
}
