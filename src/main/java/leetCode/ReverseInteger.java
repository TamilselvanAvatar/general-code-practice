package leetCode;

import java.math.BigInteger;

/**
 * Description: <a href="https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/880/">Link</a>
 * <p>Task: Return reversed digit of given integer if exceeds int range then return zero</p>
 */

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse((int) Math.pow(2, 33)));
    }

    public static int reverse(int x) {
        StringBuilder str = new StringBuilder();
        str.append(x);
        boolean isNegative = false;
        if (x < 0) {
            str.replace(0, 1, "");
            isNegative = true;
        }
        str.reverse();
        BigInteger parsedVal = new BigInteger(str.toString());
        BigInteger lowerBound = new BigInteger(String.valueOf(Integer.MIN_VALUE));
        BigInteger upperBound = new BigInteger(String.valueOf(Integer.MAX_VALUE));
        if (lowerBound.compareTo(parsedVal) < 0 && upperBound.compareTo(parsedVal) > 0) {
            return (isNegative ? -1 : 1) * Integer.parseInt(str.toString());
        }
        return 0;
    }
}
