package Java_lab20;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class Lab20 {
    public static void main(String[] args)
    {
        List<String> list = Arrays.asList(
                "A Study in Scarlet is a 1887 detective novel by British writer Arthur Conan Doyle",
                "The story marks the first appearance of Sherlock Holmes and Dr. Watson",
                "who would become the most famous detective duo in literature",
                "The book's title derives from a speech given by Holmes",
                "a consulting detective, to his friend and chronicler Watson on the nature of his work",
                "in which he describes the story's murder investigation as his study in scarlet",
                "There's the scarlet thread of murder running through the colourless skein of life",
                "and our duty is to unravel it, and isolate it, and expose every inch of it");
        Map<String, Set<Integer>> res = list.stream().map(s -> s.replace(",", ""))
                .map(String::toLowerCase).collect(new Collector<String, Map<String, Set<Integer>>, Map<String, Set<Integer>>>() {
                    int cnt = 0;
                    @Override
                    public Supplier<Map<String, Set<Integer>>> supplier() {
                        return HashMap::new;
                    }

                    @Override
                    public BiConsumer<Map<String, Set<Integer>>, String> accumulator() {
                        return (m, str) -> {
                            Arrays.asList(str.split(" ")).forEach(s -> {
                                Set<Integer> l1 = (m.containsKey(s)) ? m.get(s) : new HashSet<>();
                                l1.add(cnt);
                                m.put(s, l1);
                            });
                            ++cnt;
                        };
                    }

                    @Override
                    public BinaryOperator<Map<String, Set<Integer>>> combiner() {
                        return (f, s) -> {
                            f.putAll(s);
                            return f;
                        };
                    }

                    @Override
                    public Function<Map<String, Set<Integer>>, Map<String, Set<Integer>>> finisher() {
                        return map -> map;
                    }

                    @Override
                    public Set<Characteristics> characteristics() {
                        return Set.of(Characteristics.UNORDERED, Characteristics.IDENTITY_FINISH);
                    }
                });
        System.out.println(res);
    }
}
