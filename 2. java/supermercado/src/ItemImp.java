import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemImp implements ICrud<Item>{
    List<Item> listaItems = new ArrayList<>();
    @Override
    public void create(Item item) {
        listaItems.add(item);
    }

    @Override
    public List<Item> read() {
        System.out.println(listaItems);
        return listaItems;
    }

    @Override
    public Optional<Item> find(String id) {
        System.out.println(listaItems.stream().filter(x -> String.valueOf(x.getCodigo()).equals(id)).findFirst());
        return listaItems.stream().filter(x -> String.valueOf(x.getCodigo()).equals(id)).findFirst();
    }

    @Override
    public void update(Item item) {

    }

    @Override
    public void delete(String id) {
        listaItems.removeIf(x -> String.valueOf(x.getCodigo()).equals(id));
    }
}
