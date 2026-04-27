package Bus;

class SortByModel implements SortStrategy {
    public int compare(Bus b1, Bus b2) {
        return b1.getModel().compareTo(b2.getModel());
    }
}
