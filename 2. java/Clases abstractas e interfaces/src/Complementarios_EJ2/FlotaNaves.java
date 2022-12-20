package Complementarios_EJ2;

import java.util.LinkedList;

public class FlotaNaves {
    LinkedList<Nave> naves;

    public FlotaNaves(LinkedList<Nave> naves) {
        this.naves = naves;
    }

    public LinkedList<Nave> getNaves() {
        return naves;
    }

    public void agregarNave(Nave nuevaNave) {
        naves.add(nuevaNave);
    }
}
