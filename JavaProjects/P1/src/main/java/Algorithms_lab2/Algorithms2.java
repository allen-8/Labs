package Algorithms_lab2;

public class Algorithms2
{
    // Task 1
    public static int sum(int cnt, int[] array)
    {
        return (cnt < array.length - 1) ? array[cnt] + sum(++cnt, array) : array[cnt];
    }
    // Task 2
    public static int maxEl(int max, int cnt, int[] array)
    {
        if (cnt < array.length - 1)
            max = maxEl(max, ++cnt, array);
        return Math.max(array[cnt], max);
    }
    public static void main(String[] args)
    {
        int[] array = {6, 36, 8, 89, 34, 27};
        System.out.println(sum(0, array));
        System.out.println(maxEl(0, 0, array));
    }
}
