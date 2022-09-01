package Algorithms_lab1;

public class BubbleSort {

    public static void main(String[] args)
    {
        String[] students = {"Zero", "First", "Second", "Third", "Forth", "Fifth", "Sixth", "Seventh", "Eighth", "Nines",
        "Tenth", "Eleventh", "Twelve", "Thirteenth", "Fourteenth", "Fifteenth"};
        for (int i = 0; i < students.length - 1; ++i )
        {
            for (int j = 0; j < students.length - 1 - i; ++j)
            {
                if (students[j].compareTo(students[j + 1]) > 0)
                {
                    String str = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = str;
                }
            }
        }
        for (int i = 0; i < students.length - 1; ++i)
            System.out.println(i + 1 + ". " + students[i]);
    }
}
