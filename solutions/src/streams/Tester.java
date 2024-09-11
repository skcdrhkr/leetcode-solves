package streams;

import java.util.*;
import java.util.stream.Collectors;

public class Tester {
    public static void main(String[] args) {
        List<Student> list = getStudentData();
        List<Student> lstStuName = list.stream().filter(s -> s.getFirstName().startsWith("A")).toList();
        System.out.printf("List of studentds whose first name starts with 'A': %s%n", lstStuName);

        Map<String, List<Student>> studentMap = list.stream().collect(Collectors.groupingBy(Student::getDepartmentName));
        System.out.printf("Students grouped by departmentName: %s%n", studentMap);

        long count = list.stream().count();
        System.out.println("Total count of students: " + count);

        OptionalInt maxAge = list.stream().mapToInt(x -> x.getAge()).max();
        System.out.println("Max age of students: " + maxAge.getAsInt());

        List<String> departmentNames = list.stream().map(x -> x.getDepartmentName()).distinct().toList();
        System.out.println("All department Names are: " + departmentNames);

        Map<String, Long> countByDepartment = list.stream().collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.counting()));
        System.out.println("Students count group by departmentName: " + countByDepartment);

        List<Student> studentWithLessThan30 = list.stream().filter(x -> x.getAge() < 30).toList();
        System.out.println("Student with age less than 30: " + studentWithLessThan30);

        List<Student> studentWithRank50to100 = list.stream().filter(x -> x.getRank() >= 50 && x.getRank() <= 100).toList();
        System.out.println("Student with rank between 50 and 100: " + studentWithRank50to100);

        Map<String, Double> averageAgeGenders = list.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        System.out.println("Average age of mail and femail students: " + averageAgeGenders);

        Map.Entry<String, Long> departmentName = list.stream().collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println("Department with maximum number of students: " + departmentName);

        List<Student> studentsListFromDelhi = list.stream().filter(x -> x.getCity().equals("Delhi")).sorted(Comparator.comparing(Student::getFirstName)).toList();
        System.out.println("Sorted Students by Name who lives in delhi: " + studentsListFromDelhi);

        Map<String, Double> departmentWithAverageRank = list.stream().collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.averagingInt(Student::getRank)));
        System.out.println("Average rank in all departments: " + departmentWithAverageRank);

        Map<String, Optional<Student>> departmentWithHighestRank = list.stream().collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.minBy(Comparator.comparing(Student::getRank))));
        System.out.println("Highest rank in all departments: " + departmentWithHighestRank);

        List<Student> studentsListSortedByRank = list.stream().sorted(Comparator.comparingInt(Student::getRank)).toList();
        System.out.println("Students sorted by their rank: " + studentsListSortedByRank);

        Student secondRankStudent = list.stream().sorted(Comparator.comparing(Student::getRank)).skip(1).findFirst().get();
        System.out.println("Student with second rank is: " + secondRankStudent);
    }

    private static List<Student> getStudentData() {
        return Arrays.asList(
                new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
                new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
                new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
                new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
                new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
                new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));
    }
}
