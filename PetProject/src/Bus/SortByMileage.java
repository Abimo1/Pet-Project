package Bus;

class SortByMileage implements SortStrategy {
    public int compare(Bus b1, Bus b2) {
        return Integer.compare(b1.getMileage(), b2.getMileage());
    }
}
