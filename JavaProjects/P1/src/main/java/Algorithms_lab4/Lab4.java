package Algorithms_lab4;
import java.util.ArrayList;
import java.util.List;

public class Lab4 {
    // First level
    // Task 1
    public static void mergeSort(int[] array, int start, int end)
    {
        if (end - start == 1)
        {
            if (array[start] < array[end])
            {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);
        List<Integer> newArray = new ArrayList<>();
        int cnt1 = start, cnt2 = mid + 1;
        while (cnt1 != mid + 1 && cnt2 != end + 1)
        {
            if (array[cnt1] < array[cnt2])
                newArray.add(array[cnt2++]);
            else
                newArray.add(array[cnt1++]);
        }
        if (cnt1 == mid + 1)
        {
            while (cnt2 != end + 1)
                newArray.add(array[cnt2++]);
        }
        else
        {
            while (cnt1 != mid + 1)
                newArray.add(array[cnt1++]);
        }
        for (int i : newArray)
            array[start++] = i;
    }
    // Task 2
    public static String mergeString(String str1, String str2)
    {
        int cnt1 = 0, cnt2 = 1;
        String res = "";
        while (cnt1 < str1.length() && cnt2 < str2.length())
        {
            if (cnt1 < cnt2)
            {
                res += str1.charAt(cnt1);
                cnt1 += 2;
                continue;
            }
            res += str2.charAt(cnt2);
            cnt2 += 2;
        }
        if (str1.length() > str2.length())
            res += str1.substring(cnt1, str1.length() - 1);
        else if (str1.length() < str2.length())
            res += str2.substring(cnt2, str2.length() - 1);
        return res;
    }
    // Task 3, difficulty O(n)
    public static int findAbsent(int[] array, int n)
    {
        int absent = array[0] + n;
        for (int cnt = 1; cnt < array.length && array[cnt] <= absent; ++cnt, ++absent) {}
        return absent;
    }
    // Second level
    public static int findAbsentV2(List<Integer> array, int n)
    {
        int absent = array.get(0) + n, start = 0, end = array.size() - 1;
        while (end - start != 1)
        {
            int mid = start + (end - start) / 2;
            if (array.get(mid) == absent)
            {
                absent += mid;
                for (; array.contains(absent); ++absent) {}
                return absent;
            }
            if (absent < array.get(mid))
                end = mid;
            else
                start = mid;
        }
        absent += start;
        for (; array.contains(absent); ++absent) {}
        return absent;
    }
    public static void main(String[] args)
    {
        // Test task 1
        int[] test = {3, 667, 98, 35, 15, 2, 90, 8};
        mergeSort(test, 0, 7);
        for (int i : test)
            System.out.print(i + " ");
        // Test task 2
        String one = "aaaaaaaaaa", two = "bbbbbb";
        System.out.println(mergeString(one, two));
        // Test task 3
        int[] test1 = {4, 7, 9, 10, 14};
        System.out.println(findAbsent(test1, 1));
        // Test task 4
        List<Integer>test2 = new ArrayList<>();
        test2.add(4);
        test2.add(7);
        test2.add(9);
        test2.add(10);
        test2.add(14);
        System.out.println(findAbsentV2(test2, 3));
    }
}
