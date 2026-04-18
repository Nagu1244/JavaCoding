package java8;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

class Employee{
    private int id;
    private String name;
    private String department;
    private Double salary;
    private String gender;
    private String city;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private LocalDate joinDate;
    private String designation;
    private boolean isManager;
    private int yearsOfExperience;

    public Employee(int id, String name, String department, Double salary, String gender,
                    String city, String email, String phoneNumber, LocalDate dateOfBirth,
                    LocalDate joinDate, String designation, boolean isManager, int yearsOfExperience) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.gender = gender;
        this.city = city;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.joinDate = joinDate;
        this.designation = designation;
        this.isManager = isManager;
        this.yearsOfExperience = yearsOfExperience;
    }

    // Getters and Setters
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;
        return id == employee.id &&
                Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(name, employee.name) &&
                Objects.equals(department, employee.department) &&
                Objects.equals(gender, employee.gender) &&
                Objects.equals(city, employee.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, department, salary, gender, city);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", joinDate=" + joinDate +
                ", designation='" + designation + '\'' +
                ", isManager=" + isManager +
                ", yearsOfExperience=" + yearsOfExperience +
                ", age=" + getAge() +
                '}';
    }
}
public class EmployeeTechnicalRound {
    public static void main(String args[]) {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "Prashanth", "IT", 95000.00, "Male", "Bangalore",
                "prashanth@company.com", "9876543210", LocalDate.of(1990, 5, 15),
                LocalDate.of(2015, 3, 20), "Senior Manager", true, 9));

        empList.add(new Employee(2, "Airan", "IT", 65000.00, "Male", "Hyderabad",
                "airan@company.com", "9876543211", LocalDate.of(1995, 8, 22),
                LocalDate.of(2018, 6, 10), "Senior Developer", false, 6));

        empList.add(new Employee(3, "Vikram", "IT", 65000.00, "Male", "Bangalore",
                "vikram@company.com", "9876543212", LocalDate.of(1996, 2, 10),
                LocalDate.of(2018, 7, 15), "Developer", false, 6));

        empList.add(new Employee(4, "Harani", "Accounts", 65000.00, "Female", "Mumbai",
                "harani@company.com", "9876543213", LocalDate.of(1992, 11, 5),
                LocalDate.of(2017, 4, 1), "Senior Accountant", false, 7));

        empList.add(new Employee(9, "Ravi", "Accounts", 35000.00, "Male", "Bangalore",
                "ravi@company.com", "9876543214", LocalDate.of(1999, 7, 30),
                LocalDate.of(2022, 1, 15), "Junior Accountant", false, 2));

        empList.add(new Employee(5, "Pranav", "Accounts", 15000.00, "Male", "Delhi",
                "pranav@company.com", "9876543215", LocalDate.of(2002, 3, 18),
                LocalDate.of(2023, 8, 20), "Intern", false, 0));

        empList.add(new Employee(6, "Jival", "HR", 65000.00, "Female", "Bangalore",
                "jival@company.com", "9876543216", LocalDate.of(1994, 9, 12),
                LocalDate.of(2017, 5, 10), "HR Manager", true, 7));

        empList.add(new Employee(7, "Vijay", "HR", 25000.00, "Male", "Chennai",
                "vijay@company.com", "9876543217", LocalDate.of(2000, 12, 25),
                LocalDate.of(2021, 9, 1), "HR Executive", false, 3));

        empList.add(new Employee(8, "Prerana", "HR", 95000.00, "Female", "Bangalore",
                "prerana@company.com", "9876543218", LocalDate.of(1988, 1, 8),
                LocalDate.of(2013, 2, 15), "Director", true, 11));

        System.out.println("\n========== ORIGINAL EXAMPLES ==========\n");

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

        //Get Top 1 Highest Paid Employees per Department

        Map<String, List<String>> highestEmpNamesDep = empList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream().collect(Collectors.groupingBy(Employee::getSalary))
                                        .entrySet().stream().sorted(Map.Entry.<Double, List<Employee>>comparingByKey().reversed())
                                        .limit(1)
                                        .flatMap(e -> e.getValue().stream()).map(Employee::getName)
                                        .toList()
                        )
                ));
        System.out.println("Top 1 Highest Paid Employees per Department: " +highestEmpNamesDep);

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
         * if more than one employee having same salary in each department, then groupBy salary
         */

       Map<String, Map<Double, List<String>>> maxSalaryEmp = empList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> {
                                    double maxSalary = list.stream()
                                            .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
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

       //find the sum of all salaries in org
        double salarySum = empList.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(salarySum);

        //find sum of salary for each department
        Map<String, Double> sumEachDeprt = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
        System.out.println("sum of salary for each department : " + sumEachDeprt);

        /**
         * Count the total male and female employees in organization/department
         */

        Map<String, Long> maleFamaleCount = empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Male and Female count in organization : " + maleFamaleCount);

        Map<String, Map<String, Long>> maleFemaleCountPerDepartment = empList.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> list.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()))
                )
                ));
        System.out.println("Male and Female count per department : " + maleFemaleCountPerDepartment);

        /**
         * get employees names from branch (city)
         */
        Map<String, List<String>> employeePerCity = empList.stream().collect(Collectors.groupingBy(Employee::getCity, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println("employee per city : " + employeePerCity);

    }
    private static List<String> getMaxSalary(List<Employee> value) {
        //find Max Salary from each Department
        double maxSalary = value.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).map(Employee::getSalary).findFirst().get();
        List<String> maxSalartEmp = value.stream().filter(emp -> emp.getSalary() == maxSalary).map(Employee::getName).collect(Collectors.toList());
        return maxSalartEmp;
    }

}
