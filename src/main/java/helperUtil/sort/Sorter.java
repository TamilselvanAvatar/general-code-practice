package helperUtil.sort;

import java.util.function.BiFunction;

public interface Sorter {
    <T> void sort(T[] arr, BiFunction<T, T, Boolean> condition);
}