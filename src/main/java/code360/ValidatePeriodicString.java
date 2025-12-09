package code360;

import static helperUtil.StringUtils.fromCharToString;

/**
 * Description: <a href="https://www.naukri.com/code360/problem-of-the-day/easy?date=2025-11-04">Link</a>
 * <p>Periodic String: ababab</p>
 */

public class ValidatePeriodicString {
    public static void main(String[] args) {
        System.out.println(isPeriodic("ababab"));
        // Better Algorithm
        // S: Original String
        // ( S + S ).splice(1, -1).includes(S)
    }

    public static boolean isPeriodic(String s) {
        if (s == null) {
            return false;
        }
        StringBuilder sub = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            String c = fromCharToString(s.charAt(i));
            sub.append(c);
            if (canFormString(sub, s)) {
                return true;
            }
        }
        return false;
    }

    public static boolean canFormString(StringBuilder sub, String s) {
        StringBuilder form = new StringBuilder();
        for (int j = 0; j < s.length(); j = j + sub.length()) {
            form.append(sub);
        }
        return form.toString().equals(s);
    }
}
