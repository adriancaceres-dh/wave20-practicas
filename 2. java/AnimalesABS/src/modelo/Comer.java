package modelo;

public class Comer implements IComerCarne, IComerHierba {


    public Comer() {
    }

    public String comerAnimal(Animal a){

        if(a.tipo.equals("carnivoro")){
            return this.comeCarne();
        }else{
            return this.comeHierba();
        }
    }
    @Override
    public String comeCarne() {
        return "El animal come carne";
    }

    @Override
    public String comeHierba() {
        return "El animal come hierba";
    }
}
