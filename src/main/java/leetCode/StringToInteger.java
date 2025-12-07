package leetCode;

import java.math.BigInteger;
import java.util.Set;

/**
 * Description: <a href="https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/884/">Link</a>
 * <pre>
 * The algorithm for myAtoi(string s) is as follows:
 * 1>Whitespace: Ignore any leading whitespace (" ").
 * 2>Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
 * 3>Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
 * 4>Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
 * 5>Return the integer as the final result.
 * </pre>
 */

public class StringToInteger {
    public static void main(String[] args) {
        // System.out.println(myAtoi("+-12"));
        System.out.println(myAtoi("-+12"));
    }

    public static int myAtoi(String s) {
        Set<Character> digits = Set.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        StringBuilder sb = new StringBuilder();
        boolean isDigitFound = false;
        boolean isNegative = false;
        for (char ch : s.toCharArray()) {
            if (' ' == ch) {
                if (isDigitFound) {
                    break;
                }
                continue;
            }
            if ('-' == ch || '+' == ch) {
                if (!isDigitFound) {
                    if ('-' == ch) {
                        isNegative = true;
                    }
                    isDigitFound = true;
                    continue;
                } else {
                    break;
                }
            }
            if (digits.contains(ch)) {
                sb.append(ch);
                isDigitFound = true;
            } else {
                break;
            }
        }
        if (sb.length() == 0) {
            return 0;
        }
        String strToInt = (isNegative ? "-" : "") + sb;
        BigInteger parsedVal = new BigInteger(strToInt);
        BigInteger lowerBound = new BigInteger(String.valueOf(Integer.MIN_VALUE));
        BigInteger upperBound = new BigInteger(String.valueOf(Integer.MAX_VALUE));
        if (lowerBound.compareTo(parsedVal) > 0) {
            return Integer.MIN_VALUE;
        }
        if (upperBound.compareTo(parsedVal) < 0) {
            return Integer.MAX_VALUE;
        }
        return Integer.parseInt(strToInt);
    }
}
