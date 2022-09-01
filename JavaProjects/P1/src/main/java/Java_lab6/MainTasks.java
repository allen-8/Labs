package Java_lab6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainTasks
{
    // Task 1
    public boolean isEquals(int[] list1, int[] list2)
    {
        if (list1.length != list2.length)
            return false;
        for (int i = 0; i < list1.length; ++i)
        {
            if (list1[i] != list2[i])
                return false;
        }
        return true;
    }
    // Task 2
    public List<String> compareLists(int[] list1, int[] list2)
    {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list1.length; ++i)
        {
            String str = (list2.length > i && list1[i] == list2[i]) ? "Yes" : "No";
            res.add (str);
        }
        if (list2.length > list1.length)
        {
            for (int i = 0; i < list2.length - list1.length; ++i)
                res.add("No");
        }
        return res;
    }
    // Task 3
    public static String getString(String[] list)
    {
        if (list.length == 0)
            return "Empty list!";
        String min = list[0], max = list[0];
        int minPos = 0, maxPos = 0;
        for (int i = 0; i < list.length; ++i)
        {
            if (list[i].length() < min.length()) { min = list[i]; minPos = i; }
            else if (list[i].length() > max.length()) { max = list[i]; maxPos = i; }
        }
        return (minPos > maxPos) ? max : min;
    }
    // Task 4
    public static List<String> deleteDuplicates(List<String> list)
    {
        Set<String> set = new HashSet(list);
        list = new ArrayList<>(set);
        return list;
    }
}
