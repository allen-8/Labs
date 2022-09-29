package Algorithms_lab7;

import static java.lang.Math.pow;

public class Stack {
        private int top = -1, min = -1;
        private int arr[] = new int[1000];
        private int mins[] = new int[1000];
        public boolean isEmpty()  { return top < 0; }
        public int peek()
        {
                if (top < 0)
                {
                        System.out.println("Stack is empty");
                        return 0;
                }
                return arr[top];
        }
        public int pop()
        {
                if (top < 0)
                {
                        System.out.println("Stack is empty");
                        return 0;
                }
                if (arr[top] == mins[min])
                        --min;
                return arr[top--];
        }
        public boolean push(int x)
        {
                if (top < 999)
                {
                        arr[++top] = x;
                        if (top == 0 || x < mins[min])
                                mins[++min] = x;
                        return true;
                }
                return false;
        }
        public int getMin() { return mins[min]; }
        public void printStack()
        {
                for (int i = top; i >= 0; --i)
                        System.out.print(arr[i] + " ");
        }

public static void main(String[] args)
{
        double[] u = {1, 2.24, 3, 3.4, 1.86, 2.48, 2.08, 0.8};
        double[] pn = {0.12, 0.08, 0.18, 0.04, 0.16, 0.15, 0.14, 0.12};
        for (int i = 0; i < 8; ++i)
                for (int j = 1; j <= 5; ++j)
                        System.out.println(pow((1/(1 + pow(u[i] - j + 1, 2))), pn[i]));
}
}
