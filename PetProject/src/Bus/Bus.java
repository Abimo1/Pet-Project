package Bus;

public class Bus {
    private final int number;
    private final String model;
    private final int mileage;
    private final boolean invalid;

    private Bus(BusBuilder busBuilder) {
        this.number = busBuilder.number;
        this.model = busBuilder.model;
        this.mileage = busBuilder.mileage;
        this.invalid = busBuilder.invalid;
    }

    public int getNumber() {
        return this.number;
    }

    public String getModel() {
        return this.model;
    }

    public int getMileage() {
        return this.mileage;
    }

    public boolean checkInvalid() {
        return this.invalid;
    }

    static class BusBuilder {
        private int number;
        private String model;
        private int mileage;
        private boolean invalid = false;

        private BusBuilder() {
        }

        public static BusBuilder newInstance() {
            return new BusBuilder();
        }

        public BusBuilder setNumber(String number) {
            if (number.length() > 4) {
                this.invalid = true;
                return this;
            } else {
                try {
                    this.number = Integer.parseInt(number);
                    return this;
                } catch (NumberFormatException var3) {
                    this.invalid = true;
                    return this;
                }
            }
        }

        public BusBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public BusBuilder setMileage(String mileage) {
            if (mileage.length() > 6) {
                this.invalid = true;
                return this;
            } else {
                try {
                    this.mileage = Integer.parseInt(mileage);
                    return this;
                } catch (NumberFormatException var3) {
                    this.invalid = true;
                    return this;
                }
            }
        }

        public Bus build() {
            return new Bus(this);
        }
    }
}