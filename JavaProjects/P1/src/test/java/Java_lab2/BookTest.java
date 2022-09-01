package Java_lab2;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookTest {
        @Test
        public void TestArea() {
            Author a1 = new Author("Andrzej", "Sapkowski");
            assertEquals("Andrzej Sapkowski", a1.toString());
            Book b1 = new Book("The Witcher", a1, 30.5);
            assertEquals("'The Witcher' by Andrzej Sapkowski (30,50 $)", b1.toString());
            b1.setPrice(-12);
            assertEquals("'The Witcher' by Andrzej Sapkowski (0,00 $)", b1.toString());
            Book b2 = new Book("Treasure Island", "Robert Louis Stevenson", 25);
            assertEquals("'Treasure Island' by Robert Louis Stevenson (25,00 $)", b2.toString());
            b2.setAuthor(a1);
            assertEquals("'Treasure Island' by Andrzej Sapkowski (25,00 $)", b2.toString());
            b2.setAuthor("Robert");
            assertEquals("'Treasure Island' by Robert unknown_surname (25,00 $)", b2.toString());

        }
        public List<String> filter4(List<String>names)
        {
            List<String> wideStrings = new ArrayList<>();
            for (String s : names)
            {
                if (s.length() > 4)
                    wideStrings.add(s);
            }
            return wideStrings;
        }
}
