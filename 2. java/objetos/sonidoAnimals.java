package objetos;

public class sonidoAnimals {

    public static void main(String[] args) {
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();
        IHierba<Animal> iHierba = new Hierba<Animal>();
        ICarnivoro<Animal> iCarnivoro = new Carnivoro<Animal>();
        iHierba.comerHierba(vaca);
        iCarnivoro.comerCarne(gato);
        iCarnivoro.comerCarne(perro);
    }
}
