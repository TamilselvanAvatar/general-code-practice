package leetCode;

import helperUtil.Printer;
import helperUtil.sort.MergeSort;
import helperUtil.sort.Sorter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import static helperUtil.GeneralUtils.min;

/**
 * Description: Merge Two Sorted Array
 * <pre>
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * </pre>
 */

public class MergeSortedArray {
    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int[] nums2 = {2, 5, 6};
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        Integer[] numsi1 = {1, 2, 3, 0, 0, 0}; // {2, 0};
        Integer[] numsj2 = {2, 5, 6};// {1};
        int m = 3;
        int n = 3;
//        merge(nums1, m, nums2, n);
        mergeOtherWay(nums1, m, nums2, n);
        mergeSimpleWay(numsi1, m, numsj2, n);
        Printer.printAsArray("Sorted Array: ", nums1);
        Printer<Integer> p = new Printer<>();
        p.printAsArray("Sorted Array Using Merge Sort: ", numsi1);
    }

    public static void mergeSimpleWay(Integer[] nums1, int m, Integer[] nums2, int n) {
        for (int i = m, j = 0; i < nums1.length; i++, j++) {
            nums1[i] = nums2[j];
        }
        MergeSort ms = new MergeSort();
        ms.sort(nums1, (a, b) -> a <= b);
    }

    public static void mergeOtherWay(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] result = new int[m + n];
        while (true) {
            Integer v1 = null;
            Integer v2 = null;
            if (i < m) {
                v1 = nums1[i];
            }
            if (j < n) {
                v2 = nums2[j];
            }
            if (i >= m && j >= n) {
                break;
            }
            int[] minArr = min(v1, v2);
            int min = minArr[0];
            if (k == 0) {
                result[k] = min;
                k++;
                if (minArr[1] == -1) {
                    i++;
                } else {
                    j++;
                }
                continue;
            }
            if (v1 != null && result[k - 1] > v1) {
                result[k] = v1;
                i++;
                k++;
                continue;
            }
            if (v2 != null && result[k - 1] > v2) {
                result[k] = v2;
                j++;
                k++;
                continue;
            }
            if (v1 != null && v2 == null) {
                result[k] = v1;
                i++;
                k++;
                continue;
            }
            if (v2 != null && v1 == null) {
                result[k] = v2;
                j++;
                k++;
                continue;
            }
            result[k] = min;
            if (minArr[1] == -1) {
                i++;
            } else {
                j++;
            }
            k++;
        }

        System.arraycopy(result, 0, nums1, 0, result.length);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = (m + n) - 1;
        if (j <= 0 && i == 1) {
            return;
        }
        try {
            while (j >= 0) {
                int lastNums1 = nums1[i];
                int lastNums2 = nums2[j];
                System.out.println("LI " + lastNums1 + " LJ " + lastNums2);
                if (lastNums1 <= lastNums2) {
                    nums1[k] = lastNums2;
                    j--;
                } else {
                    nums1[k] = lastNums1;
                    i--;
                }
                k--;
            }
        } catch (Exception ignored) {
        }

    }

}
