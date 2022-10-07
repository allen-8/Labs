package Java_lab18;

import Java_lab12.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmpTester {
    public static void main(String[] args) {
        List<Emp> employees = List.of(
                new Emp("Max Petrov", 22, "programmer"),
                new Emp("Ivan Shapovalov", 33, "analyst"),
                new Emp("Semen Dezhnev", 55, "manger"),
                new Emp("Oleg Petrov", 19, "intern"),
                new Emp("Katerina Drogova", 31, "programmer"),
                new Emp("Nikolas Spivakov", 23, "analyst"),
                new Emp("Boris Moiseev", 48, "manager"),
                new Emp("Petr Sveshnikov", 37, "programmer"),
                new Emp("Alex Con", 33, "analyst"),
                new Emp("Olga Filimonova", 27, "programmer")
        );

        // найдите самого молодого
        employees.stream()
                .min(Comparator.comparing(Emp::getAge))
                .ifPresent(System.out::println);

        // распечатайте только имена всех работников
        employees.stream()
                .map(Emp::getName)
                .forEach(System.out::println);

        // распечатать всех с возрастом больше 41 года
        employees.stream().filter(s -> s.getAge() > 41).forEach(System.out::println);

        // распечатать всех работников отсортировав их по профессии и возрасту
        employees.stream().sorted(Comparator.comparing(Emp::getPosition).thenComparing(Emp::getAge))
                .forEach(System.out::println);

        // заджойнить имена всех работников старше 36 лет через ", "
        String names = employees.stream().filter(e -> e.getAge() > 36).map(Emp::getName).
                collect(Collectors.joining(", "));

        // посчитайте сумму возрастов работников
        int sum = employees.stream().map(Emp::getAge).reduce(0, Integer::sum);

        // посчитайте количество программистов
        long countProg = employees.stream().filter(e -> Objects.equals(e.getPosition(), "programmer")).count();

        // посчитайте средний возраст
        OptionalDouble aver = employees.stream().mapToInt(Emp::getAge).average();

        // разделите на две группы - старше 40 лет и младше

        Map<Boolean, List<Emp>> oldYoung = employees.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getAge() > 40));
        // найдите профессию самого "старого" из "молодых"
        employees.stream().filter(e -> e.getAge() <=40).max(Comparator.comparingInt(Emp::getAge))
                .ifPresent(e -> System.out.println(e.getPosition()));

        // сгруппируйте по профессии
        // Collectors.groupingBy(new Function<Object, Object>() {})
        Map<String, List<Emp>> c = employees.stream().collect(Collectors.groupingBy(Emp::getPosition));

        // распечатать профессии и количество работников в ней
        c.forEach((key, value) -> System.out.println(key + ": " + value));

        // вернуть средний возраст мужчин и женщин - у женщин фамилия оканчивается на "a"
        employees.stream()
                .collect(Collectors.groupingBy(e -> e.getName().charAt(e.getName().length() - 1) == 'a'))
                .forEach((key, value) -> System.out.println(value.stream().mapToInt(Emp::getAge).average()));

    }
}
