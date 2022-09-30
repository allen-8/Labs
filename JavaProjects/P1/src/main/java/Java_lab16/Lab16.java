package Java_lab16;

import java.util.Arrays;
import java.util.Collections;

public class Lab16 {
    // Task 1
    public static String code(String s)
    {
        if (s.length() == 0)
            return "";
        if (s.length() == 1)
            return 1 + s;
        StringBuilder coded = new StringBuilder();
        int cnt = 1;
        for (int i = 1; i < s.length(); ++i)
        {
            if (s.charAt(i) == s.charAt(i - 1))
                ++cnt;
            else {
                coded.append(cnt).append(s.charAt(i - 1));
                cnt = 1;
            }
        }
        if (cnt > 0)
            coded.append(cnt).append(s.charAt(s.length() - 1));
        return coded.toString();
    }
    // Task 2
    public static String decode(String s)
    {
        if (s.length() == 0 || s.length() % 2 == 1)
            return "Incorrect format!";
        StringBuilder decoded = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2)
            decoded.append(String.join("", Collections.nCopies(Character.getNumericValue(s.charAt(i)),
                    String.valueOf(s.charAt(i + 1)))));
        return decoded.toString();
    }
    // Task 3
    public static boolean multiplySearch(int[] a, int b)
    {
        for (int i : a)
            if (b % i == 0 && Arrays.binarySearch(a, b / i) >= 0)
                return true;
        return false;
    }
    public static void main(String[] args)
    {
        String str = "a", str1 = "aaaabbcccdaaa";
        System.out.println(code(str));
        System.out.println(code(str1));
        System.out.println(decode(code(str1)));
        int[] a = new int[] {5, 7, 12, 2};
        System.out.println(multiplySearch(a, 10));
    }
}
