package universidad;


import java.util.ArrayList;
import java.util.List;

public class Universidad {

    List<Personas> listaPersonal;

    public Universidad(){
        listaPersonal = new ArrayList<>();
    }
    public void agregarPersonal(Personas p){
        listaPersonal.add(p);
    }



}
