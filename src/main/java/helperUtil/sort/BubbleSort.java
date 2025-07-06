package helperUtil.sort;

import java.util.function.BiFunction;

public class BubbleSort<T> implements Sorter<T> {
    public void sort(T[] arr, Integer loopCount, BiFunction<T, T, Boolean> condition) {
        int len = arr.length;
        if (loopCount == null) {
            loopCount = len;
        }
        int count = 0;
        while (count <= loopCount) {
            this.sort(arr, condition);
            count++;
        }
    }

    @Override
    public void sort(T[] arr, BiFunction<T, T, Boolean> condition) {
        for (int i = 0; i < arr.length - 1; i++) {
            T a = arr[i];
            T b = arr[i + 1];
            if (condition.apply(a, b)) {
                arr[i] = b;
                arr[i + 1] = a;
            }
        }
    }
}
