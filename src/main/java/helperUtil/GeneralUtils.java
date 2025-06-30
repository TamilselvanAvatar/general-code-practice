package helperUtil;

import java.util.function.Supplier;

public class GeneralUtils {

    public static int sumOfXNaturalNumber(int n) {
        return (n * (n + 1)) / 2;
    }

    public static <T> T computeIfNull(T obj, Supplier<T> supplier) {
        return obj == null ? supplier.get() : obj;
    }

}
