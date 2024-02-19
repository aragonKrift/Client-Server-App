public class LinearSearch<T extends Comparable<T>> implements IAlgoSearch<T> {
    @Override
    public int search(T[] array, T value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(value) == 0) {
                return i; // Element found at index i
            }
        }
        return -1; // Element not found
    }
}
