package Java_lab22;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Objects;

public class Dir {
    public static void dir(File d) throws FileNotFoundException {
        if (!d.exists())
            throw new FileNotFoundException();
        String sep = System.getProperty("file.separator");
        Arrays.stream(Objects.requireNonNull(d.list())).forEach(f -> {
            File file = new File(d + sep + f);
            String data = (file.isFile()) ? "-" : "d";
            System.out.println(data + "   " + file.length() + "   " + file.getName());
        });
    }
    public static void main(String[] args) throws FileNotFoundException {
        try {
            File f = new File("D:/");
            dir(f);
        } catch (Exception e) {
            System.err.println("File not found!");
        }
    }
}
