package generalAmbiguous;

import helperUtil.Printer;
import helperUtil.sort.BubbleSort;

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
        Printer<Integer> printer = new Printer<>();
        Integer[] numbs = {-7, -6, -4, 3, 5, 9};
        int[] res1 = sortAndSquareWithTwoPointer(numbs);
        Integer[] res2 = sortAndSquareWithTraditionalLogic(numbs);
        printAsArray("Sorted Square With Two Pointer ", res1);
        printer.printAsArray("Sorted Square With Traditional Sort ", res2);
    }

    private static Integer[] sortAndSquareWithTraditionalLogic(Integer[] numbs) {
        int len = numbs.length;
        Integer[] ans = new Integer[len];
        int count = 0; // Take Advantage of ASC order
        for (int i = 0; i < len; i++) {
            int value = numbs[i];
            if (value < 0) {
                count++;
            }
            int squaredNum = value * value;
            ans[i] = squaredNum;
        }
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        bubbleSort.sort(ans, count, (a, b) -> (a >= b));
        return ans;
    }

    public static int[] sortAndSquareWithTwoPointer(Integer[] numbs) {
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