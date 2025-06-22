package dynamicProgramming;

import helperUtil.Timer;

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
        Timer timer = new Timer();
        int n = 50;

        timer.startTimer();
        long ta = traditionalApproach(n);
        System.out.printf("Traditional Approach F(%d) : %d\tTime Taken To Complete: %d\n", n, ta, timer.stopTimer());

        // Dynamic Programming Approach
        timer.startTimer();
        long tb = topBottomApproach(n);
        System.out.printf("Dynamic Programming Top-Bottom Approach F(%d) : %d\tTime Taken To Complete: %d\n", n, tb, timer.stopTimer());

        timer.startTimer();
        long bu = bottomUpApproach(n);
        System.out.printf("Dynamic Programming Bottom-Top Approach F(%d) : %d\tTime Taken To Complete: %d\n", n, bu, timer.stopTimer());
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
        long result = topBottomApproach(n - 1) + topBottomApproach(n - 2);
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
