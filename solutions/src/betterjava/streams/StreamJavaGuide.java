/**
 * Solving problems from : https://x.com/GuidesJava/status/1875028417105834389?t=baETXIH_Aviq7MIf4lRfZw&s=08
 */
package betterjava.streams;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamJavaGuide {

    public static void main(String[] args) throws IOException {
        // Remove duplicate elements from List
        List<Pair> num = new ArrayList<>();
        num.add(new Pair(1, "Henry"));
        num.add(new Pair(2, "Henry"));
        num.add(new Pair(1, "Henry"));
        num.add(new Pair(3, "Henry"));

        List<Pair> distinct = num.stream().distinct().toList();
        System.out.println(distinct);

        // Reverse each word in a string
        String name = "What is there in the name";

        List<String> reversed = Arrays.stream(name.split(" ")).map((x) ->
                new StringBuilder(x).reverse().toString()
        ).toList();
        System.out.println(reversed);

        // Second-largest number in a list
        List<Integer> second = List.of(4, 5, 3, 1, 56, 7, 42, 23, 8);

        System.out.println(second.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());


        // Find max and min from a given list
        System.out.println(second.stream().mapToInt(x -> x).max().getAsInt());
        System.out.println(second.stream().max(Integer::compare).get());
        System.out.println(second.stream().min(Integer::compare).get());

        // Sum all digits in a number
        int againNum = 4849582;
        System.out.println(String.valueOf(againNum).chars().map(x -> x - '0').reduce(Integer::sum).getAsInt());


        // Find frequency of each character in given string
        String text = "quick Brown fox jumped over a lazy dog and a very lazy dog again and again";
        Map<Character, Long> freq = text.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(freq);

        // Print even numbers of list
        System.out.println(second.stream().filter(n -> n % 2 == 0).toList());

        // Square of first 3 even numbers
        System.out.println(second.stream().filter(n -> n % 2 == 0).limit(3).map(x -> x * x).toList());

        // Change case of list of strings
        var stList = List.of("Small", "nonsmall", "verysmallL");
        System.out.println(stList.stream().map(s -> s.toUpperCase()).toList());

        System.out.println(second.stream().mapToInt(x->x).average());

    }
}

record Pair(int id, String name) {
}
