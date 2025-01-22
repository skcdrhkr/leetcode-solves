package betterjava.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamingDepartment {
    public static void main(String[] args) {
        EmployeeD employee1 = new EmployeeD(4000.0, 1);
        EmployeeD employee2 = new EmployeeD(5000.0, 1);
        EmployeeD employee3 = new EmployeeD(4500.0, 1);
        EmployeeD employee4 = new EmployeeD(3000.0, 2);
        EmployeeD employee5 = new EmployeeD(3000.0, 2);
        EmployeeD employee6 = new EmployeeD(3020.0, 2);
        EmployeeD employee7 = new EmployeeD(1000.0, 3);

        Department department1 = new Department(List.of(employee1, employee2, employee3));
        Department department2 = new Department(List.of(employee4, employee5, employee6));
        Department department3 = new Department(List.of(employee7));

        List<Department> departments = List.of(department1, department2, department3);

        Map<Integer, List<EmployeeD>> maxSalaryEachD = departments.stream().flatMap(d -> d.employeeList().stream()).collect(Collectors.groupingBy(EmployeeD::departmentId))
                .entrySet().stream().collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            double mxSalary = entry.getValue().stream().map(EmployeeD::salary).mapToDouble(x -> x).max().getAsDouble();
                            return entry.getValue().stream().filter(e -> e.salary().equals(mxSalary)).toList();
                        }
                ));

        Map<Integer, List<EmployeeD>> maxSalaryEachDD = departments.stream().flatMap(d -> d.employeeList().stream()).collect(Collectors.groupingBy(
                EmployeeD::departmentId,
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        employess -> {
                            double mxSalary = employess.stream().map(EmployeeD::salary).mapToDouble(x -> x).max().getAsDouble();
                            return employess.stream().filter(e -> e.salary().equals(mxSalary)).toList();
                        }
                )));
        System.out.println(maxSalaryEachD);
    }
}

record Department(List<EmployeeD> employeeList) {
}

record EmployeeD(Double salary, Integer departmentId) {
}
