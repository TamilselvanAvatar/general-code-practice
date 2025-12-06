package leetCode;

import helperUtil.Printer;

import java.util.List;
import java.util.ArrayList;

/**
 * Description: <a href= "https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/727/">Link</a>
 * <p>Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.</p>
 */

public class RemoveDuplicatesInArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 3, 4, 4, 4};
        int k = removeDuplicates(nums);
        System.out.println("Final Length Using Traditional Way: " + k);
        // int k = removeDuplicatesWithTwoPointer(nums);
        // System.out.println("Final Length Using Pointer Way: " + k);
        Printer.printAsArray(nums, k);
        Printer.printAsArray(nums);
    }


    public static int removeDuplicatesWithTwoPointer(int[] nums) {
        int i = 0;
        int j = 0;
        int len = nums.length;
        int finalLen = 1;
        while (i <= j && j < len) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
                finalLen++;
            }
            j++;
        }
        return finalLen;
    }

    public static int removeDuplicates(int[] nums) {
        int ans = 1;
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int curVal : nums) {
            if (curVal != list.get(list.size() - 1)) {
                ans++;
                list.add(curVal);
            }
        }
        for (int j = 0; j < list.size(); j++) {
            nums[j] = list.get(j); // THERE IS NO NEED TO SET ZERO FOR ALL OTHER ELEMENT
        }
        return ans;
    }
}