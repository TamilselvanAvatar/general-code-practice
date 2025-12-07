package leetCode;

import java.util.Set;

import static helperUtil.StringUtils.equalIgnoreCase;
import static helperUtil.StringUtils.fromCharToString;

/**
 * Description: <a href="https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/883/">Link</a>
 * <p>Check the given string is palindrome or not</p>
 */

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String str) {
        String specialCharacters = "~`!@#$%^&*()-_=+{}[]|\\;:'\"<>,.?/ ";
        Set<String> setOfSpecialCharacters = Set.of(specialCharacters.split(""));
        int i = 0;
        int j = str.length() - 1;
        while (i <= j) {
            String leftChar = fromCharToString(str.charAt(i));
            String rightChar = fromCharToString(str.charAt(j));
            if (setOfSpecialCharacters.contains(leftChar)) {
                i++;
                continue;
            }
            if (setOfSpecialCharacters.contains(rightChar)) {
                j--;
                continue;
            }
            if (!equalIgnoreCase(leftChar, rightChar)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
