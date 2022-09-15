package Algorithms_lab6;

import Java_lab8.DoubleLinkedList;

import java.util.*;

public class DynamicArray implements Collection {
    private int[] array;
    private int count;
    private int size;

    public DynamicArray()
    {
        array = new int[1];
        count = 0;
        size = 1;
    }
    @Override
    public String toString()
    {
        return Arrays.toString(array);
    }
    private void growSize()
    {
        int[] temp = new int[size * 2];
        if (size >= 0) System.arraycopy(array, 0, temp, 0, size);
        array = temp;
        size *= 2;
    }
    private void shrinkSize()
    {
        int[] temp = new int[size / 2];
        if (size >= 0) System.arraycopy(array, 0, temp, 0, size);
        array = temp;
        size /= 2;
    }
    public void add (int i)
    {
        if (count == size)
            growSize();
        array[count++] = i;
    }
    public int size() { return count; }
    public int getInnerArrayLength() { return size; }
    public boolean add (int index, int data)
    {
        if (index > size)
            return false;
        if (count == size)
            growSize();
        for (int i = index; i < count; ++i)
        {
            int temp = array[i];
            array[i] = data;
            data = temp;
        }
        ++count;
        return true;
    }
    public boolean remove(int data)
    {
        for (int cnt = 0; cnt < count; ++cnt)
            if (array[cnt] == data)
            {
                for (int i = array[cnt]; i < count; ++i)
                    array[i] = array[i + 1];
                --count;
                if (size / 2 > count)
                    shrinkSize();
                return true;
            }
        return false;
    }
    public boolean removeAt(int index)
    {
        if (index >= count)
            return false;
        for (int i = index; i < count; ++i)
            array[i] = array[i + 1];
        --count;
        if (size / 2 > count)
            shrinkSize();
        return true;
    }
    public boolean set(int index, int data)
    {
        if (index >= count)
            return false;
        array[index] = data;
        return true;
    }
    public int get(int index)
    {
        if (index >= count)
            throw new IndexOutOfBoundsException();
        return array[index];
    }
    public void clear()
    {
        array = new int[1];
        count = 0;
        size = 1;
    }
    @Override
    public boolean contains(Object o)
    {
        int data = Integer.parseInt(o.toString());
        for (int i : array)
            if (i == data)
                return true;
        return false;
    }
    public boolean isEmpty() { return count == 0; }
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>()
        {
            int counter = 0;
            @Override
            public boolean hasNext() { return counter < count; }
            @Override
            public Integer next() { return array[counter++]; }
            @Override
            public void remove()
            {
                if (count == 0)
                    return;
                removeAt(counter++);
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] o = new Object[count];
        for (int i = 0; i < count; ++i)
            o[i] = array[i];
        return o;
    }
    // эти методы не нужны для текущего задания, потому не реализованы, но добалены для того, чтоб класс мог
    // имплементить Коллекцию для простоты сравнения вренеми работы
    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

}
