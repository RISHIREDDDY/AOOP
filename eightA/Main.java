package eightA;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a list of strings
        List<String> stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("orange");
        stringList.add("banana");
        stringList.add("kiwi");

        // Sort the list in descending order using a lambda expression
        stringList.sort((s1, s2) -> s2.compareTo(s1));

        // Alternatively, you can use method reference with Comparator's reverseOrder
        // stringList.sort(Comparator.reverseOrder());

        // Print the sorted list
        System.out.println("Strings sorted in descending order: " + stringList);
    }
}
