package Algorithms_lab7;

public class TestFibonacci {
    public static int rec(int n)
    {
        if (n < 2)
            return n;
        return rec(n - 1) + rec(n - 2);
    }

    public static int fibonacciOPMemo(int n, int[] arr)
    {
        if (n < 2)
            return n;
        if (arr[n] != -1)
            return arr[n];
        arr[n] =  fibonacciOPMemo(n - 1, arr) + fibonacciOPMemo(n - 2, arr);
        return arr[n];
    }
    public static int fibonacciTab(int n)
    {
        int[] arr = new int[n + 1];
        arr[0] = 0; arr[1] = 1;
        for (int i = 2; i <= n; ++i) {
            arr[i] = arr[i - 1] + arr[i - 2];
            if (i == n)
                return arr[i];
        }
        return -1;
    }
    public static void main(String[] args)
    {
        int n = 50;
        int[] arr = new int[n + 1];
        for (int i = 2; i < n; ++i)
            arr[i] = -1;
        // Test standard recursion
        long start = System.currentTimeMillis();
        rec(n);
        long time = System.currentTimeMillis() - start;
        System.out.println("Standard recursion time: " + time);
        // Test memoization
        start = System.currentTimeMillis();
        fibonacciOPMemo(n, arr);
        time = System.currentTimeMillis() - start;
        System.out.println("Memoization time: " + time);
        // Test without recursion
        start = System.currentTimeMillis();
        fibonacciTab(n);
        time = System.currentTimeMillis() - start;
        System.out.println("Time without recursion: " + time);
        /* Результаты для n = 50:
        Standard recursion time: 75912
        Memoization time: 0
        Time without recursion: 0
        Вычислить время стандартной рекурсии для больших значений n затруднительно.
            Результаты для n = 1 000 000:
        Memoization time: 0
        Time without recursion: 16
            Результаты для n = 100 000 000:
        Memoization time: 0
        Time without recursion: 378
         */
    }
}
