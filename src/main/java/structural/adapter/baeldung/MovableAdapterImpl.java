package structural.adapter.baeldung;

public class MovableAdapterImpl implements MovableAdapter {
    private final Movable luxuryCars;

    public MovableAdapterImpl(Movable bugatti) {
        luxuryCars = bugatti;
    }

    @Override
    public double getSpeed() {
        return convertMPHtoKMPH(luxuryCars.getSpeed());
    }

    private double convertMPHtoKMPH(double mph) {
        return mph * 1.60934;
    }

}
