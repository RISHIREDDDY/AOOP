package sixB;
public class Main {
    public static void main(String[] args) {

        Integer[] intArray = {3, 5, 1, 9, 2};
        String[] strArray = {"apple", "orange", "banana", "kiwi"};
        Character[] charArray = {'a', 'x', 'b', 'k', 'm'};
        Float[] floatArray = {2.4f, 3.6f, 1.1f, 5.9f};
        ArrayOperations<Integer> intOps = new ArrayOperations<>();
        ArrayOperations<String> strOps = new ArrayOperations<>();
        ArrayOperations<Character> charOps = new ArrayOperations<>();
        ArrayOperations<Float> floatOps = new ArrayOperations<>();
        intOps.setArray(intArray);
        strOps.setArray(strArray);
        charOps.setArray(charArray);
        floatOps.setArray(floatArray);
        System.out.println("Integer Array:");
        System.out.println("Max: " + intOps.findMax());
        System.out.println("Min: " + intOps.findMin());
        System.out.println("\nString Array:");
        System.out.println("Max: " + strOps.findMax());
        System.out.println("Min: " + strOps.findMin());
        System.out.println("\nCharacter Array:");
        System.out.println("Max: " + charOps.findMax());
        System.out.println("Min: " + charOps.findMin());
        System.out.println("\nFloat Array:");
        System.out.println("Max: " + floatOps.findMax());
        System.out.println("Min: " + floatOps.findMin());
    }
}
