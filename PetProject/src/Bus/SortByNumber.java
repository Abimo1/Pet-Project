package Bus;

class SortByNumber implements SortStrategy {
    public int compare(Bus b1, Bus b2) {
        return Integer.compare(b1.getNumber(), b2.getNumber());
    }
}