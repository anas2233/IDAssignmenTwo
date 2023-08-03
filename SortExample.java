import java.util.Arrays;

/**
 * This class demonstrates various sorting algorithms in Java.
 */
public class SortExample {

    public static void main(String[] args) {
        // This is an unsorted array
        Integer[] array1 = new Integer[]{12, 13, 24, 10, 3, 6, 90, 70};
        int array2[] = {2, 6, 3, 5, 1};

        // Let's sort using quick sort
        quickSort(array1, 0, array1.length - 1);
        // Verify sorted array
        System.out.println(Arrays.toString(array1));

        mergeSort(array2, array2.length - 1);
        // Verify sorted array
        System.out.println(Arrays.toString(array2));
    }

    /**
     * Sorts an array using the quick sort algorithm.
     *
     * @param arr  the array to be sorted.
     * @param low  the starting index of the array.
     * @param high the ending index of the array.
     */
    public static void quickSort(Integer[] arr, int low, int high) {
        // Check for an empty or null array
        if (arr == null || arr.length == 0) {
            return;
        }

        if (low >= high) {
            return;
        }

        // Get the pivot element from the middle of the list
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // Make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            // Check until all values on the left side of the array are lower than the pivot
            while (arr[i] < pivot) {
                i++;
            }
            // Check until all values on the right side of the array are greater than the pivot
            while (arr[j] > pivot) {
                j--;
            }
            // Now compare values from both sides of the lists to see if they need swapping
            // After swapping, move the iterator on both lists
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        // Do the same operation as above recursively to sort two sub-arrays
        if (low < j) {
            quickSort(arr, low, j);
        }
        if (high > i) {
            quickSort(arr, i, high);
        }
    }

    /**
     * Swaps two elements in an array.
     *
     * @param array the array where the elements need to be swapped.
     * @param x     the index of the first element to swap.
     * @param y     the index of the second element to swap.
     */
    public static void swap(Integer array[], int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    /**
     * Sorts an array using the merge sort algorithm.
     *
     * @param a the array to be sorted.
     * @param n the number of elements in the array.
     */
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }

        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }

        mergeSort(l, mid);
        mergeSort(r, n - mid);
        merge(a, l, r, mid, n - mid);
    }

    /**
     * Merges two sub-arrays into a single array.
     *
     * @param a     the array to store the merged elements.
     * @param l     the left sub-array.
     * @param r     the right sub-array.
     * @param left  the number of elements in the left sub-array.
     * @param right the number of elements in the right sub-array.
     */
    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }

        while (i < left) {
            a[k++] = l[i++];
        }

        while (j < right) {
            a[k++] = r[j++];
        }
    }

    /**
     * Checks if an array is sorted in ascending order.
     *
     * @param x the array to be checked.
     * @return true if the array is sorted, false otherwise.
     */
    private static boolean isSorted(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            if (x[i] > x[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
