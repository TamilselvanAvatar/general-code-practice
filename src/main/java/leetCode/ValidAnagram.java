package leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Description: <a href="https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/882/">Link</a>
 * <p>Given 2 String</p>
 * <p>Check one string is anagram of other string</p>
 */

public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("car", "rat"));
    }

    public static boolean isAnagram(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen != tLen) {
            return false;
        }
        Map<Character, Integer> sCharByCount = new HashMap<>();
        Map<Character, Integer> tCharByCount = new HashMap<>();
        for (int i = 0; i < sLen; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            sCharByCount.compute(sChar, (k, v) -> (v != null ? v : 0) + 1);
            tCharByCount.compute(tChar, (k, v) -> (v != null ? v : 0) + 1);
        }
        for (Map.Entry<Character, Integer> ch : sCharByCount.entrySet()) {
            // ch.getValue() != tCharByCount.get(ch.getKey()) THIS WONT WORK FOR INTEGER VALUE GREATER THAN 1000
            // BELOW SHOW THE PROOF
            // Integer i = 1000;
            // Integer j = 1000;
            // System.out.println(i == j);
            // System.out.println(i.equals(j));
            if (!Objects.equals(ch.getValue(), tCharByCount.get(ch.getKey()))) {
                return false;
            }
        }

        return true;
    }
}
