package Algorithms_lab8;

public class MyLinkedList
{
    private Node head, tail;
    private int size;
    public MyLinkedList(Node head)
    {
        this.head = head;
        tail = head;
        size = 1;
    }
    @Override
    public String toString()
    {
        StringBuilder b = new StringBuilder();
        Node n = head;
        b.append("[");
        while (n != null)
        {
            b.append(n.getData());
            n = n.getNext();
            if(n != null)
                b.append(", ");
        }
        b.append("]");
        return b.toString();
    }
    public boolean contains(int data) {
        Node n = head;
        while (n != null)
        {
            if(n.getData() == data)
                return true;
            n = n.getNext();
        }
        return false;
    }

    public int get(int index) {
        if (index >= size)
            throw new NullPointerException();
        Node n = head;
        while (n != null)
        {
            if(index == 0)
                return n.getData();
            index--;
            n = n.getNext();
        }
        return 0;
    }
    public void set(int index, int data) {
        if (index >= size)
            throw new NullPointerException();
        Node n = head;
        while (n != null)
        {
            if(index == 0) {
                n.setData(data);
                return;
            }
            index--;
            n = n.getNext();
        }
    }
    public void pushToTail(int data) {
        if(head == null)
        {
            head = new Node(data);
            return;
        }
        tail.setNext(new Node(data));
        tail = tail.getNext();
        ++size;
    }
    public void pushToHead(int data)
    {
        head = new Node(data, head);
        ++size;
    }

    public void pushToIndex(int index, int data) {
        if (index > size)
            throw new NullPointerException();
        Node n = head;
        for (int i = 0; i < index - 1; ++i)
            n = n.getNext();
        Node n1 = n.getNext();
        n.setNext(new Node(data));
        n.getNext().setNext(n1);
        ++size;
    }

    public boolean removeFirst()
    {
        if (head == null)
            return false;
        Node n = head;
        head = head.getNext();
        n = null;
        --size;
        return true;
    }
    public boolean removeLast() {
        if (head == null)
            return false;
        if (size == 1) {
            head = null;
            size = 0;
            return true;
        }
        Node n = head;
        while (n.getNext().getNext() != null)
            n = n.getNext();
        n.setNext(null);
        --size;
        return true;
    }

    public void remove(int index) {
        if (size == 0 || index >= size)
            throw new NullPointerException();
        if (index == 0) {
            removeFirst();
            return;
        }
        Node n = head;
        for (int i = 0; i < index - 1; ++i)
            n = n.getNext();
        Node n1 = n.getNext().getNext();
        n.setNext(n1);
        --size;
    }
    public Node getLast() { return tail; }
}
