package Java_lab11;

import java.util.*;

import static java.lang.Math.abs;

public class MainTasks {
    // Task 1
    public static boolean checkSets(Set<String> s1, Set<String> s2)
    {
        if (s1.size() != s2.size())
            return false;
        for (String s : s1)
            if (!s2.contains(s))
                return false;
        return true;
    }
    // Task 2
    // Если массив имеет несколько равных по длине последовательностей, возвращается последняя
    public static Collection<Integer> findNumbers(List<Integer>list)
    {
        int start = -1, end = 0, len = 0, stpos = -1;
        List<Integer> newlist = new ArrayList<>();
        for (int i = 0; i < list.size(); ++i)
        {
            if (list.get(i) % 2 == 0)
            {
                if (start == -1)
                {
                    start = i;
                    end = i;
                }
                else if (list.get(i - 1) % 2 == 1)
                    start = i;
                else
                    end = i;
                if (i + 1 == list.size() && end - start > len)
                {
                    len = end - start;
                    stpos = start;
                }
            }
            else if (end - abs(start) > len)
            {
                len = end - start;
                stpos = start;
            }
        }
        if (stpos == -1)
            return newlist;
        for (int i = start; i < start + len + 1; ++i)
            newlist.add(list.get(i));
        return newlist;
    }
    public static void main(String[] args)
    {
        // Test task 1
        Set<String> set1 = new HashSet<>() {{add("one"); add("two"); add("three");}},
                set2 = new HashSet<>() {{add("one"); add("two"); add("four");}};
        System.out.println(checkSets(set1, set2));
        // Test task 2
        List<Integer>list = new ArrayList<>() {{ add(3); add(4); add(6); add(7); add(1); add(2); add(10); add(6);}};
        System.out.println(findNumbers(list));
    }
}
