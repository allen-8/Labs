package Java_lab14;

public class MapTester {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put("Moldova", "Cishinau");
        map.put("Hungary", "Budapest");

        System.out.println(map.get("Moldova"));
        System.out.println(map.size());
    }
}
