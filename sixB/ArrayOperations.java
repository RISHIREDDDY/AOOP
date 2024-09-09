package sixB;
public class ArrayOperations<T extends Comparable<T>> {
    private T[] array; 
    public T[] getArray() {
        return array;
    }
    public void setArray(T[] array) {
        this.array = array;
    }


    public T findMax() {
        if (array == null || array.length == 0) {
            return null; 
        }

        T max = array[0]; 
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i]; 
            }
        }
        return max;
    }

    
    public T findMin() {
        if (array == null || array.length == 0) {
            return null;
        }

        T min = array[0]; 
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(min) < 0) {
                min = array[i];
            }
        }
        return min;
    }
}

