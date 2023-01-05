import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        Asteroide asteroide = new Asteroide();
        asteroide.setUbicacionAsteroide(new int[]{0, 0});
        Participante p1 = new Participante("Diego");
        p1.setFlotaDeNaves(new FlotaNaves());
        Participante p2 = new Participante("Alejandro");
        int []ubicacionNaveP2 = {(int) (Math.random()*5+1) ,(int) (Math.random()*5+1)};
        p2.setNave(new Nave("naveP2",ubicacionNaveP2));
        System.out.println("ubicacion nave1 flota p1: " + Arrays.toString(p1.getFlotaDeNaves().ubicacionNave1P1));
        System.out.println("ubicacion nave2 flota p2: " + Arrays.toString(p1.getFlotaDeNaves().ubicacionNave2P1));

        System.out.println("ubicacion nave P2: " + Arrays.toString(p2.getNave().getUbicacionNave()));


        int resultadoP1 = p1.getFlotaDeNaves().calcularDistancia(asteroide.ubicacionAsteroide[0], asteroide.ubicacionAsteroide[1]);
        int resultadoP2 = p2.getNave().calcularDistancia(asteroide.ubicacionAsteroide[0], asteroide.ubicacionAsteroide[1]);

        if(resultadoP2>resultadoP1){
            System.out.println("el ganador ha sido el P1 con una distancia de: " + resultadoP1);
        }else{
            System.out.println("el ganador ha sido el P2 con una distancia de: " + resultadoP2);
        }




    }
}
