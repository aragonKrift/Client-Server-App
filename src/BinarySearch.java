public class BinarySearch<T extends Comparable<T>> implements IAlgoSearch<T> {

    @Override
    public int search(T[] array, T value) {
        return binarySearch(array, value, 0, array.length - 1);
    }

    private int binarySearch(T[] array, T value, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int compareResult = array[mid].compareTo(value);
            if (compareResult == 0) {
                return mid;
            } else if (compareResult < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
