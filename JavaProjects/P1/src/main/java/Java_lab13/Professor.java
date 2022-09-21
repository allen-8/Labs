package Java_lab13;

import java.util.ArrayList;
import java.util.List;

public class Professor implements Comparable<Professor>{
    String name;
    int salary;
    List<Student> students = new ArrayList<>();

    public Professor(String name, int salary, List<Student> students) {
        this.name = name;
        this.salary = salary;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public int compareTo(Professor o) {
        return students.size() - o.getStudents().size();
    }
}
