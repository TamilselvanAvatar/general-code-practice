package generalAmbiguous;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description: To find the password is valid - based on code
 */

public class IsPasswordValid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Password:");
        String pass = sc.nextLine();
        int code = valid(pass);
        boolean op = code == 0;

        System.out.println(op + "\nCode = " + code);

    }

    public static int valid(String pass) {


        if (!(pass.length() >= 8 && pass.length() <= 31)) {
            return 10;
        }

        Pattern p1 = Pattern.compile("[a-zA-Z]+");
        Matcher m1 = p1.matcher(pass);
        Pattern p2 = Pattern.compile("\\d+");
        Matcher m2 = p2.matcher(pass);

        System.out.println(p1 + "  " + m1);

        if (!(m1.find() && m2.find())) {
            System.out.println(m1 + "   " + m2 + "   " + m1.matches() + "   " + m2.matches());
            return 20;
        }

        p1 = Pattern.compile("[@#%&*!]+");
        m1 = p1.matcher(pass);
        System.out.println(p1 + " Same here ? " + m1);

        if (!(m1.find())) {
            return 30;
        }

        p1 = Pattern.compile("[a-zA-Z]??");
        m1 = p1.matcher(pass);
        String s = "";
        while (m1.find()) {
            if (s == "") {
                s = m1.group();
                continue;
            }

            if (m1.group() != "") {

                if (m1.group().equals(s)) {
                    return 40;
                }
                s = m1.group();
            }
        }

        return 0;
    }
}

