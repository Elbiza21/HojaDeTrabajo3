import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class SortingProfilerTest {

    @Test
    public void testInsertionSort() {
        int[] array = {5, 3, 8, 1, 2};
        int[] expected = {1, 2, 3, 5, 8};
        SortingProfiler.insertionSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testMergeSort() {
        int[] array = {9, 7, 5, 3, 1};
        int[] expected = {1, 3, 5, 7, 9};
        SortingProfiler.mergeSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testQuickSort() {
        int[] array = {10, 4, 6, 3, 2, 8};
        int[] expected = {2, 3, 4, 6, 8, 10};
        SortingProfiler.quickSort(array, 0, array.length - 1);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testRadixSort() {
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        int[] expected = {2, 24, 45, 66, 75, 90, 170, 802};
        SortingProfiler.radixSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testBucketSort() {
        int[] array = {29, 25, 3, 49, 9, 37, 21, 43};
        int[] expected = {3, 9, 21, 25, 29, 37, 43, 49};
        SortingProfiler.bucketSort(array);
        assertArrayEquals(expected, array);
    }
}
