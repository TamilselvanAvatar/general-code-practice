package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class threeSumCode {

    private static List<List<Integer>> ans;

    public static void main(String[] args) {
        int[] a = { -1, 0, 1, 0};
        System.out.println(threeSum(a));
    }

    public static List<List<Integer>> twoSum(int i, int k, List<List<Integer>> ans, int[] nums) {
        for (int j = k; j < nums.length - 1; j++) {
            if ((i + nums[j] + nums[j + 1]) == 0) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                list.add(nums[j]);
                list.add(nums[j + 1]);

                if (k == 1) {
                    ans.add(list);
                } else {
                    for (List<?> l : ans) {
                        if (l.get(0) != list.get(0) && l.get(1) != list.get(1) && l.get(2) != list.get(2)) {
                            ans.add(list);
                        }
                    }
                }

                // System.out.println(ans +"==");

            }

        }

        return ans;

    }

    public static List<List<Integer>> threeSum(int[] nums) {

        ans = new ArrayList<List<Integer>>();
        int k = 1;

        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = i + 1; j < nums.length - 1; j++) {

                if (nums[i] + nums[j + 1] + nums[j] == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[j + 1]);
                    ans.add(list);

                }
            }
        }

        for (int i = 0; i < ans.size(); i++) {
            for (int j = i + 1; j < ans.size() - 1; j++) {
                System.out.println("=");
                System.out.println((ans.get(i).contains(ans.get(j).get(0)) && ans.get(i).contains(ans.get(j).get(1))
                        && ans.get(i).contains(ans.get(j).get(2))));

                if ((ans.get(i).contains(ans.get(j).get(0)) && ans.get(i).contains(ans.get(j).get(1))
                        && ans.get(i).contains(ans.get(j).get(2)))) {
                    ans.remove(ans.get(j));
                }
            }
        }
        return ans.stream().distinct().collect(Collectors.toList());
    }

}

