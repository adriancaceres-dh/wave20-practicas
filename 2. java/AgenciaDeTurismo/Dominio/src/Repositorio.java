import java.util.ArrayList;
import java.util.Collection;

public class Repositorio <T> {
    Collection<T> Items = new ArrayList<>();

    public Collection<T> getItems() {
        return Items;
    }

    public void addItems(Collection<T> items) {
        Items.addAll(items);
    }

    public void addItem(T item) {
        Items.add(item);
    }
}
