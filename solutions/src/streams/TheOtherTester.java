package streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TheOtherTester {

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "grapeFruit");
        Optional<String> longestString = strings.stream().max(Comparator.comparing(String::length));
        System.out.println("Longest string is: " + longestString.get());

        List<Person> persons = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35)
        );
        OptionalDouble averageAge = persons.stream().mapToInt(Person::age).average();
        System.out.println("Average age of persons: " + averageAge.getAsDouble());

        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10, 11, 12, 13, 14, 15);
        Boolean containsPrime = numbers.stream().anyMatch(TheOtherTester::isPrime);
        System.out.println("Does the list contain any prime number: " + containsPrime);

        List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> sortedMergedList = Stream.concat(list1.stream(), list2.stream()).sorted().toList();
        System.out.println("Merged sorted list: " + sortedMergedList);

        List<Integer> list12 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list22 = Arrays.asList(3, 4, 5, 6, 7);
        List<Integer> listIntersection = list12.stream().filter(list22::contains).toList();
        System.out.println("Intersection of given 2 list is: " + listIntersection);

        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 6, 5);
        List<Integer> uniqueNumbers = numbersWithDuplicates.stream().distinct().toList();
        System.out.println("List with unique numbers: " + uniqueNumbers);

        List<Transaction> transactions = Arrays.asList(
                new Transaction("2022-01-01", 100),
                new Transaction("2022-01-01", 200),
                new Transaction("2022-01-02", 300),
                new Transaction("2022-01-02", 400),
                new Transaction("2022-01-03", 500)
        );
        Map<String, Integer> perDayTransactionSum = transactions.stream().collect(Collectors.groupingBy(Transaction::date, Collectors.summingInt(Transaction::amount)));
        System.out.println("Total transaction for each day: " + perDayTransactionSum);

        int[] array = {4, 2, 7, 1, 5, 3, 6};
        int k = 3; // Find the 3rd smallest element
        int kthSmallest = Arrays.stream(array).sorted().skip(k - 1).findFirst().orElse(-1);
        System.out.println("Kth Smallest element from array: " + kthSmallest);

        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry",
                "banana", "apple");
        Map<String, Long> wordsFreq = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Frequency of input words: " + wordsFreq);

        List<Integer> numbersList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Boolean, List<Integer>> partitionedList = numbersList.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Partitioned list based on even/odd: " + partitionedList);
    }
}
