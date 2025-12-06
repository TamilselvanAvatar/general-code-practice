package leetCode;

import helperUtil.Printer;

import java.util.*;

/**
 * Description: <a href="https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/674/">Link</a>
 * <p>Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.</p>
 */

public class IntersectionOfTwoArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        Printer.printAsArray("ARRAY 1", nums1);
        Printer.printAsArray("ARRAY 2", nums2);
        Printer.printAsArray("INTERSECT ELEMENTS", intersect(nums1, nums2));

    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> intersect = new ArrayList<>();
        Set<Integer> indexAlreadyFound = new HashSet<>();
        for (int num : nums1) {
            for (int j = 0; j < nums2.length; j++) {
                if (!indexAlreadyFound.contains(j) && num == nums2[j]) {
                    intersect.add(num);
                    indexAlreadyFound.add(j);
                    break;
                }
            }
        }
        return intersect.stream().mapToInt(Integer::intValue).toArray();
    }

}
