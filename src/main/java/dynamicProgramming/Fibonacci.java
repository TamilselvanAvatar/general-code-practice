package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * <b><i>DYNAMIC PROGRAMING</i></b> <br>
 * <p>Simply mean => Dynamic Programing (DP) = Recursion + Memoization</p> <br>
 * <p>Memoization = Just Remember (Memory) [Remember Already Computed Process (Steps) - Will Avoid Re-Compute that Process Again] </p>
 * <p>Here Fibonacci With DP</p>
 * <p>Fibonacci Patten</p>
 * F0 = 0<br>
 * F1 = F2 = 1<br>
 * Fn = Fn-1 + Fn-2 ; n > 2
 */

public class Fibonacci {
    public static void main(String[] args) {
        int n = 6;
        long ta = traditionalApproach(n);
        // Dynamic Programming Approach
        long tb = topBottomApproach(n);
        long bu = bottomUpApproach(n);
        System.out.printf("Traditional Approach F(%d) : %d\n", n, ta);
        System.out.printf("Traditional Approach F(%d) : %d\n", n, tb);
        System.out.printf("Traditional Approach F(%d) : %d\n", n, bu);
    }

    private static long bottomUpApproach(int n) {
        // Time Complexity: O(n)
        // In this Approach - We can achieve Space Complexity O(1) instead of O(n);
        Map<Integer, Long> memo = new HashMap<>();
        memo.put(0, 0L);
        memo.put(1, 1L);
        memo.put(2, 1L);
        for (int i = 3; i <= n; i++) {
            long result = memo.get(i - 1) + memo.get(i - 2);
            memo.put(i, result);
        }
        return memo.get(n);
    }

    private static final Map<Integer, Long> memo = new HashMap<>();

    private static long topBottomApproach(int n) {
        // Time Complexity: O(n)
        if (n <= 2) {
            return 1L;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        long result = traditionalApproach(n - 1) + traditionalApproach(n - 2);
        memo.put(n, result);
        return result;
    }

    private static long traditionalApproach(int n) {
        // TimeComplexity: Tn = 2Tn-2 (Still Need Clarity)
        if (n <= 2) {
            return 1L;
        }
        return traditionalApproach(n - 1) + traditionalApproach(n - 2);
    }
}
