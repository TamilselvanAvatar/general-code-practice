package leetCode;

import helperUtil.Printer;
import helperUtil.SwapUtils;

import static helperUtil.Printer.printAsArray;

/**
 * Description: <a href="https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/567/">Link</a>
 * <p>Moves the Zeros in the array to the end</p>
 */

public class MovesZeros {
    public static void main(String[] args) {
        Printer<Integer> printer = new Printer<>();
        int[] nums = {0, 1, 0, 3, 12};
        Integer[] numsArr = {5, 1, 0, 3, 12}; // {0, 1, 0, 3, 12};
        moveZeroes(nums);
        moveZeroesTwoPointer(numsArr);
        printer.printAsArray("Two Pointer Way:", numsArr);
        printAsArray("Traditional Way: ", nums);
    }

    public static void moveZeroesTwoPointer(Integer[] nums) {
        int j = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                SwapUtils.swap(nums, i, j);
                j++;
            }
        }
    }

    public static void moveZeroesTwoPointerNotBetter(int[] nums) {
        int i = 0;
        int j = 0;
        int len = nums.length;
        boolean isSwapDone = true;
        while (j < len && i < len) {
            if (nums[i] != 0 && isSwapDone) {
                j++;
                i++;
            } else {
                isSwapDone = false;
                if (nums[j] != 0) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                    j = i;
                    isSwapDone = true;
                }
                if (!isSwapDone) {
                    j++;
                }
            }
        }
    }

    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        int i = 0;
        while (i < len) {
            int zero = nums[i];
            if (zero == 0) {
                int j = i + 1;
                while (j < len) {
                    int nonZero = nums[j];
                    if (nonZero != 0) {
                        nums[i] = nonZero;
                        nums[j] = 0;
                        break;
                    }
                    j++;
                }
            }
            i++;
        }
    }
}
