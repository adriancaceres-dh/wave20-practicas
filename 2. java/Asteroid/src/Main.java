import com.bootcamp.Asteroid;
import com.bootcamp.Nave;
import com.bootcamp.Participante;

public class Main {
    public static void main(String[] args) {
        int[][] matrizAsteroides = {
                {5, 5},
                {10, 10},
                {10, 10},
                {10, 10},
        };
        Asteroid asteroidGame = new Asteroid(matrizAsteroides);

        Participante participante1 = new Participante("Esteban");
        Nave naveP1 = new Nave("Nave-Esteban-1", 4, 4);
        participante1.addNave(naveP1);

        Participante participante2 = new Participante("Pepe");
        Nave naveP2 = new Nave("Nave-Pepe-1", 9, 9);
        Nave naveP3 = new Nave("Nave-Pepe-2", 11, 11);
        participante2.addNave(naveP2);
        participante2.addNave(naveP3);

        asteroidGame.addParticipante(participante1);
        asteroidGame.addParticipante(participante2);
        asteroidGame.jugar();
    }
}