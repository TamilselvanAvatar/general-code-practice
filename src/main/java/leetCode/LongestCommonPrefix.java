package leetCode;

import static helperUtil.StringUtils.isEmpty;

/**
 * Description: <a href="https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/887/">Link</a>
 * <p>Find Common Prefix for the given strings</p>
 */

public class LongestCommonPrefix {
    public static void main(String[] args) {
        // String[] arr = {"flower", "flow", "flight"};
        // String[] arr = {""};
        String[] arr = {"a"};
        System.out.println(longestCommonPrefix(arr));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        int k = strs.length;
        int i = 0;
        while (true) {
            int len = 0;
            char ch = ' ';
            for (String str : strs) {
                if (isEmpty(str) || str.length() <= i) {
                    break;
                }
                char prefix = str.charAt(i);
                if (ch == ' ' || ch == prefix) {
                    ch = prefix;
                    len++;
                } else {
                    break;
                }
            }
            if (len == k) {
                ans.append(ch);
                i++;
            } else {
                break;
            }
        }
        return ans.toString();
    }
}
