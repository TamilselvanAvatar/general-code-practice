package helperUtil;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringUtils {

    public static final String EMPTY = "";
    public static final String BLANK = " ";
    public static final String YES = "YES";

    public static String toUpperCase(String str) {
        return str == null ? EMPTY : str.toUpperCase();
    }

    public static boolean equalIgnoreCase(String str1, String str2) {
        return toUpperCase(str1).equals(toUpperCase(str2));
    }

    public static boolean isEquals(String str1, String str2) {
        return str2 != null && str2.equals(str1);
    }

    public static String fromCharToString(char ch) {
        return ch + EMPTY;
    }

    public static boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public static Stream<String> toStream(String[] str) {
        return Arrays.stream(str);
    }

    public static String notIntersectLetters(String str1, String str2) {
        StringBuilder s1 = new StringBuilder(str1);
        StringBuilder s2 = new StringBuilder(str2);
        replaceToEmpty(str1, s2);
        replaceToEmpty(str2, s1);
        return s1.append(s2).toString();
    }

    private static void replaceToEmpty(String str, StringBuilder sb) {
        for (int i = 0; i < str.length(); i++) {
            String ch = fromCharToString(str.charAt(i));
            int index = sb.indexOf(ch);
            if (index > -1) {
                sb.replace(index, index + 1, EMPTY);
            }
        }
    }

}
