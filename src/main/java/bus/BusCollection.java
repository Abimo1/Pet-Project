package bus;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BusCollection implements Iterable<Bus> { // Кастомная коллекция автобусов

    private Bus[] data; // Массив хранения автобусов
    private int size = 0; // Текущее количество элементов

    public BusCollection(int capacity) { // Конструктор с размером
        data = new Bus[capacity]; // Создание массива
    }

    public void add(Bus bus) { // Добавление автобуса
        if (size >= data.length) { // Проверка заполненности
            throw new IllegalStateException("Collection is full"); // Ошибка если массив заполнен
        }
        data[size++] = bus; // Добавляем автобус и увеличиваем размер
    }

    public Bus[] toArray() { // Преобразование в массив
        Bus[] result = new Bus[size]; // Новый массив нужного размера
        for (int i = 0; i < size; i++) { // Копирование элементов
            result[i] = data[i];
        }
        return result;
    }

    @Override
    public Iterator<Bus> iterator() { // Создание итератора
        return new Iterator<>() {
            private int index = 0; // Текущая позиция

            @Override
            public boolean hasNext() { // Проверка следующего элемента
                return index < size;
            }

            @Override
            public Bus next() { // Получение следующего элемента
                if (!hasNext()) throw new NoSuchElementException(); // Ошибка если элементов нет
                return data[index++]; // Возврат элемента и увеличение индекса
            }
        };
    }
}