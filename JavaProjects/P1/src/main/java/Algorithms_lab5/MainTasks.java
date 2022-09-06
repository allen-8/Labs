package Algorithms_lab5;

public class MainTasks
{
    public static int swap(int[] array, int first, int second)
    {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
        return first;
    }
    public static void quickSort(int[] array, int start, int end, int index)
    {
        int cnt1 = start, cnt2 = end;
        while (cnt1 <= cnt2)
        {
            if (array[cnt1] > array[index]) {
                if (array[cnt2] < array[index])
                    swap(array, cnt1++, cnt2--);
                else
                    --cnt2;
                continue;
            }
            if (array[cnt2] > array[index])
                --cnt2;
            ++cnt1;
        }
        int index1 = 0;
        if (cnt1 == array.length)
            index1 = swap(array, array.length - 1, index);
        else if (index < cnt1) {
            if (array[cnt1] < array[index])
                index1 = swap(array, cnt1, index);
            else
                index1 = swap(array, cnt1 - 1, index);
        } else if (array[cnt1] > array[index])
            index1 = swap(array, cnt1, index);
        else
            index1 = swap(array, cnt1 + 1, index);
        index = index1;
        if (start + 2 == index && array[start] > array[start + 1])
            swap(array, start, start + 1);
        else if (start + 2 < index)
            quickSort(array, start, index - 1, index/2);
        if (index + 2 == end && array[index + 1] > array[end])
            swap(array, index+ 1, end);
        else if (index + 2 < end)
            quickSort(array, index + 1, end, index + 1);
    }
    public static void main(String[] args)
    {
        // Худший случай: {15, 14, 13, 12, 11, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9} при индексе 5 (число 10) - максимальное кол-во swap-ов
        // Test
        int[] array = {45, 7, 3, 89, 24, 90, 6, 43};
        quickSort(array, 0, array.length - 1, 4);
        for (int i : array)
            System.out.print(i + " ");
        
    }
}
