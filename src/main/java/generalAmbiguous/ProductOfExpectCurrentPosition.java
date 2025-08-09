package generalAmbiguous;

import helperUtil.Printer;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

import static helperUtil.Printer.printer;

/**
 * Calculates the product of all elements in an array except the element at the current index.
 *
 * <p><b>Example:</b></p>
 * <pre>
 * Input:  [7, 6, 8, 3, 9]
 * Output: [(6*8*3*9), (7*8*3*9), (7*6*3*9), (7*6*8*9), (7*6*8*3)]
 * </pre>
 *
 * <p><b>Algorithm:</b></p>
 * <ol>
 *   <li>For the <i>i</i>th index, determine which index positions should be multiplied.</li>
 *   <li>Example index mapping for array size 5:</li>
 * </ol>
 *
 * <pre>
 * {
 *   0: <span style="color:red;">1 2 3 4</span>
 *   1: 0 <span style="color:red;">2 3 4</span>
 *   2: 0 1 <span style="color:red;">3 4</span>
 *   3: 0 1 2 <span style="color:red;">4</span>
 *   4: 0 1 2 3
 * }
 * </pre>
 * <p><b>Time Complexity: O(n)</b></p>
 * <p><b>Space Complexity: O(n)</b></p>
 */

public class ProductOfExpectCurrentPosition {
    public static Printer<Integer> printer = new Printer<>();

    public static void main(String[] args) {
        Integer[] arr = {7, 6, 8, 3, 9};
        productOfExpectCurrentPositionBetterWay(arr); // Time Complexity: O(n)
        productOfExpectCurrentPositionSimplifiedTraditionalWay(arr); // Time Complexity: O(2n)
        productOfExpectCurrentPositionComplexTraditionalWay(arr); // Time Complexity: O(n2)
    }

    private static void productOfExpectCurrentPositionComplexTraditionalWay(Integer[] arr) {
        int size = arr.length;
        Integer[] result = new Integer[size];
        for (int i = 0; i < size; i++) {
            int products = 1;
            for (int j = 0; j < size; j++) {
                if (j == i) {
                    continue;
                }
                products *= arr[j];
            }
            result[i] = products;
        }
        printer.printAsArray("\nProduct of All Element Skip Current (Traditional Way O(n2)", result);
    }

    private static void productOfExpectCurrentPositionSimplifiedTraditionalWay(Integer[] arr) {
        int size = arr.length;
        int productOfAllElement = 1;
        Integer[] result = new Integer[size];
        for (int i : arr) {
            productOfAllElement *= i;
        }
        for (int i = 0; i < size; i++) {
            result[i] = productOfAllElement / arr[i];
        }
        printer.printAsArray("\nProduct of All Element Skip Current (Traditional Way O(2n)", result);
    }

    private static void productOfExpectCurrentPositionBetterWay(Integer[] arr) {
        int size = arr.length;
        int i = 1;
        int j = size - 2;
        AtomicInteger productOfTopToBottom = new AtomicInteger(1);
        AtomicInteger productOfBottomToTop = new AtomicInteger(1);
        Map<Integer, Integer> result = new TreeMap<>();
        while (i <= size && j >= 0) {
            productOfBottomToTop.set(productOfBottomToTop.get() * arr[i - 1]);
            productOfTopToBottom.set(productOfTopToBottom.get() * arr[j + 1]);
            result.compute(i, (k, v) -> (v != null ? v : 1) * productOfBottomToTop.get());
            result.compute(j, (k, v) -> (v != null ? v : 1) * productOfTopToBottom.get());
            i++;
            j--;
        }
        printer(result.values(), ", ", "\nProduct of All Element Skip Current (O(n) Way)", true);
    }
}
