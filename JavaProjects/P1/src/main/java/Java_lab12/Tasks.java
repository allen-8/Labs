package Java_lab12;

import java.util.*;

public class Tasks
{
    // Task 5
    public static void deleteOdds(List<Integer>list)
    {
        Set<Integer> set = new HashSet<>(list);
        for (int i : set)
        {
            if (Collections.frequency(list, i) % 2 == 1)
                list.removeIf(integer -> integer == i);
        }
    }
    // Task 6
    public static void complexSort(List<Employee> emps, List<Comparator<Employee>> comparators)
    {
        if (comparators.size() == 0)
            return;
        Comparator<Employee> c = comparators.get(0);
        for (int i = 1; i < comparators.size(); ++i)
            c = c.thenComparing(comparators.get(i));
        emps.sort(c);
    }
    public static void main(String[] args)
    {
        // Test tasks 1-4
        List<Employee> employees = new ArrayList<>() {{
            add(new Employee(1, 30, 200, "Alex"));
            add(new Employee(2, 25, 300, "Martin"));
            add(new Employee(3, 40, 250, "Ivan"));
            add(new Employee(4, 34, 350, "Nikolay"));
        }};
        // sort by id
        Collections.sort(employees);
        System.out.println(employees);
        //sort by age then by name
        employees.sort(new Employee.EmployeeAgeComparator()
                .thenComparing(new Employee.EmployeeNameComparator()));
        System.out.println(employees);
        // Test task 5
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 6, 4, 2, 3, 3, 6, 2, 2, 7, 7));
        deleteOdds(list);
        System.out.println(list);
        // Test task 6
        List<Employee> emps = new ArrayList<>() {{
            add(new Employee(1, 30, 200, "Alex"));
            add(new Employee(2, 25, 300, "Martin"));
            add(new Employee(3, 40, 250, "Ivan"));
            add(new Employee(4, 34, 350, "Nikolay"));
            add(new Employee(5, 34, 300, "Nikolay"));
            add(new Employee(6, 40, 350, "Martin"));
            add(new Employee(7, 25, 200, "Alex"));
        }};
        List<Comparator<Employee>> comparators = new ArrayList<>() {{
            add(new Employee.EmployeeNameComparator()); add(new Employee.EmployeeAgeComparator());
            add(new Employee.EmployeeSalaryComparator());}};
        complexSort(emps, comparators);
        System.out.println(emps);
    }
}
