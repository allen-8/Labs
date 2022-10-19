package Java_lab21;

import java.io.*;
import com.google.gson.*;

public class DogSerializer {
    public static void main(String[] args) throws IOException {
        Dog sharik = new Dog("Sharik", 3);
        serialize(sharik);
        Dog dog = deserialize();
        if (dog != null)
            System.out.println(dog.name + " " + dog.age);
        else
            System.out.println("Something went wrong...");
    }
    public static void serialize(Dog dog) throws IOException {
        Gson gson = new GsonBuilder().create();
        try {
            FileWriter f = new FileWriter("dog.json");
            f.write(gson.toJson(dog));
            f.close();
        }
        catch (Exception e)
        {
            System.err.println("Cannot open the file dog.json!");
        }
    }
    public static Dog deserialize() throws IOException
    {
        Gson gson = new GsonBuilder().create();
        try {
            FileReader f = new FileReader("dog.json");
            return gson.fromJson(f, Dog.class);
        }
        catch (Exception e) {
            System.err.println("Cannot open the file dog.json!");
        }
        return null;
    }
}

class Dog implements Serializable {
    public String name;
    public int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
