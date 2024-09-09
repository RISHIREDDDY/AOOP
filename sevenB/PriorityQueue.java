package sevenB;
import java.util.*;
import java.util.Comparator;
class PriorityQueue<T extends Comparable<T>> {
    private ArrayList<T> heap; // List to store the elements of the heap
    private Comparator<? super T> comparator; // Comparator for custom ordering

    // Constructor for a default (natural order) priority queue
    public PriorityQueue() {
        this.heap = new ArrayList<>();
        this.comparator = null; // Use natural ordering
    }

    // Constructor for a custom comparator-based priority queue
    public PriorityQueue(Comparator<? super T> comparator) {
        this.heap = new ArrayList<>();
        this.comparator = comparator;
    }

    // Method to add an item to the priority queue
    public void add(T item) {
        heap.add(item);
        siftUp(heap.size() - 1);
    }

    // Method to remove the highest-priority item (min or max) from the priority queue
    public T remove() {
        if (isEmpty()) {
            return null;
        }
        T root = heap.get(0);
        T lastItem = heap.remove(heap.size() - 1);
        if (!isEmpty()) {
            heap.set(0, lastItem);
            siftDown(0);
        }
        return root;
    }

    // Method to peek at the highest-priority item without removing it
    public T peek() {
        return isEmpty() ? null : heap.get(0);
    }

    // Method to check if the priority queue is empty
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // Helper method to maintain heap order by sifting up
    private void siftUp(int index) {
        T currentItem = heap.get(index);
        int parentIndex = (index - 1) / 2;

        while (index > 0 && compare(currentItem, heap.get(parentIndex)) < 0) {
            heap.set(index, heap.get(parentIndex));
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
        heap.set(index, currentItem);
    }

    // Helper method to maintain heap order by sifting down
    private void siftDown(int index) {
        T currentItem = heap.get(index);
        int leftChildIndex = 2 * index + 1;

        while (leftChildIndex < heap.size()) {
            int smallestChildIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex + 1;

            if (rightChildIndex < heap.size() && compare(heap.get(rightChildIndex), heap.get(leftChildIndex)) < 0) {
                smallestChildIndex = rightChildIndex;
            }

            if (compare(currentItem, heap.get(smallestChildIndex)) <= 0) {
                break;
            }

            heap.set(index, heap.get(smallestChildIndex));
            index = smallestChildIndex;
            leftChildIndex = 2 * index + 1;
        }
        heap.set(index, currentItem);
    }

    // Helper method to compare two elements using the comparator or natural ordering
    private int compare(T o1, T o2) {
        if (comparator != null) {
            return comparator.compare(o1, o2);
        }
        return o1.compareTo(o2);
    }
}

