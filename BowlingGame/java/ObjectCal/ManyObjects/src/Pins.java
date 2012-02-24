public class Pins {
    protected int hit;

    public static Pins copyPins(Pins pins) {
        return new Pins(pins.hit);
    }

    public Pins(int hit) {
        this.hit = hit;
    }

    public void add(Pins pins) {
        hit = hit + pins.hit;
    }

    @Override
    public String toString() {
        return Integer.toString(hit);
    }

    @Override
    public boolean equals(Object obj) {
        return Pins.class.isInstance(obj) && ((Pins) obj).hit == hit;
    }

    @Override
    public int hashCode() {
        return 31 * hit;
    }
}
