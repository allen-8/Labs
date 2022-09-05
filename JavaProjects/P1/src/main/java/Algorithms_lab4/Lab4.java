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
        int cnt1 = 0, cnt2 = 0;
        StringBuilder res = new StringBuilder();
        while (cnt1 < str1.length() && cnt2 < str2.length())
        {
            res.append(str1.charAt(cnt1++));
            res.append(str2.charAt(cnt2++));
        }
        if (str1.length() > str2.length())
            res.append(str1.substring(cnt1, str1.length() - 1));
        else if (str1.length() < str2.length())
            res.append(str2.substring(cnt2, str2.length() - 1));
        return res.toString();
    }
    // Task 3, difficulty O(n)
    public static int findAbsent(int[] array, int n)
    {
        int absent = array[0] + n;
        for (int cnt = 1; cnt < array.length && array[cnt] <= absent; ++cnt, ++absent) {}
        return absent;
    }
    // Second level
    public static int findAbsentV2(int[] array, int n)
    {
        int absent = array[0] + n, start = 0, end = array.length - 1;
        while (end - start != 1) // находим крайний левый элемент массива бинарным поиском
        {
            int mid = start + (end - start) / 2;
            if (array[mid] == absent) // если попали на существующий элемент массива
            {
                // если результат больше последнего элемента, просто прибавляем длину всего массива и возвращаем результат
                if (absent + mid > array[array.length - 1])
                    return absent + array.length - 1;
                // добавляем кол-во элементов массива до найденного (mid)
                for (int i = 0; i < mid || (i == mid && mid + 1 < array.length && absent == array[mid + 1]); ++i)
                {
                    if (mid + 1 >= array.length)
                    {
                        ++absent;
                        continue;
                    }
                    if (absent == array[mid + 1])
                        ++mid;
                    ++absent;
                }
                return absent;
            }
            if (absent < array[mid])
                end = mid;
            else
                start = mid;
        }
        if (absent + start > array[array.length - 1])
            return absent + array.length - 1;
        // если не попали на существующий элемент массива, используем крайний слева
        for (int i = 0; i < start || (i == start && start + 1 < array.length && absent == array[start + 1]); ++i)
        {
            if (start + 1 >= array.length)
            {
                ++absent;
                continue;
            }
            if (absent == array[start + 1])
                ++start;
            ++absent;
        }
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
        int[] test2 = {4, 7, 9, 10, 14};
        System.out.println(findAbsentV2(test2, 3));
    }
}
