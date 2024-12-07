package betterjava.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TheNewTester {
    public static void main(String[] args) {
        Employee e1 = new Employee(2, 3000);
        Employee e2 = new Employee(2, 4000);
        Employee e3 = new Employee(4, 5000);
        Employee e4 = new Employee(4, 1000);
        Department d1 = new Department(List.of(e1, e2));
        Department d2 = new Department(List.of(e3, e4));

        List<Department> departments = List.of(d1, d2);
        Map<Integer, Optional<Employee>> collect = departments.stream().flatMap(department -> department.getEmployeeList().stream()).collect(Collectors.groupingBy(Employee::getDepartmentId, Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))));
        collect.values().stream().map(x -> x.get().getSalary()).forEach(System.out::println);
    }

    void method1(List<String> test) {
        System.out.println("Hi ");
    }

    static class Employee {

        private Integer departmentId;
        private Integer salary;
        public Employee(Integer departmentId, Integer salary) {
            this.departmentId = departmentId;
            this.salary = salary;
        }

        public Integer getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(Integer departmentId) {
            this.departmentId = departmentId;
        }

        public Integer getSalary() {
            return salary;
        }

        public void setSalary(Integer salary) {
            this.salary = salary;
        }
    }

    static class Department {
        private List<Employee> employeeList;

        public Department(List<Employee> employeeList) {
            this.employeeList = employeeList;
        }

        public List<Employee> getEmployeeList() {
            return employeeList;
        }

        public void setEmployeeList(List<Employee> employeeList) {
            this.employeeList = employeeList;
        }
    }
}
