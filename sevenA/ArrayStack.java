package sevenA;
import java.util.*;
class ArrayStack<T> implements Stack<T> {
    private T[] elements;   
    private int size;       
    private int capacity;  
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.elements = (T[]) new Object[capacity]; 
        this.size = 0; 
    }
    public void push(T item) {
        if (size == capacity) {
            System.out.println("Stack Overflow: Cannot push " + item);
            return;
        }
        elements[size++] = item;
    }
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow: Cannot pop");
            return null;
        }
        T item = elements[--size]; 
        elements[size] = null;    
        return item;
    }


    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty: Cannot peek");
            return null;
        }
        return elements[size - 1]; 
    }
    public boolean isEmpty() {
        return size == 0;
    }
}
