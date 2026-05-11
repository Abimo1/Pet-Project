package bus;

public class DataValidator {// Класс для проверки корректности данных

    public boolean validateBusNumber(String number) {// Проверка номера

        return number != null && !number.trim().isEmpty();// Номер не null и не пустой
    }

    public boolean validateBusModel(String model) {// Проверка модели

        return model != null && !model.trim().isEmpty();// Модель не null и не пустая
    }

    public boolean validateBusMileage(int mileage) {// Проверка пробега

        return mileage >= 0; // Пробег должен быть >= 0
    }

    public boolean validateBusData(String number, String model, int mileage) {// Общая проверка автобуса
        return validateBusNumber(number) &&  // Проверка номера
                validateBusModel(model) &&  // Проверка модели
                validateBusMileage(mileage);  // Проверка пробега
    }
}
