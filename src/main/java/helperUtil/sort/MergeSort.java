package helperUtil.sort;

import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * Merge Sort
 * Algorithm: Divide and Conquer the goal
 */

public class MergeSort<T> implements Sorter<T> {
    @Override
    public void sort(T[] arr, BiFunction<T, T, Boolean> condition) {
        int size = arr.length;
        if (size == 1) {
            return;
        }

        // Divide Original Array to halves
        int mid = size / 2;
        T[] left = Arrays.copyOfRange(arr, 0, mid);
        T[] right = Arrays.copyOfRange(arr, mid, size);

        // Recursively call and sort
        sort(left, condition);
        sort(right, condition);

        // Merge Sorted left and right array
        mergeSort(arr, left, right, condition);
    }

    private void mergeSort(T[] arr, T[] left, T[] right, BiFunction<T, T, Boolean> condition) {
        int i = 0, j = 0, k = 0;
        int leftSize = left.length;
        int rightSize = right.length;

        while (i < leftSize && j < rightSize) {
            T a = left[i];
            T b = right[j];
            if (condition.apply(a, b)) {
                arr[k] = a;
                i++;
            } else {
                arr[k] = b;
                j++;
            }
            k++;
        }

        // Add left over LEFT array element
        while (i < leftSize) {
            arr[k] = left[i];
            i++;
            k++;
        }

        // Add left over RIGHT array element
        while (j < rightSize) {
            arr[k] = right[j];
            j++;
            k++;
        }

        // Printer<T> printer = new Printer<>();
        // printer.printAsArray("Left Array: ;Right Array: ;\nMergerArray: ", left, right, arr);

    }

}