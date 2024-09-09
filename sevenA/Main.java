package sevenA;
import java.util.*;
public class Main {
    ArrayStack<Integer> intStack = new ArrayStack<>(5);
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        System.out.println("Peek: " + intStack.peek()); // Output: 30
        System.out.println("Pop: " + intStack.pop()); // Output: 30
        System.out.println("Pop: " + intStack.pop()); // Output: 20
        System.out.println("Is Empty: " + intStack.isEmpty()); // Output: false

     
        System.out.println("Peek: " + intStack.peek()); // Output: 10

    
        System.out.println("Pop: " + intStack.pop()); // Output: 10
        System.out.println("Is Empty: " + intStack.isEmpty()); // Output: true
        System.out.println("Pop: " + intStack.pop()); // Output: Stack Underflow: Cannot pop
    }

