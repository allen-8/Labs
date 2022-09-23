package Algorithms_lab6;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TestArrays
{
    public static long fillList(Collection<Integer> coll)
    {
        Random r = new Random();
        long start = System.currentTimeMillis();
        DynamicArray d = new DynamicArray();
        if (coll.getClass() == d.getClass()) {
            d = (DynamicArray) coll;
            for (int i = 0; i < 1000000; ++i)
                d.add(r.nextInt(1000));
        }
        else
            for (int i = 0; i < 1000000; ++i)
                coll.add(r.nextInt(1000));
        return System.currentTimeMillis() - start;
    }
    public static long getRandomNumber(Collection<Integer> coll)
    {
        if (coll.size() != 1000000)
            return -1;
        Random r = new Random();
        long start = System.currentTimeMillis();
        DynamicArray d = new DynamicArray();
        if (coll.getClass() == d.getClass()) {
            d = (DynamicArray) coll;
            for (int i = 0; i < 1000000; ++i)
                d.get(r.nextInt(999999));
        }
        else {
            List<Integer> l = (List<Integer>) coll;
            for (int i = 0; i < 1000000; ++i)
                l.get(r.nextInt(999999));
        }
        return System.currentTimeMillis() - start;
    }
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<Integer>();
        List<Integer> linkedList = new LinkedList<Integer>();
        DynamicArray dynamicArray = new DynamicArray();
        System.out.println("Filling ArrayList time: " + fillList(arrayList));
        System.out.println("Filling LinkedList time: " + fillList(linkedList));
        System.out.println("Filling DynamicArray time: " + fillList(dynamicArray));
        System.out.println("Get elements from ArrayList time: " + getRandomNumber(arrayList));
        System.out.println("Get elements from DynamicArray time: " + getRandomNumber(dynamicArray));
        System.out.println("Get elements from LinkedList time: " + getRandomNumber(linkedList));

        /*РЕЗУЛЬТАТЫ:
        Filling ArrayList time: 203 | 297 | 547 | 156
        Filling LinkedList time: 234 | 218 | 297 | 266
        Filling DynamicArray time: 47 | 79 | 47 | 78
        Get elements from ArrayList time: 156 | 140 | 109 | 114
        Get elements from LinkedList time: 2255308
        Get elements from DynamicArray time: 60 | 63 | 62 | 40
        По какой-то причине написанный вручную массив работает в 3 раза быстрее библиотечного.
        Возможно, в коде не хватает каких-то проверок, замедляющих работу.
        */
    }
}
