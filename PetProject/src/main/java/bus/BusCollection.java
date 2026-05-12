package main.java.bus;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BusCollection implements Iterable<Bus> {

    private Bus[] data;
    private int size = 0;

    public BusCollection(int capacity) {
        data = new Bus[capacity];
    }

    public void add(Bus bus) {
        if (size >= data.length) {
            throw new IllegalStateException("Collection is full");
        }
        data[size++] = bus;
    }

    public Bus[] toArray() {
        Bus[] result = new Bus[size];
        for (int i = 0; i < size; i++) {
            result[i] = data[i];
        }
        return result;
    }

    @Override
    public Iterator<Bus> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Bus next() {
                if (!hasNext()) throw new NoSuchElementException();
                return data[index++];
            }
        };
    }
}