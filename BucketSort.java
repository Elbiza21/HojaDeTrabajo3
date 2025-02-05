import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementación del algoritmo Bucket Sort.
 *
 * @param <T> Tipo de datos a ordenar, debe implementar Comparable<T>.
 */
public class BucketSort implements ISorter<Double> {

    @Override
    public long sort(Double[] array) {
        long startTime = System.nanoTime();

        int n = array.length;
        List<Double>[] buckets = new List[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (double num : array) {
            int index = (int) (n * num);
            buckets[index].add(num);
        }

        for (List<Double> bucket : buckets) {
            Collections.sort(bucket);
        }

        int index = 0;
        for (List<Double> bucket : buckets) {
            for (double num : bucket) {
                array[index++] = num;
            }
        }

        return System.nanoTime() - startTime;
    }
}
