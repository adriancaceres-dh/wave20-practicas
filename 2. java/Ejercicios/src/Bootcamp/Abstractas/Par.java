package Bootcamp.Abstractas;

public class Par extends Prototipo{
    private int num;

    @Override
    public int next_number() {
        return num + num;
    }

    @Override
    public void reload() {
        super.reload();
    }
}
