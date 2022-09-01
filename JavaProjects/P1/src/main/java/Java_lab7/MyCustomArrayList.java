package Java_lab7;
import java.util.Iterator;
import java.util.Arrays;

public class MyCustomArrayList implements AdvancedArrayList {
    private static final int INITIAL_CAPACITY = 4;
    private int[] data;
    private int size = 0; // "видимый" для пользователя размер массива

    public MyCustomArrayList() {
        data = new int[INITIAL_CAPACITY];
    }

    @Override
    public void set(int index, int value) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        data[index] = value;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return data[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void append(int value) {
        if (size == data.length)
            increaseCapacity();
        data[size++] = value;
    }

    @Override
    public void append(int[] a) {
        for (int i = 0; i < a.length; i++) {
            append(a[i]);
        }
    }

    private void increaseCapacity() {
        int[] newData = new int[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }


    @Override
    public void insert(int index, int value) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if (size == data.length)
            increaseCapacity();
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = value;
        size++;
    }

    @Override
    public void delete(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(data));
    }

    @Override
    public boolean contains(int value) {
        for (int i = 0; i < size; i++) {
            if (value == data[i])
                return true;
        }
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int pos = 0;

            @Override
            public boolean hasNext() {
                return pos < size;
            }

            @Override
            public Integer next() {
                return get(pos++);
            }

            @Override
            public void remove() {
                delete(pos);
                --size;
            }
        };
    }
}
