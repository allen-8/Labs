package Java_lab8;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DoubleLinkedList implements MyList
{
    private DoubleLinkedNode head;
    private DoubleLinkedNode tail;
    static class DoubleLinkedNode
    {
        private int value;
        private DoubleLinkedList.DoubleLinkedNode next = null;
        private DoubleLinkedList.DoubleLinkedNode prev = null;
        public DoubleLinkedNode(int value) {
            this.value = value;
        }
        public DoubleLinkedNode(int value, DoubleLinkedList.DoubleLinkedNode next,
                                DoubleLinkedList.DoubleLinkedNode prev) {
            this.value = value;
            this.next = next;
            if (next != null)
                next.prev = this;
            this.prev = prev;
            if (prev != null)
                prev.next = this;
        }
        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
        public DoubleLinkedList.DoubleLinkedNode getNext() {
            return next;
        }
        public void setNext(DoubleLinkedList.DoubleLinkedNode next)
        {
            this.next = next;
            if (next != null)
                next.prev = this;
        }
        public DoubleLinkedList.DoubleLinkedNode getPrev() {
            return prev;
        }
        public void setPrev(DoubleLinkedList.DoubleLinkedNode prev)
        {
            this.prev = prev;
            if (prev != null)
                prev.next = this;
        }
    }
    @Override
    public void add(int value) {
        if (head == null)
        {
            head = new DoubleLinkedList.DoubleLinkedNode(value);
            tail = head;
            return;
        }
        tail.setNext(new DoubleLinkedNode(value));
        tail = tail.getNext();
    }
    @Override
    public String toString()
    {
        StringBuilder b = new StringBuilder();
        DoubleLinkedList.DoubleLinkedNode n = head;
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
    public void set(int index, int value) {
        DoubleLinkedList.DoubleLinkedNode n = head;
        for (int i = 0; i < index && n != null; ++i)
            n = n.getNext();
        if (n == null)
            throw new NullPointerException();
        n.setValue(value);
    }
    @Override
    public void add(int index, int value) {
        DoubleLinkedList.DoubleLinkedNode n = head;
        for (int i = 0; i < index - 1 && n != null; ++i)
            n = n.getNext();
        if (n == null)
            throw new NullPointerException();
        new DoubleLinkedNode(value, n.getNext(), n);
        if (n == tail)
            tail = n.getNext();
    }
    @Override
    public boolean contains(int value) {
        DoubleLinkedList.DoubleLinkedNode n = head;
        while (n != null)
        {
            if(n.getValue() == value)
                return true;
            n = n.getNext();
        }
        return false;
    }
    @Override
    public int get(int index)
    {
        DoubleLinkedList.DoubleLinkedNode n = head;
        for (int i = 0; i < index && n != null; ++i)
            n = n.getNext();
        if (n == null)
            throw new NullPointerException();
        return n.getValue();
    }
    @Override
    public int size() {
        int sz = 0; // size
        DoubleLinkedList.DoubleLinkedNode n = head;
        while (n != null)
        {
            sz++;
            n = n.getNext();
        }
        return sz;
    }
    @Override
    public void remove(int index) {
        DoubleLinkedList.DoubleLinkedNode n = head;
        for (int i = 0; i < index - 1; ++i)
            n = n.getNext();
        DoubleLinkedList.DoubleLinkedNode n1 = n.getNext().getNext();
        n.setNext(n1);
        if (n1 == null)
            tail = n;
    }
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>()
        {
            DoubleLinkedList.DoubleLinkedNode n = head;
            @Override
            public boolean hasNext() { return n != null && n.getNext() != null; }
            @Override
            public Integer next()
            {
                n = n.getNext();
                return n.getValue();
            }
            @Override
            public void remove()
            {
                if (n == head || n == null)
                    n = null;
                else {
                    DoubleLinkedList.DoubleLinkedNode next = n.getNext(), prev = n.getPrev();
                    prev.setNext(next);
                }
            }
        };
    }
    public void addLast(int value)
    {
        if (head == null)
        {
            head = new DoubleLinkedNode(value);
            tail = head;
            return;
        }
        tail.setNext(new DoubleLinkedNode(value));
        tail = tail.getNext();
    }
    public void removeLast()
    {
        if (head == tail)
        {
            head = null;
            tail = null;
            return;
        }
        tail = tail.getPrev();
        tail.setNext(null);
    }
    public int getLast()
    {
        if (head == null)
            throw new NullPointerException();
        return tail.getValue();
    }
    public static void main(String[]args)
    {
        String [] words = new String[] {"One", "Two", "Three", "Four", "One", "Five", "Three"};
        Set<String> set = new HashSet<>();
        for (String s : words)
        {
            int cnt = set.size();
            set.add(s);
            if (set.size() == cnt)
                System.out.println(s);
        }
    }
}
