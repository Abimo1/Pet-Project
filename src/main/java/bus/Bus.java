package bus; // Указывает пакет, в котором находится класс Bus

public class Bus { // Объявление основного класса автобуса
    private final String number; // Поле для номера автобуса
    private final String model; // Поле для модели автобуса
    private final int mileage; // Поле для пробега автобуса

    private Bus(Builder builder) { // Приватный конструктор, создающий объект через Builder
        this.number = builder.number; // Присваиваем номер из Builder
        this.model = builder.model; // Присваиваем модель из Builder
        this.mileage = builder.mileage; // Присваиваем пробег из Builder
    }

    public String getNumber() { // Геттер для получения номера автобуса
        return number; // Возвращаем номер
    }

    public String getModel() { // Геттер для получения модели автобуса
        return model; // Возвращаем модель
    }

    public int getMileage() { // Геттер для получения пробега
        return mileage; // Возвращаем пробег
    }

    public static class Builder { // Вложенный Builder-класс для удобного создания Bus
        private String number; // Временное поле номера
        private String model; // Временное поле модели
        private int mileage; // Временное поле пробега

        public Builder setNumber(String number) { // Метод установки номера
            this.number = number; // Сохраняем номер
            return this; // Возвращаем текущий Builder для цепочки вызовов
        }

        public Builder setModel(String model) { // Метод установки модели
            this.model = model; // Сохраняем модель
            return this; // Возвращаем Builder
        }

        public Builder setMileage(int mileage) { // Метод установки пробега
            this.mileage = mileage; // Сохраняем пробег
            return this; // Возвращаем Builder
        }

        public Bus build() { // Финальный метод сборки объекта Bus
            return new Bus(this); // Создаём новый объект Bus
        }
    }

    @Override // Переопределение стандартного метода toString
    public String toString() {
        return "Bus{" + // Начало строки
                "number='" + number + '\'' + // Добавляем номер
                ", model='" + model + '\'' + // Добавляем модель
                ", mileage=" + mileage + // Добавляем пробег
                '}'; // Закрываем строку
    }
}
