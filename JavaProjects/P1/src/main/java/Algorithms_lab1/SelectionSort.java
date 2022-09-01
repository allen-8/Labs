package Algorithms_lab1;

public class SelectionSort {
    public static void main(String[] args)
    {
        String[] students = {"Zero", "First", "Second", "Third", "Forth", "Fifth", "Sixth", "Seventh", "Eighth", "Nines",
                "Tenth", "Eleventh", "Twelve", "Thirteenth", "Fourteenth", "Fifteenth"};
        for (int i = 0; i < students.length - 1; ++i)
        {
            String min = students[i];
            int pos = i;
            for (int j = i; j < students.length; ++ j)
            {
                if (students[j].compareTo(min) < 0)
                {
                    min = students[j];
                    pos = j;
                }
            }
            students[pos] = students[i];
            students[i] = min;
        }
        for (int i = 0; i < students.length; ++i)
            System.out.println(i + 1 + ". " + students[i]);
    }
}
