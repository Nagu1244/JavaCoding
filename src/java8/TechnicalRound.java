package java8;

import java.util.*;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;
        return id == employee.id &&
                Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(name, employee.name) &&
                Objects.equals(department, employee.department);
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
public class TechnicalRound {
    public static void main(String args[]) {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "Prashanth", "IT", 45000.00));
        empList.add(new Employee(2, "Airan", "IT", 55000.00));
        empList.add(new Employee(3, "Vikram", "IT", 55000.00));
        empList.add(new Employee(4, "Harani", "Accounts", 25000.00));
        empList.add(new Employee(9, "Ravi", "Accounts", 35000.00));
        empList.add(new Employee(5, "Ravi", "Accounts", 15000.00));
        empList.add(new Employee(6, "Jival", "HR", 45000.00));
        empList.add(new Employee(7, "Vijay", "HR", 25000.00));
        empList.add(new Employee(8, "Prerama", "HR", 40000.00));

        //Find 1st maximum salary from each department(scenario:two employees having same salary)
        Map<String, List<Employee>> depGrpEmp = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        Map<String, List<String>> maxSalaryEmpNames = depGrpEmp.entrySet().stream().collect(Collectors.toMap(entry -> entry.getKey(), entry -> getMaxSalary(entry.getValue())));
        System.out.println("Maximum salary employee names from each Department : " + maxSalaryEmpNames);

        //Sort names of an employees in each department in asc order
        Map<String, List<String>> empNamesFromDeprtment = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment,TreeMap::new, Collectors.mapping(Employee::getName, Collectors.collectingAndThen(Collectors.toList(),
                list -> {
                   Collections.sort(list);
                   return list;
                }))));
        System.out.println("employee names in asc order from each department : " +empNamesFromDeprtment);

        //Get Top 2 Highest Paid Employees per Department
        Map<String, List<Double>> highestTwoSalaryEmp = empList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparing(Employee::getSalary).reversed())
                                        .map(Employee::getSalary)
                                        .limit(2)
                                        .toList()
                        )
                ));
        System.out.println("Top 2 Highest Paid Employees per Department : " + highestTwoSalaryEmp);

         List<Employee> salary = empList.stream().filter(emp -> emp.getSalary()>25000.00 && emp.getDepartment().equals("IT"))
                .collect(Collectors.toList());
         System.out.println(salary);

         List<Employee> ascEmp = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).thenComparing(Employee::getName))
                 .collect(Collectors.toList());
         System.out.println(ascEmp);
    }
    private static List<String> getMaxSalary(List<Employee> value) {
        //find Max Salary from each Department
        double maxSalary = value.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).map(Employee::getSalary).findFirst().get();
        List<String> maxList = value.stream().filter(emp -> emp.getSalary() == maxSalary).map(Employee::getName).collect(Collectors.toList());
        return maxList;
    }
}
