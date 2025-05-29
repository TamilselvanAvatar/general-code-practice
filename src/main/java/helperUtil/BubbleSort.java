package helperUtil;

import java.util.function.BiFunction;

public class BubbleSort {

    public static void sort(int[] arr, Integer loopCount, BiFunction<Integer, Integer, Boolean> condition) {
        int len = arr.length;
        if (loopCount == null) {
            loopCount = len;
        }
        int count = 0;
        while (count <= loopCount) {
            for (int i = 0; i < len - 1; i++) {
                int a = arr[i];
                int b = arr[i + 1];
                if (condition.apply(a, b)) {
                    arr[i] = b;
                    arr[i + 1] = a;
                }
            }
            count++;
        }
    }

}
