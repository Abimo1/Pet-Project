public class Bus {
    private final int number;
    private final String model;
    private final int mileage;
    private final boolean invalid;
    private Bus(BusBuilder busBuilder) {
        number = busBuilder.number;
        model = busBuilder.model;
        mileage = busBuilder.mileage;
        invalid = busBuilder.invalid;
    }
    public int getNumber() { return number; }
    public String getModel() { return model; }
    public int getMileage() { return mileage; }
    public boolean checkInvalid () {
        return invalid;
    }
    static class BusBuilder {
        private int number;
        private String model;
        private int mileage;
        private boolean invalid = false;
        private BusBuilder () {}
        public static BusBuilder newInstance() {
            return new BusBuilder();
        }
        public BusBuilder setNumber(String number) {
            if (number.length() > 4) {
                invalid = true;
                return this;
            }
            try {
                this.number = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                invalid = true;
                return this;
            }
            return this;
        }
        public BusBuilder setModel(String model) {
            this.model = model;
            return this;
        }
        public BusBuilder setMileage(String mileage) {
            if (mileage.length() > 6) {
                invalid = true;
                return this;
            }
            try {
                this.mileage = Integer.parseInt(mileage);
            } catch (NumberFormatException e) {
                invalid = true;
                return this;
            }
            return this;
        }
        public Bus build() {
            return new Bus(this);
        }
    }
}
