package leetCode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description: <a href="https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/881/">Link</a>
 * <p>Find Index Of First Unique Char</p>
 */

public class firstUniqueCharIndex {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetCode"));
    }

    public static int firstUniqChar(String s) {
        int strLen = s.length();
        Map<Character, Integer> occurrenceByIndex = new LinkedHashMap<>(); // Will Maintain Insertion Order
        for (int i = 0; i < strLen; i++) {
            char c = s.charAt(i);
            occurrenceByIndex.computeIfPresent(c, (k, v) -> -1);
            occurrenceByIndex.putIfAbsent(c, i);
        }

        for (Map.Entry<Character, Integer> keyAndValue : occurrenceByIndex.entrySet()) {
            if (keyAndValue.getValue() != -1) {
                return keyAndValue.getValue();
            }
        }

        return -1;
    }
}
