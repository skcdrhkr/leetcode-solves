/**
 * https://medium.com/@harendrakumarrajpoot5/java8-stream-api-commonly-asked-interview-questions-answer-9ab7a6800ff3
 */

package betterjava.streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamingEmployees {
    public static void main(String[] args) {
        List<Employee> empList = getEmployeeData();

        // 1. Group the Employees by City
        System.out.println(StreamingEmployeesSolution.groupEmployeesByCity(empList));

        // 2. Group the Employees by Age
        System.out.println(StreamingEmployeesSolution.groupEmployeesByAge(empList));

        // 3. Count of Male and Female Employees in Organization
        System.out.println(StreamingEmployeesSolution.getEmployeesCountByGender(empList));

        // 4. Get Name of All departments
        System.out.println(StreamingEmployeesSolution.getAllDepartmentNames(empList));

        // 5. Print Employee details whose Age is greater than given
        System.out.println(StreamingEmployeesSolution.filterEmployeesByAge(empList, 28));

        // 6. Print maximum age of Employee
        System.out.println(StreamingEmployeesSolution.getEmployeeMaxAge(empList));

        // 7. Print Average age of Male and Female Employees
        System.out.println(StreamingEmployeesSolution.getAverageAgeByGender(empList));

        // 8. Number of Employees in each Department
        System.out.println(StreamingEmployeesSolution.countEmployeesByDepartment(empList));

        // 9. Oldest Employee
        System.out.println(StreamingEmployeesSolution.getOldestEmployee(empList));

        // 10. Youngest Employee
        System.out.println(StreamingEmployeesSolution.getYougestEmployee(empList));

        // 11. Employees with Age greater and less than given age
        System.out.println(StreamingEmployeesSolution.splitEmployeesWithGivenAge(empList));

        // 12. Department name with the highest number of employees;
        System.out.println(StreamingEmployeesSolution.getDepartmentWightMostEmployees(empList));

        // 13. Find if there are any employees with given Department
        System.out.println(StreamingEmployeesSolution.containsEmployeesFromDepartment(empList, "HR"));

        // 14. The department names that these employees work for, where the number of employees in the department is over 3.
        System.out.println(StreamingEmployeesSolution.getDepartmentNameWithMoreThanGivenEmployees(empList, 3));

        // 15. Distinct department names that employees work for
        System.out.println(StreamingEmployeesSolution.getDistinctDepartments(empList));

        // 16. All employees who live in ‘Blore’ city, sort them by their name and print the names of employees.
        System.out.println(StreamingEmployeesSolution.getEmployeesFromCity(empList, "Blore"));

        // 17. Number of employees in the organization
        System.out.println(StreamingEmployeesSolution.getTotalEmployeesCount(empList));

        // 18. Sorting Employees by Age and name fields
        System.out.println(StreamingEmployeesSolution.sortEmployeesByAgeAndName(empList));

        // 19. Get Highest experienced employee in organization
        System.out.println(StreamingEmployeesSolution.getHighestExEmployee(empList));

        // 20. Average and Total salary of the organization
        DoubleSummaryStatistics statistics = StreamingEmployeesSolution.getAverageAndTotalSalaryOfOrg(empList);
        System.out.println("Average salary for Org: " + statistics.getAverage());
        System.out.println("Total salary of Org: " + statistics.getSum());

        // 21. Average Salary of each department
        System.out.println(StreamingEmployeesSolution.getAverageSalaryByDepartment(empList));

        // 22. Highest salary in organization
        System.out.println(StreamingEmployeesSolution.getHighestSalaryInOrg(empList));

        // 23. Second-highest salary in organization
        System.out.println(StreamingEmployeesSolution.getNthHighestSalaryInOrg(empList, 2));

        // 24. Highest paid salary in organization based on Gender
        System.out.println(StreamingEmployeesSolution.getHighestSalaryForEachGender(empList));

    }

    private static List<Employee> getEmployeeData() {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "abc", 28, 123, "F", "HR", "Blore", 2020));
        empList.add(new Employee(2, "xyz", 29, 120, "F", "HR", "Hyderabad", 2015));
        empList.add(new Employee(3, "efg", 30, 115, "M", "HR", "Chennai", 2014));
        empList.add(new Employee(4, "def", 32, 125, "F", "HR", "Chennai", 2013));
        empList.add(new Employee(5, "ijk", 22, 150, "F", "IT", "Noida", 2013));
        empList.add(new Employee(6, "mno", 27, 140, "M", "IT", "Gurugram", 2017));
        empList.add(new Employee(7, "uvw", 26, 130, "F", "IT", "Pune", 2016));
        empList.add(new Employee(8, "pqr", 23, 145, "M", "IT", "Trivandam", 2015));
        empList.add(new Employee(9, "stv", 25, 160, "M", "IT", "Blore", 2010));
        return empList;
    }
}

class StreamingEmployeesSolution {

    public static Map<String, List<Employee>> groupEmployeesByCity(List<Employee> empList) {
        return empList.stream().collect(Collectors.groupingBy(Employee::getCity));
    }

    public static Map<Integer, List<Employee>> groupEmployeesByAge(List<Employee> empList) {
        return empList.stream().collect(Collectors.groupingBy(Employee::getAge));
    }

    public static Map<String, Long> getEmployeesCountByGender(List<Employee> empList) {
        return empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
    }

    public static List<String> getAllDepartmentNames(List<Employee> empList) {
        return empList.stream().map(Employee::getDeptName).distinct().toList();
    }

    public static List<Employee> filterEmployeesByAge(List<Employee> empList, int age) {
        return empList.stream().filter(employee -> employee.getAge() > age).toList();
    }

    public static Integer getEmployeeMaxAge(List<Employee> empList) {
        return empList.stream().mapToInt(Employee::getAge).max().orElse(-1);
    }

    public static Map<String, Double> getAverageAgeByGender(List<Employee> empList) {
        return empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
    }

    public static Map<String, Long> countEmployeesByDepartment(List<Employee> empList) {
        return empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
    }

    public static Employee getOldestEmployee(List<Employee> empList) {
        return empList.stream().max(Comparator.comparingInt(Employee::getAge)).orElse(null);
    }

    public static Employee getYougestEmployee(List<Employee> empList) {
        return empList.stream().min(Comparator.comparingInt(Employee::getAge)).orElse(null);
    }

    public static Map<Boolean, List<Employee>> splitEmployeesWithGivenAge(List<Employee> empList) {
        return empList.stream().collect(Collectors.partitioningBy(employee -> employee.getAge() > 30));
    }

    public static String getDepartmentWightMostEmployees(List<Employee> empList) {
        return empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("");
    }

    public static Employee containsEmployeesFromDepartment(List<Employee> empList, String department) {
        //return empList.stream().map(Employee::getDeptName).anyMatch(x -> x.equalsIgnoreCase(department));
        return empList.stream().filter(employee -> employee.getDeptName().equalsIgnoreCase(department)).findAny().orElse(null);
    }

    public static List<String> getDepartmentNameWithMoreThanGivenEmployees(List<Employee> empList, int count) {
        return empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 3).map(Map.Entry::getKey).toList();
    }

    public static List<String> getDistinctDepartments(List<Employee> empList) {
        return empList.stream().map(Employee::getDeptName).distinct().toList();
    }

    public static List<String> getEmployeesFromCity(List<Employee> empList, String city) {
        return empList.stream().filter(employee -> employee.getCity().equalsIgnoreCase(city)).map(Employee::getName)
                .sorted().toList();
        //empList.stream().filter(e -> e.getCity().equalsIgnoreCase("Blore")).sorted(Comparator.comparing(Employee::getName))
    }

    public static Integer getTotalEmployeesCount(List<Employee> empList) {
        return empList.size();
    }

    public static List<Employee> sortEmployeesByAgeAndName(List<Employee> empList) {
        Comparator<Employee> comparator1 = Comparator.comparingInt(Employee::getAge);
        Comparator<Employee> comparator2 = Comparator.comparing(Employee::getName);
        return empList.stream().sorted(comparator1.thenComparing(comparator2)).toList();
    }

    public static List<Employee> getHighestExEmployee(List<Employee> empList) {
        return empList.stream().collect(Collectors.groupingBy(Employee::getYearOfJoining))
                .entrySet().stream().min(Map.Entry.comparingByKey())
                .get().getValue();
    }

    public static DoubleSummaryStatistics getAverageAndTotalSalaryOfOrg(List<Employee> empList) {
        //return empList.stream().mapToDouble(Employee::getSalary).summaryStatistics();
        return empList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
    }

    public static Map<String, Double> getAverageSalaryByDepartment(List<Employee> empList) {
        return empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.averagingDouble(Employee::getSalary)));
    }

    public static Long getHighestSalaryInOrg(List<Employee> empList) {
        return empList.stream().max(Comparator.comparingLong(Employee::getSalary)).map(Employee::getSalary).orElse(0L);
    }

    public static Long getNthHighestSalaryInOrg(List<Employee> empList, int n) {
        return empList.stream().sorted(Comparator.comparingLong(Employee::getSalary).reversed())
                .skip(n - 1).findFirst().map(Employee::getSalary).orElse(0L);
    }

    public static Map<String, Optional<Employee>> getHighestSalaryForEachGender(List<Employee> empList) {
        return empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.maxBy(Comparator.comparingLong(Employee::getSalary))));
    }
}

class Employee {
    private int id;
    private String name;
    private int age;
    private long salary;
    private String gender;
    private String deptName;
    private String city;
    private int yearOfJoining;

    public Employee(int id, String name, int age, long salary, String gender,
                    String deptName, String city, int yearOfJoining) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.deptName = deptName;
        this.city = city;
        this.yearOfJoining = yearOfJoining;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", deptName='" + deptName + '\'' +
                ", city='" + city + '\'' +
                ", yearOfJoining='" + yearOfJoining + '\'' +
                '}';
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }
}