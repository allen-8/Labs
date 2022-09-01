

// Homework starts on 96 line

package Java_lab8;
import java.util.Iterator;
public class MyLinkedList implements MyList {

    private Node head;

    @Override
    public String toString()
    {
        StringBuilder b = new StringBuilder();
        Node n = head;
        b.append("[");
        while (n != null)
        {
            b.append(n.getValue());
            n = n.getNext();
            if(n != null)
                b.append(", ");
        }
        b.append("]");
        return b.toString();
    }
    @Override
    public void add(int value) {
        if(head == null)
        {
            head = new Node(value);
            return;
        }
        Node n = head;
        while (n.getNext() != null)
        {
            n = n.getNext();
        }
        n.setNext(new Node(value));
    }

    @Override
    public void set(int index, int value) {
        Node n = head;
        while (n != null)
        {
            if(index == 0) {
                n.setValue(value);
                return;
            }
            index--;
            n = n.getNext();
        }
    }

    @Override
    public void add(int index, int value) {
        Node n = head;
        for (int i = 0; i < index - 1; ++i)
            n = n.getNext();
        Node n1 = n.getNext();
        n.setNext(new Node(value));
        n.getNext().setNext(n1);
    }
    @Override
    public boolean contains(int value) {
        Node n = head;
        while (n != null)
        {
            if(n.getValue() == value)
                return true;
            n = n.getNext();
        }
        return false;
    }
    @Override
    public int get(int index) {
        Node n = head;
        while (n != null)
        {
            if(index == 0)
                return n.getValue();
            index--;
            n = n.getNext();
        }
        return 0;
    }
    @Override
    public int size() {
        int sz = 0; // size
        Node n = head;
        while (n != null)
        {
            sz++;
            n = n.getNext();
        }
        return sz;
    }
    // HOMEWORK
    @Override
    public void remove(int index) {
        Node n = head;
        for (int i = 0; i < index - 1; ++i)
            n = n.getNext();
        Node n1 = n.getNext().getNext();
        n.setNext(n1);
    }
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>()
        {
            Node n = head, prev_n = head;
            @Override
            public boolean hasNext() { return n != null && n.getNext() != null; }
            @Override
            public Integer next()
            {
                prev_n = n;
                n = n.getNext();
                return n.getValue();
            }
            @Override
            public void remove()
            {
                if (n == head || n == null)
                    n = null;
                else {
                    Node n2 = n.getNext();
                    prev_n.setNext(n2);
                    n = prev_n;
                }
            }
        };
    }
    public void addFirst(int value)  { head = new Node(value, head); }
    public void removeFirst()
    {
        if (head != null)
            head = head.getNext();
    }
    public int getFirst()
    {
        if (head != null)
            return head.getValue();
        else
            throw new NullPointerException();
    }
    static class Node
    {
        private int value;
        private Node next = null;
        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
    }


    public static void main(String[] args) {
        // Node n = new MyLinkedList().new Node(); // внутренний не статический класс
        // Node n = new MyLinkedList.Node(); // внутренний статический класс
        MyLinkedList l = new MyLinkedList();
        System.out.println(l);
        l.add(1);
        l.add(2);
        l.add(3);
        System.out.println(l);
    }
}

