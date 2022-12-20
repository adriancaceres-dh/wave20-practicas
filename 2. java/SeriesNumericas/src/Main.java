import com.bootcamp.DoublePrototipo;
import com.bootcamp.IntegerPrototipo;
import com.bootcamp.Prototipo;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {
        System.out.println("Prueba con valores Enteros");
        Prototipo<Integer> protipoEntero = new IntegerPrototipo(3);

        System.out.println(protipoEntero.obtenerValorSiguiente());
        System.out.println(protipoEntero.obtenerValorSiguiente());
        System.out.println(protipoEntero.obtenerValorSiguiente());
        protipoEntero.reiniciarSerie();
        System.out.println(protipoEntero.obtenerValorSiguiente());
        System.out.println(protipoEntero.obtenerValorSiguiente());
        protipoEntero.reiniciarSerie();
        protipoEntero.setearValorInicial(5);
        System.out.println(protipoEntero.obtenerValorSiguiente());
        System.out.println(protipoEntero.obtenerValorSiguiente());
        System.out.println(protipoEntero.obtenerValorSiguiente());

        System.out.println("Prueba con Doubles");

        Prototipo<Double> prototipoDouble = new DoublePrototipo(3.45);
        NumberFormat formatter = new DecimalFormat("#0.00");

        System.out.println(formatter.format(prototipoDouble.obtenerValorSiguiente()));
        System.out.println(formatter.format(prototipoDouble.obtenerValorSiguiente()));
        System.out.println(formatter.format(prototipoDouble.obtenerValorSiguiente()));
        prototipoDouble.reiniciarSerie();
        System.out.println(formatter.format(prototipoDouble.obtenerValorSiguiente()));
        System.out.println(formatter.format(prototipoDouble.obtenerValorSiguiente()));
        prototipoDouble.reiniciarSerie();
        prototipoDouble.setearValorInicial(5d);
        System.out.println(formatter.format(prototipoDouble.obtenerValorSiguiente()));
        System.out.println(formatter.format(prototipoDouble.obtenerValorSiguiente()));
        System.out.println(formatter.format(prototipoDouble.obtenerValorSiguiente()));
    }
}