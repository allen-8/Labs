package Java_lab13;

public class Student
{
    String name, specialty;
    int age;

    public Student(String name, String specialty, int age) {
        this.name = name;
        this.specialty = specialty;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
