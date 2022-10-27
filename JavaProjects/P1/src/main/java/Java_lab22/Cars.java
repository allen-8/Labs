package Java_lab22;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    public static void main(String[] args) {
        Car c1 = new Car("Mitsubishi", "Lancer", 33_000);
        Car c2 = new Car("Mitsubishi", "Lancer Evo 4", 64_000);
        Car c3 = new Car("Subaru", "WRX STI", 62_000);
        Car c4 = new Car("Subaru", "Forrester", 23_000);
        Car c5 = new Car("Nissan", "GTR", 73_000);
        Car c6 = new Car("Mitsubishi", "Gallant", 14_000);
        List<Car> cars = List.of(c1,c2,c3,c4,c5,c6);
        System.out.println(sortCars(cars));
    }
    public static TreeMap<String, List<Car>> sortCars(List<Car> cars)
    {
        TreeMap<String, List<Car>> res = cars.stream().collect(Collectors.groupingBy(Car::getMaker))
                .entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> newValue, TreeMap::new));
        res.forEach((key, value) -> value.sort(Comparator.comparing(Car::getPrice)));
        return res;
    }
}

class Car {
    public String maker;
    public String model;
    public double price;
    public Car(String maker, String model, double price) {
        this.maker = maker;
        this.model = model;
        this.price = price;
    }
    public String getMaker() {
        return maker;
    }
    public String getModel() {
        return model;
    }
    public double getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return "c{" +
                "ma='" + maker + '\'' +
                ", mo='" + model + '\'' +
                ", p=" + price +
                '}';
    }
}