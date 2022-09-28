package Java_lab15;

import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class BinaryTreeTester {

    public static TreeMap<String, TreeSet<String>> getMap(List<String> list)
    {
        TreeMap<String, TreeSet<String>> map = new TreeMap<>();
        for (String l : list) {
            if (map.containsKey(String.valueOf(l.charAt(0))))
                map.get(String.valueOf(l.charAt(0))).add(l);
            else
                map.put(String.valueOf(l.charAt(0)), new TreeSet<>(List.of(l)));
        }
        return map;
    }

    public static void main(String[] args) {
        MyBinaryTree.Vortex v5 = new MyBinaryTree.Vortex(5);
        MyBinaryTree.Vortex v3 = new MyBinaryTree.Vortex(3);
        MyBinaryTree.Vortex v4 = new MyBinaryTree.Vortex(4);
        MyBinaryTree.Vortex v1 = new MyBinaryTree.Vortex(1, v3, v4);
        MyBinaryTree.Vortex v2 = new MyBinaryTree.Vortex(2, null, v5);
        MyBinaryTree.Vortex v0 = new MyBinaryTree.Vortex(0, v1, v2);
        MyBinaryTree tree = new MyBinaryTree(v0);
        System.out.println(tree.countVertices());
        System.out.println(tree.depth());
        System.out.println(tree);
    }
}
