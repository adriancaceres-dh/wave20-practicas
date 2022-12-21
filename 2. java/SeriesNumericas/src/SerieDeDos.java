public class SerieDeDos extends Serie<Integer>{


    @Override
    public Integer getVrSiguiente() {
        vrSiguiente = vrSiguiente + 2;
        return vrSiguiente.intValue();
    }
}
