package leetCode;

import java.math.BigInteger;

import static helperUtil.Printer.printAsArray;
import static helperUtil.StringUtils.fromCharToString;

/**
 * Description: <a href="https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/559/">Link</a>
 * <p>Plus One</p>
 * <pre>
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * </prev>
 */

public class PlusOne {
    public static void main(String[] args) {
        // int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] nums = {7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 6};
        printAsArray("PLUS ONE ", plusOne(nums));
    }


    public static int[] plusOne(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for (int digit : digits) {
            sb.append(digit);
        }
        BigInteger plusOne = BigInteger.ONE.add(new BigInteger(sb.toString()));
        String plusOneToString = plusOne.toString();
        int plusOneLen = plusOneToString.length();
        int[] ans = new int[plusOneLen];
        for (int i = 0; i < plusOneLen; i++) {
            ans[i] = Integer.parseInt(fromCharToString(plusOneToString.charAt(i)));
        }

        return ans;
    }

    public static int[] plusOneNotWorkingForSomeBigInteger(int[] digits) {
        int len = digits.length - 1;
        long sumsOfDigits = 0;
        for (int digit : digits) {
            sumsOfDigits += (long) (digit * Math.pow(10, len));
            len--;
        }
        sumsOfDigits += 1;
        StringBuilder sb = new StringBuilder();
        sb.append(sumsOfDigits);
        int i = 0;
        int mLen = sb.length();
        int plusOneLen;
        int[] ans;
        if (sb.charAt(0) == '-') {
            i = 2;
            plusOneLen = mLen - 1;
            ans = new int[plusOneLen];
            ans[0] = Integer.parseInt("-" + sb.charAt(1));
        } else {
            plusOneLen = mLen;
            ans = new int[plusOneLen];
        }
        for (; i < plusOneLen; i++) {
            ans[i] = Integer.parseInt(sb.charAt(i) + "");
        }
        return ans;
    }

}
