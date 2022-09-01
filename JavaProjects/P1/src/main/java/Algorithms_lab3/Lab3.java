package Algorithms_lab3;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class Lab3
{
    // First level
    // Task 1.1 (время работы для 2^32 - ~259600 нc)
    public static long pow (long x, long n)
    {
        if (n > 1)
            x *= pow (x, --n);
        return x;
    }
    // Task 1.2 (время работы для 2^32 - ~38300 нc)
    public static long pow2 (long x, long n)
    {
        long x1 = x;
        for (int i = 0; i < n - 1; ++i)
            x1 *= x;
        return x1;
    }
    // Task 2
    public static int findElement (int[] arr1, int[] arr2, int pos)
    {
        int counter1 = 0, counter2 = 0;
        for (int i = 0; i < pos - 1; ++i)
        {
            if (arr1[counter1] > arr2[counter2])
                ++counter2;
            else
                ++counter1;
        }
        if (counter1 != arr1.length && counter2 != arr2.length)
            return Math.min(arr1[counter1], arr2[counter2]);
        return (counter1 == arr1.length) ? arr2[counter2] : arr1[counter1];
    }
    // Task 3
    public static int countElement(int[] arr, int el)
    {
        int s = 0, e = arr.length - 1;
        while (s != e - 1)
        {
            int mid = (e + s) / 2;
            if (arr[mid] == el) {
                int cnt = 0, m = mid;
                for (int i = mid; i >= 0 && arr[i] == el; --i, ++cnt) {}
                for (int i = mid + 1; i < arr.length && arr[i] == el; ++i, ++cnt) {}
                return cnt;
            }
            if (arr[mid] > el)
                e = mid;
            else
                s = mid;
        }
        return (arr[0] == el) ? arr[0] : 0;
    }
    // Second level
    public static List<Integer> findPick(int[][]arr)
    {
        List<Integer> pickElements = new ArrayList<>();
        for (int i = 0; i < arr.length; ++i)
        {
            for (int j = 0; j < arr[i].length; ++j)
            {
                if ((i == 0 || arr[i - 1][j] < arr[i][j]) && (j == 0 || arr[i][j - 1] < arr[i][j])
                        && (i == arr.length - 1 || arr[i + 1][j] < arr[i][j]) &&
                        (j == arr[i].length - 1 || arr[i][j + 1] < arr[i][j]))
                    pickElements.add(arr[i][j]);
            }
        }
        return pickElements;
    }
    public static void main(String[] args)
    {
        int[][] arr1 = {{10, 20, 15}, {21, 30, 14}, {7, 16, 32}};
        System.out.println(findPick(arr1));
    }
}
