package collections;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
         int prime=31;
         int result =1;
         result = (result * prime) + ((name==null ? null : name.hashCode()));
         return result;
    }
}
public class SetDemo {
    public static void main(String args[]){
        Set<Employee> set = new HashSet<>();
        set.add(new Employee(1, "Nagaraj"));
        set.add(new Employee(1, "Nagaraj"));
        System.out.println(set.size());
    }
}
