package generalAmbiguous;

/**
 * Description: Find the given string is periodic or not
 * <p>Example:</p>
 * <p>Periodic String: abcabc, xxxx</p>
 */

public class FindPeriodicString {
    public static void main(String[] args) {
        System.out.println(isPeriodic("abcabc"));
    }

    public static boolean isPeriodic(String s) {
        if (s == null) {
            return false;
        }
        StringBuilder sub = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            String c = s.charAt(i) + "";
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