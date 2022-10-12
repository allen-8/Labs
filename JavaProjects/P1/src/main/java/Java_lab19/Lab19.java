package Java_lab19;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lab19 {
    public static void main(String[] args)
    {
        List<String> list = Arrays.asList("one", "two", "three", "two", "four", "three");
        System.out.println(list.stream().collect(Collectors.groupingBy(s -> s)).values().stream()
                .map(List::size).filter(s -> s == 1).count());
    }
}
