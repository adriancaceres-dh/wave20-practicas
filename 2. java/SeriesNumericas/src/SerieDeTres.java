public class SerieDeTres extends Serie<Integer>{


    @Override
    public Integer getVrSiguiente() {
        vrSiguiente = vrSiguiente + 3;
        return vrSiguiente;
    }
}
