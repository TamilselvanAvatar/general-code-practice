package helperUtil;

import java.util.function.Supplier;

public class GeneralUtils {

    public static int sumOfXNaturalNumber(int n) {
        return (n * (n + 1)) / 2;
    }

    public static <T> T computeIfNull(T obj, Supplier<T> supplier) {
        return obj == null ? supplier.get() : obj;
    }

    public static int[] min(Integer i, Integer j) {
        int min;
        int index;
        if (i != null && j != null) {
            if (i < j) {
                min = i;
                index = -1;
            } else {
                min = j;
                index = 0;
            }
        } else {
            if (i != null) {
                min = i;
                index = -1;
            } else {
                min = j;
                index = 0;
            }
        }
        return new int[]{min, index};
    }

}
