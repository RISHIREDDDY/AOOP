package eightB;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Stream pipeline to filter, double, and collect even numbers
        List<Integer> doubledEvenNumbers = numbers.stream()  // Create a stream from the list
                .filter(n -> n % 2 == 0)                   // Filter to retain only even numbers
                .map(n -> n * 2)                           // Double each remaining number
                .collect(Collectors.toList());             // Collect the result into a list

        // Print the resulting list
        System.out.println("Doubled Even Numbers: " + doubledEvenNumbers);
    }
}

