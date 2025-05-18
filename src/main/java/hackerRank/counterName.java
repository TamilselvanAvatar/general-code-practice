package hackerRank;

import java.util.Scanner;

/**
 * <p>Test Case :</p>
 * <p>5</p>
 * <p>1560834904 1768820483 1533726144 1620434450 1463674015</p>
 *
 * */

public class counterName {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            System.out.println(counterGame(n));

        }

    }

    static String counterGame(long n) {
        String ans = "";
        while (true) {
            n = numberGame(n);
            if (n == 1) {
                ans = "Louise";
                break;
            }
            //System.out.println(n);
            n = numberGame(n);
            if (n == 1) {
                ans = "Richard";
                break;
            }
        }
        return ans;

    }

    public static long numberGame(long n) {
        long a = n;
        if ((n & (n - 1)) == 0l) {
            n = n / 2;
        } else {

            for (int i = 0; i <= 64; i++) {
                if ((1l << i) > n) {
                    n = 1l << (i - 1);
                    break;
                }
            }
            n = a - n;
        }
        return n;
    }

}
