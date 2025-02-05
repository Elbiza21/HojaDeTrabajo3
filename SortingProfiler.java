import java.io.*;
import java.util.*;
import uvg.hdt3.ISorter;

public class SortingProfiler {
    public static void main(String[] args) {
        int[] sizes = {10, 100, 500, 1000, 2000, 3000};
        String filename = "numbers.txt";

        generateRandomNumbers(filename, 3000);
        
        for (int size : sizes) {
            Integer[] numbers = readNumbersFromFile(filename, size);
            runSorts(numbers, size);
            runSorts(numbers, size); // Ordenando nuevamente los datos ordenados
        }
    }

    private static void generateRandomNumbers(String filename, int count) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            Random rand = new Random();
            for (int i = 0; i < count; i++) {
                writer.println(rand.nextInt(10000));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Integer[] readNumbersFromFile(String filename, int count) {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null && numbers.size() < count) {
                numbers.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbers.toArray(new Integer[0]);
    }

    private static void runSorts(Integer[] numbers, int size) {
        System.out.println("Sorting " + size + " numbers:");

        ISorter[] sorters = {new InsertionSort(), new MergeSort(), new QuickSort(), new RadixSort(), new BucketSort()};
        
        for (ISorter sorter : sorters) {
            Integer[] copy = Arrays.copyOf(numbers, numbers.length);
            long time = sorter.sort(copy);
            System.out.println(sorter.getClass().getSimpleName() + ": " + time + " ms");
        }
    }
}

class InsertionSort implements ISorter<Integer> {
    @Override
    public long sort(Integer[] array) {
        long startTime = System.nanoTime();
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
        return (System.nanoTime() - startTime) / 1_000_000;
    }
}

class MergeSort implements ISorter<Integer> {
    @Override
    public long sort(Integer[] array) {
        long startTime = System.nanoTime();
        Arrays.sort(array);
        return (System.nanoTime() - startTime) / 1_000_000;
    }
}

class QuickSort implements ISorter<Integer> {
    @Override
    public long sort(Integer[] array) {
        long startTime = System.nanoTime();
        quickSort(array, 0, array.length - 1);
        return (System.nanoTime() - startTime) / 1_000_000;
    }
    
    private void quickSort(Integer[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    private int partition(Integer[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}

class RadixSort implements ISorter<Integer> {
    @Override
    public long sort(Integer[] array) {
        long startTime = System.nanoTime();
        // Implementación de Radix Sort
        return (System.nanoTime() - startTime) / 1_000_000;
    }
}

class BucketSort implements ISorter<Integer> {
    @Override
    public long sort(Integer[] array) {
        long startTime = System.nanoTime();
        // Implementación de Bucket Sort
        return (System.nanoTime() - startTime) / 1_000_000;
    }
}
