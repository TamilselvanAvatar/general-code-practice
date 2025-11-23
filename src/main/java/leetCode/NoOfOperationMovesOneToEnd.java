package leetCode;

import java.awt.desktop.SystemEventListener;

/**
 * Description: <a href="https://leetcode.com/problems/maximum-number-of-operations-to-move-ones-to-the-end/">Problem Link</a>
 */

public class NoOfOperationMovesOneToEnd {
    public static boolean noOperationNeeded;

    public static void main(String[] args) {
        // YET TO FIND THE RIGHT SOLUTION
        System.out.println(maxOperationsTraditionalWay("1001101"));
        System.out.println(maxOperationsTraditionalWay("110"));
        System.out.println(maxOperationsOptimisedWay("1001101"));
        System.out.println(maxOperationsOptimisedWay("110"));
    }

    public static int maxOperationsTraditionalWay(String s) {
        StringBuilder sb = new StringBuilder(s);
        int count = 0;
        System.out.println(sb);
        for (int i = 0; i < sb.length(); i++) {
            if (moveOnesToRight(sb)) {
                count++;
            }
             System.out.println(sb);
        }
        return count;
    }

    public static int maxOperationsOptimisedWay(String s) {
        StringBuilder sb = new StringBuilder(s);
        int count = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (findAndMoveOnes(sb) == 1) {
                count++;
            }
            if (noOperationNeeded) {
                break;
            }
        }
        return count;
    }

    public static int findAndMoveOnes(StringBuilder sb) {
        int i = -1;
        int k = -1;
        boolean foundFirst = false;
        System.out.println(sb);
        for (int j = 0; j < sb.length(); j++) {
            char c = sb.charAt(j);
            if (c == '1' && !foundFirst) {
                i = j;
                foundFirst = true;
                continue;
            }
            if (c == '1') {
                k = j;
                if (k != (i + 1)) {
                    break;
                } else {
                    i = j;
                }
            }
            if (c == '0' && (sb.length() - 1 == j)) {
                k = j + 1;
            }
        }
        if (i == (sb.length() - 1)) {
            noOperationNeeded = true;
            return 0;
        }
        if (i == -1 || k == -1) {
            return 0;
        }
        sb.replace(i, i + 1, "0");
        sb.replace(k - 1, k, "1");
        return 1;
    }

    public static boolean moveOnesToRight(StringBuilder sb) {
        boolean alreadyFindOne = false;
        int i = 0;
        int j;
        do {
            if (!alreadyFindOne) {
                i = findOnesIndex(sb, 0);
            } else {
                i++;
            }
            if (i == -1) {
                return false;
            } else {
                alreadyFindOne = true;
            }
            j = findOnesIndex(sb, i + 1);
        } while ((i + 1) == j);

        if (j == -1) {
            return false;
        }

        sb.replace(i, i + 1, "0");
        sb.replace(j - 1, j, "1");

        return true;

    }

    public static int findOnesIndex(StringBuilder sb, int startIndex) {
        int i = -1;
        for (int j = startIndex; j < sb.length(); j++) {
            char c = sb.charAt(j);
            if (c == '1') {
                return j;
            }
        }
        return i;
    }

}
