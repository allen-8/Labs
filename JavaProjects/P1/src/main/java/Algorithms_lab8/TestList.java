package Algorithms_lab8;

public class TestList {
    // find middle element with recursion
    public static int middle(Node node, int n, int[] res)
    {
            if (node == null)
                return n;
            int d = middle(node.getNext(), ++n, res);
            if (d / 2 == n)
            { //code fixed here
                res[0] = (d % 2 == 1) ? node.getData() : node.getNext().getData();
                return -1;
            }
            return d;
    }
    public static boolean checkLoops(MyLinkedList list)
    {
        try {
            int i = 0;
            for (; i < list.getSize(); ++i) {}
            list.get(i);
            return true;
        } catch (NullPointerException n) {
            return false;
        }
    }
    public static void main(String[] args) {
        Node n1 = new Node(45);
        Node n2 = new Node(56, n1);
        Node n3 = new Node(23, n2);
        Node n4 = new Node(78, n3);
        Node n5 = new Node(54, n4);
        Node n6 = new Node(12, n5);
        Node n7 = new Node(89, n6);
        Node n8 = new Node(3, n7);
        MyLinkedList list = new MyLinkedList(n1);
        list.pushToTail(56); list.pushToTail(34); list.pushToTail(76);
        System.out.println(checkLoops(list));
        int[] res = {0};
        middle(n8, 0, res);
        System.out.println(res[0]);
    }
}
