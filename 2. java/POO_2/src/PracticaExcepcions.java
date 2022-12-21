import com.sun.source.tree.TryTree;

public class PracticaExcepcions {
    public static int a = 0;
    public static int b = 300;

    public static int calcularCociente(){
        try {
            return b / a;
        }catch (ArithmeticException ex){
            //throw ex;
            throw new IllegalArgumentException();
        }
    }
}
