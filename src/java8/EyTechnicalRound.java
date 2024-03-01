package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Employee{
    private int id;
    private String name;
    private String department;
    private Double salary;

    public Employee(int id, String name, String department, Double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
public class EyTechnicalRound {
    public static void main(String args[]) {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "Prashanth", "IT", 45000.00));
        empList.add(new Employee(1, "Kiran", "Accounts", 25000.00));
        empList.add(new Employee(1, "Ravi", "Non IT", 15000.00));
        empList.add(new Employee(1, "Jival", "IT", 45000.00));

         List<Employee> salary = empList.stream().filter(emp -> emp.getSalary()>25000.00 && emp.getDepartment().equals("IT"))
                .collect(Collectors.toList());
         System.out.println(salary);

         List<Employee> ascEmp = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).thenComparing(Employee::getName))
                 .collect(Collectors.toList());
         System.out.println(ascEmp);
    }
}
