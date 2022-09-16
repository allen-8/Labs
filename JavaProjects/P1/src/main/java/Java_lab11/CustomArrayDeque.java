package Java_lab11;
import java.util.Arrays;
import java.util.Iterator;

public class CustomArrayDeque implements CustomDeque {

    private int [] source; //  массив с содержимым
    private int size = 0; // размер контейнера
    private int firstElementIndex = 0; // чтобы быстрее удалить / добавить элемент вначало

    private static final int CAPACITY = 4;
    CustomArrayDeque()
    {
        source = new int[CAPACITY];
    }

    @Override
    public void addFirst(int i) {
        if(size == source.length)
            increaseCapacity();
        firstElementIndex = (firstElementIndex - 1 + source.length) % source.length;
        source[firstElementIndex] = i;
        size++;
    }

    private void increaseCapacity() {
        int [] newSource = new int[source.length * 2];
        int j = 0;
        for (int i = firstElementIndex; i < source.length; i++) {
            newSource[j++] = source[i];
        }
        for (int i = 0; i < firstElementIndex; i++) {
            newSource[j++] = source[i];
        }
        firstElementIndex = 0;
        source = newSource;
    }
    @Override
    public int getFirst() {
        if(size == 0)
            throw new IndexOutOfBoundsException();
        return source[firstElementIndex];
    }
    @Override
    public int removeFirst() {
        if(size == 0)
            throw new IndexOutOfBoundsException();
        int el = source[firstElementIndex];
        firstElementIndex = (firstElementIndex + 1) % source.length;
        size--;
        return el;
    }

    @Override
    public void addLast(int i)
    {
        if(size == source.length)
            increaseCapacity();
        source[firstElementIndex + size++ % source.length] = i;
    }

    @Override
    public int getLast() {
        if (size == 0)
            throw new IndexOutOfBoundsException();
        return source[firstElementIndex + size - 1 % source.length];
    }

    @Override
    public int removeLast() {
        return source[firstElementIndex + size-- - 1 % source.length];
    }

    @Override
    public int size() {
        return size;
    }
    //перебор в обратном порядке
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>()
        {
            int counter = size - 1;
            @Override
            public boolean hasNext() { return counter >= 0; }
            @Override
            public Integer next() { return source[counter--]; }
        };
    }
    // перебор элементов по убыванию
    public Iterator<Integer> iterator1() {
        return new Iterator<Integer>()
        {
            int [] temp = new int[size];
            int counter = size - 1;
            @Override
            public boolean hasNext() {
                if (counter == size - 1) {
                    System.arraycopy(source, 0, temp, 0, size);
                    Arrays.sort(temp, 0, size - 1);
                }
                return counter >= 0;
            }
            @Override
            public Integer next() { return temp[counter--]; }
        };
    }
}
