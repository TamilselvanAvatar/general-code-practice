package code360;

import java.util.Set;
import java.util.TreeSet;

import static helperUtil.Printer.printer;

/**
 * Find all the divisors of the number ‘N’. Print them in increasing order.
 * <p> For example, for n = 36: </p>
 * <p> 1 and 36 </p>
 * <p> 2 and 18 </p>
 * <p> 3 and 12 </p>
 * <p> 4 and 9 </p>
 * <p> 6 and 6 ← special case (perfect square) </p>
 * <p>Duplication can eliminate using SET</p>
 * Time Complexity: O(sqrt(n))
 */

public class GetAllDivisors {
    public static void main(String[] args) {
        int n = 100;
        Set<Integer> ans = new TreeSet<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                ans.add(i);
                ans.add(n / i);
            }
        }
        printer(ans, ",", "All Divisor of " + n + " : ", true);
    }

}
