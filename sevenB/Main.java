package sevenB;

public class Main {
    public static void main(String[] args) {
        // Test with Integer data type
        PriorityQueue<Integer> intQueue = new PriorityQueue<>();
        intQueue.add(5);
        intQueue.add(3);
        intQueue.add(8);
        intQueue.add(1);

        System.out.println("Integer Priority Queue:");
        while (!intQueue.isEmpty()) {
            System.out.println(intQueue.remove()); // Output: 1, 3, 5, 8
        }

        // Test with Double data type
        PriorityQueue<Double> doubleQueue = new PriorityQueue<>();
        doubleQueue.add(5.5);
        doubleQueue.add(2.2);
        doubleQueue.add(8.8);
        doubleQueue.add(1.1);

        System.out.println("\nDouble Priority Queue:");
        while (!doubleQueue.isEmpty()) {
            System.out.println(doubleQueue.remove()); // Output: 1.1, 2.2, 5.5, 8.8
        }

        // Test with String data type
        PriorityQueue<String> stringQueue = new PriorityQueue<>();
        stringQueue.add("apple");
        stringQueue.add("orange");
        stringQueue.add("banana");
        stringQueue.add("kiwi");

        System.out.println("\nString Priority Queue:");
        while (!stringQueue.isEmpty()) {
            System.out.println(stringQueue.remove()); // Output: apple, banana, kiwi, orange
        }
    }
}
