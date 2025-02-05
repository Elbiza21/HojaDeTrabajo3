/**
 * Implementación del algoritmo Heap Sort.
 *
 * @param <T> Tipo de datos a ordenar, debe implementar Comparable<T>.
 */
public class HeapSort<T extends Comparable<T>> implements ISorter<T> {

    @Override
    public long sort(T[] array) {
        long startTime = System.nanoTime();

        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            T temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }

        return System.nanoTime() - startTime;
    }

    private void heapify(T[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left].compareTo(array[largest]) > 0) {
            largest = left;
        }

        if (right < n && array[right].compareTo(array[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            T swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, n, largest);
        }
    }
}
