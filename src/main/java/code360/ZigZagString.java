package code360;

/**
 * Description: <a href="https://www.naukri.com/code360/problem-of-the-day/easy?date=2026-01-02&leftPanelTabValue=PROBLEM">Link</a>
 * <p>
 * You are given a string ‘STR’ of size ‘N’ and an integer ‘M’ (the number of rows in the zig-zag pattern of ‘STR’).
 * Your task is to return the string formed by concatenating all ‘M’ rows when string ‘STR’ is written in a row-wise zig-zag pattern.
 * </p>
 */

public class ZigZagString {
    public static void main(String[] args) {
        System.out.println(zigZagString("UF", 2, 1));
        System.out.println(zigZagString("PM", 2, 2));
        System.out.println(zigZagString("JOFN", 4, 2));
        System.out.println(zigZagString("MAENYMYIIG", 10, 6));
    }

    public static String zigZagString(String str, int n, int m) {
        StringBuilder[] ans = new StringBuilder[n];
        int j = -1;
        boolean isDown = true;
        for (char ch : str.toCharArray()) {
            if (j == (m - 1)) {
                isDown = false;
            }
            if (j == 0) {
                isDown = true;
            }
            j += isDown ? 1 : -1;
            if (ans[j] == null) {
                ans[j] = new StringBuilder();
            }
            ans[j].append(ch);
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder s : ans) {
            if (s != null) {
                sb.append(s);
            }
        }
        return sb.toString();
    }

    public static String zigZagStringAlternative(String str, int n, int m) {
        if (m <= 1 || m >= n) { // STR LEN IS `n`
            return str;
        }
        StringBuilder[] rows = new StringBuilder[n];
        int j = -1;
        int move = 1; // 1 MOVE DOWN OR -1 MOVE UP
        for (char ch : str.toCharArray()) {
            if (j == (m - 1)) {
                move = -1;
            }
            if (j == 0) {
                move = 1;
            }
            j += move;
            if (rows[j] == null) {
                rows[j] = new StringBuilder();
            }
            rows[j].append(ch);
        }
        /*
        // GIVEN BY AI
        int currentRow = 0;
        boolean goingDown = false;
        for (char c : str.toCharArray()) {
            if (rows[j] == null) {
                rows[j] = new StringBuilder();
            }
            rows[currentRow].append(c);
            // Reverse direction when we hit the top or bottom row
            if (currentRow == 0 || currentRow == n - 1) {
                goingDown = !goingDown;
            }
            // Move up or down
            currentRow += goingDown ? 1 : -1;
        }
        */
        StringBuilder sb = new StringBuilder();
        for (StringBuilder s : rows) {
            if (s != null) {
                sb.append(s);
            }
        }
        return sb.toString();
    }

}