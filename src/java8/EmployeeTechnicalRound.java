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
public class EmployeeTechnicalRound {
    public static void main(String args[]) {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "Prashanth", "IT", 95000.00));
        empList.add(new Employee(2, "Airan", "IT", 65000.00));
        empList.add(new Employee(3, "Vikram", "IT", 65000.00));
        empList.add(new Employee(4, "Harani", "Accounts", 65000.00));
        empList.add(new Employee(9, "Ravi", "Accounts", 35000.00));
        empList.add(new Employee(5, "Pranav", "Accounts", 15000.00));
        empList.add(new Employee(6, "Jival", "HR", 65000.00));
        empList.add(new Employee(7, "Vijay", "HR", 25000.00));
        empList.add(new Employee(8, "Prerama", "HR", 95000.00));

        //Find 1st maximum salary from each department(scenario:two employees having same salary)
        Map<String, List<Employee>> depGrpEmp = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        Map<String, List<String>> maxSalaryEmpNames = depGrpEmp.entrySet().stream().collect(Collectors.toMap(entry -> entry.getKey(), entry -> getMaxSalary(entry.getValue())));
        System.out.println("Maximum salary employee names from each Department : " + maxSalaryEmpNames);

        //Sort names of an employees in each department in asc order
        Map<String, List<String>> empNamesFromDeprtment = empList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                              Collectors.toList(),
                              list -> list.stream().sorted(Comparator.comparing(Employee::getName)).map(Employee::getName).collect(Collectors.toList())
                        )));
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

        //Get Top 2 Highest Paid Employees per Department if employees having same salary

        Map<String, List<String>> highestEmpNamesDep = empList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream().collect(Collectors.groupingBy(Employee::getSalary))
                                        .entrySet().stream().sorted(Map.Entry.<Double, List<Employee>>comparingByKey().reversed())
                                        .limit(2)
                                        .flatMap(e -> e.getValue().stream()).map(Employee::getName)
                                        .toList()
                        )
                ));
        System.out.println("Highest Paid Employees per Department if employees having same salary : " +highestEmpNamesDep);

        Map<String, List<String>> result =
                empList.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> list.stream()
                                                .filter(emp -> emp.getSalary() > 30000)
                                                .map(Employee::getName)
                                                .toList()
                                )
                        ));
         System.out.println("Get Employee detail who has salary >30000 : " + result);

         List<Employee> ascEmp = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).thenComparing(Employee::getName))
                 .collect(Collectors.toList());
         System.out.println(ascEmp);

        /**
         * Find maximum salary of an employee from each department:
         *
         */

       Map<String, Map<Double, List<String>>> maxSalaryEmp = empList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> {
                                    double maxSalary = list.stream()
                                            .sorted(Comparator.comparing(Employee::getSalary).reversed())
                                            .map(Employee::getSalary)
                                            .findFirst()
                                            .get();
                                    return list.stream()
                                            .filter(emp -> emp.getSalary() == maxSalary)
                                            .collect(Collectors.groupingBy(
                                                    Employee::getSalary,
                                                    Collectors.mapping(Employee::getName, Collectors.toList())
                                            ));
                                }
                        )));

       System.out.println("Maximum salary emp from each department : " + maxSalaryEmp);
       /*
        * Maximum salary emp from organization, very important and confusion pls focus more on this
        */

       double maxSalary = empList.stream()
               .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
               .map(Employee::getSalary)
               .findFirst()
               .orElse(null);
       List<String> maxSalaryEmpNames1 = empList.stream().filter(emp -> emp.getSalary() == maxSalary)
               .map(Employee::getName).collect(Collectors.toList());
       System.out.println(maxSalaryEmpNames1);

       //find the sum of all salries in org
        double salarySum = empList.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(salarySum);

        //find sum of salary for each department
        Map<String, Double> sumEachDeprt = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
        System.out.println(sumEachDeprt);
    }
    private static List<String> getMaxSalary(List<Employee> value) {
        //find Max Salary from each Department
        double maxSalary = value.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).map(Employee::getSalary).findFirst().get();
        List<String> maxList = value.stream().filter(emp -> emp.getSalary() == maxSalary).map(Employee::getName).collect(Collectors.toList());
        return maxList;
    }

}
