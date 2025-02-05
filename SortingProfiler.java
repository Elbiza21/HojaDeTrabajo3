import java.io.*;
import java.util.*;

public class SortingProfiler {
    public static void main(String[] args) {
        int[] sizes = {10, 100, 500, 1000, 2000, 3000};
        String filename = "numbers.txt";

        generateRandomNumbers(filename, 3000);
        
        for (int size : sizes) {
            int[] numbers = readNumbersFromFile(filename, size);
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

    private static int[] readNumbersFromFile(String filename, int count) {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null && numbers.size() < count) {
                numbers.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbers.stream().mapToInt(i -> i).toArray();
    }

    private static void runSorts(int[] numbers, int size) {
        System.out.println("Sorting " + size + " numbers:");

        int[] copy;
        long startTime, endTime;
        
        copy = Arrays.copyOf(numbers, numbers.length);
        startTime = System.nanoTime();
        insertionSort(copy);
        endTime = System.nanoTime();
        System.out.println("Insertion Sort: " + (endTime - startTime) / 1e6 + " ms");

        copy = Arrays.copyOf(numbers, numbers.length);
        startTime = System.nanoTime();
        mergeSort(copy);
        endTime = System.nanoTime();
        System.out.println("Merge Sort: " + (endTime - startTime) / 1e6 + " ms");

        copy = Arrays.copyOf(numbers, numbers.length);
        startTime = System.nanoTime();
        quickSort(copy, 0, copy.length - 1);
        endTime = System.nanoTime();
        System.out.println("Quick Sort: " + (endTime - startTime) / 1e6 + " ms");
        
        copy = Arrays.copyOf(numbers, numbers.length);
        startTime = System.nanoTime();
        radixSort(copy);
        endTime = System.nanoTime();
        System.out.println("Radix Sort: " + (endTime - startTime) / 1e6 + " ms");
        
        copy = Arrays.copyOf(numbers, numbers.length);
        startTime = System.nanoTime();
        bucketSort(copy);
        endTime = System.nanoTime();
        System.out.println("Bucket Sort: " + (endTime - startTime) / 1e6 + " ms");
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            arr[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
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
    
    private static void radixSort(int[] arr) {
        // Falta Radix Sort
    }
    
    private static void bucketSort(int[] arr) {
        // Falta Bucket Sort
    }

    private static void customSort(int[] arr) {
        // Falta meter un sort random
    }
}
