package Java_lab18;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTester {
    public static void main(String[] args) {
        // Stream API: Stream, primitive streams. Intermediate and Terminal operations.

        // https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html

        List<Integer> years = List.of(2000, 2022, 2021, 2027);
        //Stream<Integer> yearsStream = years.stream(); // создание потока
        Stream<Integer> yearsStream = years.stream() // stream creation
                .filter(y -> y % 2 == 0) // intermediate operation
                .filter(y -> y > 2010); // intermediate operation

        yearsStream.forEach(System.out::println); // terminal operation

        // создайте поток из имен Alexander, Max, Xenia, Maria
        // пропускайте только те имена, в которых есть буква 'n'
        // и распечатайте каждое из отфильтрованных на экране
        List<String> names = List.of("Alexander", "Max", "Xenia", "Maria");
        names.stream()
                .filter(s -> s.contains("n"))
                .forEach(s -> System.out.println("name is: " + s));

        // Stream creation - создание потока

        // Collection.<T>stream() // из коллекции
        // Arrays.stream(new Integer[] {1,2,3}) // из массива
        // Stream.of(1,2,3,4); // вручную

        // generate
        Stream<Double> randomStream =
                Stream.generate(() -> Math.random())
                        .limit(5); // сгенерировать

        randomStream.forEach(System.out::println);

        // IntStream.range(1,3) // 1 2
        // IntStream.rangeClosed(1,3) // 1 2 3

        // Intermediary functions
        // filter - отфильтровать элементы
        // map - превратить элемент в какой-то другой элемент, возможно, иного типа
        // limit(10) - оставить только 10 первых элементов
        // skip(5) - отбросить 5 первых элементов
        // sorted() - отсортировать элементы

        Arrays.stream(new Integer[]{1, 2, 3})  // 1 -> 1*1, 2 -> 2*2 ...
                .map(i -> i * i)
                .forEach(i -> System.out.println(i));
        ;

        // напишите как преобразовать поток имен в поток длин имен
        names.stream()
                .map(s -> s.length()) // заменить имя на длину имени
                .forEach(i -> System.out.println(i));// распечатать длину каждого имени

        // взять поток имен
        // и преобразовать его в вид "Max:3" etc
        // и распечатать
        names.stream()
                .map(s -> s + ":" + s.length())
                .sorted()
                .forEach(System.out::println);

        // как нам отправлять запросы потоку целиком?
        // есть ли хотябы один элемент, удовлетворяющий предикату
        System.out.println(
                names.stream().anyMatch(s -> s.contains("X"))
        );
        // все ли элементы удовлетворяют предикату
        System.out.println(
                names.stream().allMatch(s -> s.contains("X"))
        );
        // ни один элемент предикату не удовлетворяет
        System.out.println(
                names.stream().noneMatch(s -> s.contains("X"))
        );

        // Reduction 1 + 2 + 3
        int sum = Arrays.stream(new Integer[]{1, 2, 3})
                .reduce(
                        0,
                        (prev, curr) -> prev + curr
                );
        System.out.println(sum);

        // создайте поток из 2 6 3 5
        // посчитайте произведение всех этих чисел
        // используя reduce
        int mul =
                Stream.of(2, 6, 3, 5)
                        .reduce(1, (p, c) -> p * c);

        System.out.println(mul);

        // объединить все имена в одну строку
        // используя reduce

        names.stream()
                .reduce((p, c) -> p + ", " + c)
                .ifPresent(System.out::println);

        // Optional<T>
        // решает ситуацию, когда поток может не вернуть никакого значения
        // Optional либо содержит значения типа T либо признак отсутствия значения

        // https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html


        Optional<Integer> firstElement =
                Arrays.stream(new Integer[]{1, 2, 3}).filter(i -> i > 200).findFirst();

//        if(firstElement.isPresent())
//            System.out.println(firstElement.get());

        firstElement.ifPresent(System.out::println);


        names.stream()
                .filter(s -> s.contains("a"))
                .max(Comparator.naturalOrder())
                .ifPresent(s -> System.out.println("max string: " + s));

        // Collector
        // механизм сохранения элементов потока в коллекцию
        List<String> filteredNames =
                names.stream()
                        .filter(s -> s.contains("e"))
                        .map(s -> s + ":" + s.length())
                        .collect(Collectors.toList());

        // Map<String, Integer>
        Map<String, Integer> nameToLength =
                names.stream()
                        .collect(
                                Collectors.toMap(
                                        name -> name,
                                        name -> name.length()
                                )
                        );
        System.out.println(nameToLength);

        String namesCombined =
                names.stream()
                        .collect(
                                Collectors.joining(", ")
                        );

        System.out.println(namesCombined);



    }

    public static boolean containsString(List<String> l, String string) {
        for (String s : l)
            if (s.contains(string))
                return true;
        return false;
    }
}
