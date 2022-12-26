import java.util.List;
import java.util.Optional;

public interface ICrud <T>{
    public void create(T item);
    public List<T> read();
    public Optional<T> find(String id);
    public void update(T item);
    public void delete(String id);
}
