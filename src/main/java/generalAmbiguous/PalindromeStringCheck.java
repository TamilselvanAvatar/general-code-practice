package generalAmbiguous;

import java.util.Set;

import static helperUtil.StringUtils.*;

/**
 * Description:
 * <p>Need to check the given string is palindrome and excluded the special characters</p>
 */

public class PalindromeStringCheck {

    public static void main(String[] args) {
        palindromeCheck("A man, a plan, a canal: Panama");
    }

    public static void palindromeCheck(String string) {
        int i = 0;
        int j = string.length() - 1;
        boolean isPalindrome = true;
        Set<String> specialChar = Set.of("~!@#$%^&*()_-+={}[]|:;,? ".split(""));
        while (i <= j) {
            String leftSideChar = fromCharToString(string.charAt(i));
            String rightSideChar = fromCharToString(string.charAt(j));
            if (specialChar.contains(leftSideChar)) {
                i++;
                continue;
            }
            if (specialChar.contains(rightSideChar)) {
                j--;
                continue;
            }
            if (equalIgnoreCase(leftSideChar, rightSideChar)) {
                i++;
                j--;
            } else {
                isPalindrome = false;
                break;
            }
        }
        System.out.println("It is a " + (isPalindrome ? "" : "not") + " Palindrome");
    }

}
