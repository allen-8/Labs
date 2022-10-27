package Java_lab22;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class LongestWord {
    public static String longestWord(String file) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        Optional<String> str = br.lines().toList().stream()
                .flatMap(w -> Arrays.stream(w.split(" "))).max(Comparator.comparing(String::length));
        return (str.isPresent()) ? str.toString().substring(9, str.toString().length() - 1) : null;
    }
    public static void main(String[] args)
    {
        try {
            String file = "data.txt";
            System.out.println(longestWord(file));
        }
        catch (Exception e)
        {
            System.err.println("File not found!");
        }
    }
}
