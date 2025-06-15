package helperUtil;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class CollectionUtils {
    public static <K, V, R extends Collection<V>> Map<K, R> groupBy(V[] arr, Function<V, K> extractor, Supplier<R> supplier) {
        return groupBy(List.of(arr), extractor, supplier);
    }

    public static <K, V, R extends Collection<V>> Map<K, R> groupBy(Collection<V> collection, Function<V, K> extractor, Supplier<R> supplier) {
        Map<K, R> result = new HashMap<>();
        if (collection == null) {
            return result;
        }
        for (V v : collection) {
            K key = extractor.apply(v);
            if (key != null) {
                result.computeIfAbsent(key, k -> supplier.get()).add(v);
            }
        }
        return result;
    }
}