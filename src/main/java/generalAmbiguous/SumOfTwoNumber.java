package generalAmbiguous;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Given Array <i>numbs</i> and target number <i>tn</i></p>
 * <p>Task:</p>
 * <p>Return: Index of Two Element [ when ( a + b = tn ) ]</p>
 * <i>Traditional Time Complexity: O(n^2)</i>
 * <i>Time Complexity: O(n)</i>
 */

public class SumOfTwoNumber {
    public static void main(String[] args) {
        int tn = 10;
        int[] numbs = {4, 7, 1, 6, 12, 14};
        sumOfTwoNumberAndPrintIndex(numbs, tn);
    }

    private static void sumOfTwoNumberAndPrintIndex(int[] numbs, int tn) {
        // Consider [a + b = tn]
        // `a` is current iterate element and `b` is which available in indexMapper [ will add it in each iteration ]
        // `indexMapper` -> key is Element Value, Value is index of Element Value
        Map<Integer, Integer> indexMapper = new HashMap<>();
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < numbs.length; i++) {
            int a = numbs[i];
            int b = tn - a;
            Integer bIndex = indexMapper.get(b);
            if (bIndex != null) {
                result.put(a, i);
                result.put(b, bIndex);
                break;
            } else {
                indexMapper.put(a, i);
            }
        }
        System.out.println(result);
    }
}
