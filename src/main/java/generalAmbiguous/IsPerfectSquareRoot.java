package generalAmbiguous;

/**
 * Is Perfect SquareRoot:
 * <p>Approach:</p>
 * <p> n = 16 </p>
 * <p> Range : l = 1 and r = n</p>
 * <p> Find Mid between this range => m - that is 8 (Binary Search) </p>
 * <p> Square this number 8 => 64, above the actual n so -> r = m - 1</p>
 * <p> repeat above steps</p>
 * Time Complexity : O(log n)
 */

public class IsPerfectSquareRoot {
    public static void main(String[] args) {
        int n = 16; //12
        System.out.println("Is the Number Perfect Square " + n + " : " + isPerfectSquare(n));
    }

    public static boolean isPerfectSquare(int n) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int m = (l + r) / 2;
            int mSqr = m * m;

            if (mSqr == n) {
                return true;
            } else if (mSqr < n) {
                r = m - 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }
}
