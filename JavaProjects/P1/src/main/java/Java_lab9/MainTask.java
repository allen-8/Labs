package Java_lab9;
import java.util.*;

public class MainTask {
    public static void main(String[] args)
    {
        List<String> countries = Arrays.asList("Andorra", "Belize", "Cayman", "France", "Argentina", "Cuba", "Sweden");
        List<String> words = Arrays.asList("Andorra", "Canada", "First", "candy", "Argentina", "wood", "parrot", "cat",
                "Alan", "Cuba", "Finland", "Axelrod" , "Avangard", "Cuba");
        List<String> a_countries = new ArrayList<>();
        for (String word : words)
        {
            if (word.charAt(0) == 'A' && countries.contains(word))
                a_countries.add(word);
        }
        System.out.println(a_countries);
    }
}
