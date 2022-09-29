package Algorithms_lab7;

public class TestStack {
    public static void reverseStack(Stack s, Stack reverse)
    {
        reverse.push(s.pop());
        if (!s.isEmpty())
            reverseStack(s, reverse);
    }
    public static void main(String[] args)
    {
        // Test task 2
        Stack s = new Stack();
        s.push(67); s.push(34); s.push(89); s.push(12); s.push(42);
        System.out.println(s.getMin());
        s.pop(); s.pop();
        System.out.println(s.getMin());
        // Test task 3
        s.push(78); s.push(356);
        System.out.print("Current stack: ");
        s.printStack();
        Stack reverse = new Stack();
        reverseStack(s, reverse);
        System.out.print("\nReversed stack: ");
        reverse.printStack();
    }
}
