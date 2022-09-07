package Java_lab10;
import java.util.*;

public class Lab10
{
    // Task 1
    public static Collection<String> returnDuplicate (String str)
    {
        Collection<String>list = List.of(str.split(" "));
        Set<String> list1 = new HashSet<>();
        for (String i : list)
            if (Collections.frequency(list, i) > 1)
                list1.add(i);
        return list1;
    }
    // Task 2
    static class StringCounter implements Comparable<StringCounter>
    {
        String string;
        int amount;
        StringCounter(String str, int a)
        {
            string = str;
            amount = a;
        }
        @Override
        public int compareTo(StringCounter sc) { return this.amount - sc.amount; }
        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            StringCounter sc = (StringCounter) o;
            return this.string.equals(sc.string);
        }
        @Override
        public int hashCode() { return amount * 31; }
    }
    public static Collection<StringCounter> countDuplicates (String str)
    {
        List<String> list = List.of(str.split(" "));
        Set<StringCounter> coll = new HashSet<>();
        for (String i : list)
            if (Collections.frequency(list, i) > 1)
                coll.add(new StringCounter(i, Collections.frequency(list, i)));
        return coll;
    }
    public static void main(String[] args)
    {
        // Test task 1
        String str1 = "test string for the first test for the lab 10";
        System.out.println(returnDuplicate(str1));
        // Test task 2
        Collection<StringCounter> test = countDuplicates(str1);
        for (StringCounter sc : test)
            System.out.println(sc.string + ": " + sc.amount);
    }
}
