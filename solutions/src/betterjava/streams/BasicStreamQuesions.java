/**
 * https://medium.com/@mehar.chand.cloud/java-stream-coding-interview-questions-part-1-dc39e3575727
 */
package betterjava.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class BasicStreamQuesions {
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
        // Find Longest String from a list of strings
        List<String> strings = Arrays
                .asList("apple", "banana", "cherry", "date", "grapefruit");
        System.out.println(StreamSolutions.getLongestString(strings));

        // Calculate average age of list of Person objects
        List<Person> persons = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35)
        );
        System.out.println(StreamSolutions.getAverageAge(persons));

        // Check if a List of Integers contain a prime number
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10, 11, 12, 13, 14, 15);
        System.out.println(StreamSolutions.checkIfContainPrime(numbers));

        // Merge Two sorted lists into single sorted list
        List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);
        System.out.println(StreamSolutions.mergeSortedLists(list1, list2));

        // Find Intersection of Two lists
        List<Integer> list11 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list22 = Arrays.asList(3, 4, 5, 6, 7);
        System.out.println(StreamSolutions.getIntersectionOfLists(list11, list22));

        // Remove duplicates from a list while preserving the order
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 6, 5);
        System.out.println(StreamSolutions.removeDuplicates(numbersWithDuplicates));

        // Given a list of transactions, find the sum of transaction amounts for each day
        List<Transaction> transactions = Arrays.asList(
                new Transaction("2022-01-01", 100),
                new Transaction("2022-01-01", 200),
                new Transaction("2022-01-02", 300),
                new Transaction("2022-01-02", 400),
                new Transaction("2022-01-03", 500)
        );
        System.out.println(StreamSolutions.findEachDayTransactionSum(transactions));

        // kth smallest element in an array
        int[] array = {4, 2, 7, 1, 5, 3, 6};
        int k = 3; // Find the 3rd smallest element
        System.out.println(StreamSolutions.findKthSmallestElement(array, k));

        // Find frequency of each string in list
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry",
                "banana", "apple");
        System.out.println(StreamSolutions.getFrequencyMapOfList(words));

        // Partition a list into two groups based on predicate
        List<Integer> numbersAgain = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Predicate<Integer> predicate = n -> n % 2 == 0;
        Map<Boolean, List<Integer>> partitioned = StreamSolutions.getPartitionsOfNumbers(numbersAgain, predicate);
        System.out.println(partitioned.get(true));
        System.out.println(partitioned.get(false));
    }

}

record Person(String name, Integer age) {
}

record Transaction(String date, int amount) {
}

class StreamSolutions {
    public static String getLongestString(List<String> strings) {
        return strings.stream().max(Comparator.comparingInt(String::length)).orElse("");
    }

    public static Double getAverageAge(List<Person> persons) {
        return persons.stream().mapToInt(Person::age).average().orElse(0);
    }

    public static boolean checkIfContainPrime(List<Integer> numbers) {
        return numbers.stream().anyMatch(BasicStreamQuesions::isPrime);
    }

    public static List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        return Stream.concat(list1.stream(), list2.stream()).sorted().toList();
    }

    public static List<Integer> getIntersectionOfLists(List<Integer> list11, List<Integer> list22) {
        return list11.stream().filter(list22::contains).toList();
    }

    public static List<Integer> removeDuplicates(List<Integer> numbersWithDuplicates) {
        return numbersWithDuplicates.stream().distinct().toList();
    }

    public static Map<String, Integer> findEachDayTransactionSum(List<Transaction> transactions) {
        return transactions.stream().collect(Collectors.groupingBy(Transaction::date, Collectors.summingInt(Transaction::amount)));
    }

    public static int findKthSmallestElement(int[] nums, int k) {
        return Arrays.stream(nums).sorted().skip(k - 1).findFirst().orElse(-1);
    }

    public static Map<String, Long> getFrequencyMapOfList(List<String> words) {
        return words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static Map<Boolean, List<Integer>> getPartitionsOfNumbers(List<Integer> numbersAgain, Predicate<Integer> predicate) {
        return numbersAgain.stream().collect(Collectors.partitioningBy(predicate));
    }
}
