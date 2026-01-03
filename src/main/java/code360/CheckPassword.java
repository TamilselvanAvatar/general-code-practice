package code360;

import java.util.regex.Pattern;

/**
 * Description: <a href="https://www.naukri.com/code360/problem-of-the-day/easy?date=2025-12-12">Link</a>
 * <pre>
 * 1) Length of the password must be between 8 to 15 characters.
 * 2) At least one digit (0-9), one lowercase letter (a-z), one uppercase letter (A-Z) and one special character (%, ^, &, #, *, %, etc) must be present.
 * 3) Password must not contain any space.
 * You are given a string ‘STR’, help ninjas to find whether it's a valid password or not.
 * </pre>
 *
 * <pre>
 * Part,Code,Fix/Reason
 * Digit Check,(?=.*\\d),"Fixed: Use .* (zero or more) to allow the digit to appear anywhere, including the very first character."
 * Letter Check,(?=.*[a-zA-Z]),Fixed: Use .* to allow the letter to appear anywhere.
 * Symbol Check,(?=.*[^\\w\\s]),Fixed: This is the correct way to guarantee a special character. It asserts the presence of a character that is not a word character (\w) AND not a whitespace character (\s).
 * NO SPACE / Length,"[^\\s]{8,15}","This is the critical part to enforce NO SPACE. You must replace the final . (which matches spaces) with \texttt{[^\\s]} (which matches any non-whitespace character). The overall pattern becomes: \texttt{^(?=.*\\d)(?=.*[a-zA-Z])(?=.*[^\\w\\s])\**[^\\s]{8,15}**\$}"
 * </pre>
 */

public class CheckPassword {
    public static void main(String[] args) {
        System.out.println(isValid(""));
    }
    public static boolean isValid(String str) {
        Pattern pattern = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^\\w\\s])\\S{8,15}$");
        return pattern.matcher(str).matches();
    }
}
