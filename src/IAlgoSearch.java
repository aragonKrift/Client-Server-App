public interface IAlgoSearch<T extends Comparable<T>> {
    // Method to search for a value in an array
    int search(T[] array, T value);
}
