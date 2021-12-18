package structural.adapter.baeldung;

public class Main {
    public static void main(String[] args) {
        Movable bugatti = new BugattiVeyron();
        MovableAdapter movableAdapter = new MovableAdapterImpl(bugatti);

        System.out.println(movableAdapter.getSpeed());
    }
}
