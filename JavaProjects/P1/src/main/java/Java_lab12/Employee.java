package Java_lab12;

import java.util.Comparator;

public class Employee implements Comparable<Employee>
{
    int id, age, salary;
    String name;

    public Employee(int id, int age, int salary, String name) {
        this.id = id;
        this.age = age;
        this.salary = salary;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id = " + id +
                ", age = " + age +
                ", salary = " + salary +
                ", name = '" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return this.id - o.getId();
    }
    public static class EmployeeSalaryComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getSalary() - o2.getSalary();
        }
    }
    public static class EmployeeAgeComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getAge() - o2.getAge();
        }
    }
    public static class EmployeeNameComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
