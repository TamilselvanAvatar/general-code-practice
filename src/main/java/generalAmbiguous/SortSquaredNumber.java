package generalAmbiguous;

import static helperUtil.BubbleSort.sort;
import static helperUtil.Printer.printAsArray;

/**
 * <p>Given the ascending order integer array <b>numbs</b></p>
 * <p>Task:</p>
 * <i>Return :New Array which contain Squared of Each Element in <b>numbs</b> and in asc order</i>
 * <p>Example:</p>
 * <p>Input : [-5, -3, 0, 6, 8]</p>
 * <p>Output : [0, 9, 25, 36, 64]</p>
 *
 * <p><i>Algorithm:</i></p>
 * <p>1. Loop through each element and square it and store in new Array</p>
 * <p>2. Sort that new Array in asc order</p>
 */

public class SortSquaredNumber {
    public static void main(String[] args) {
        int[] numbs = {-7, -6, -4, 3, 5, 9};
        int[] res1 = sortAndSquareWithTwoPointer(numbs);
        int[] res2 = sortAndSquareWithTraditionalLogic(numbs);
        printAsArray("Sorted Square With Two Pointer ", res1);
        printAsArray("Sorted Square With Traditional Sort ", res2);
    }

    private static int[] sortAndSquareWithTraditionalLogic(int[] numbs) {
        int len = numbs.length;
        int[] ans = new int[len];
        int count = 0; // Take Advantage of ASC order
        for (int i = 0; i < len; i++) {
            int value = numbs[i];
            if (value < 0) {
                count++;
            }
            int squaredNum = value * value;
            ans[i] = squaredNum;
        }
        sort(ans, count, (a, b) -> a >= b);
        return ans;
    }

    public static int[] sortAndSquareWithTwoPointer(int[] numbs) {
        int len = numbs.length;
        int l = 0;
        int r = len - 1;
        int[] ans = new int[len];
        for (int i = r; i >= 0; i--) {
            int lValue = Math.abs(numbs[l]);
            int rValue = Math.abs(numbs[r]);
            if (lValue >= rValue) {
                ans[i] = lValue * lValue;
                l++;
            } else {
                ans[i] = rValue * rValue;
                r--;
            }
        }
        return ans;
    }

}
