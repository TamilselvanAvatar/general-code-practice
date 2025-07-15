package helperUtil.sort;

import helperUtil.Printer;

import java.util.Random;
import java.util.function.BiFunction;

import static helperUtil.SwapUtils.swap;

public class QuickSort implements Sorter {

    @Override
    public <T> void sort(T[] arr, BiFunction<T, T, Boolean> condition) {
        sort(arr, 0, arr.length - 1, condition);
    }

    private <T> void sort(T[] arr, int lowIndex, int highIndex, BiFunction<T, T, Boolean> condition) {
        if (lowIndex >= highIndex) {
            return;
        }

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
         T pivot = arr[pivotIndex];
        // SWAP the randomly picked PIVOT to last/high index
         swap(arr, pivotIndex, highIndex);

        // PARTITION THE ARRAY BY PIVOT
        int leftPointer = partition(arr, pivot, lowIndex, highIndex, condition);

        sort(arr, lowIndex, leftPointer - 1, condition);
        sort(arr, leftPointer + 1, highIndex, condition);

//        Printer<T> printer = new Printer<>();
//        printer.printAsArray("STEPS ", arr);
    }

    private <T> int partition(T[] arr, T pivot, int lowIndex, int highIndex, BiFunction<T, T, Boolean> condition) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        while (leftPointer < rightPointer) {
            while (leftPointer < rightPointer && condition.apply(arr[leftPointer], pivot)) {
                leftPointer++;
            }
            while (leftPointer < rightPointer && condition.apply(pivot, arr[rightPointer])) {
                rightPointer--;
            }
            swap(arr, leftPointer, rightPointer);
        }
        swap(arr, leftPointer, highIndex);
        return leftPointer;
    }

}