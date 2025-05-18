package patternPrint;

import java.util.Scanner;

/**
 * Description: To print the Diamond Pattern based on the number
 */

class LogicForDiamondPattern {

    public static void main(String s[]) { // Even though it is C-style array type declaration
        System.out.println("Enter the number: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < (2 * n - 1) + 2; i++) {
            for (int j = 0; j < 2 * n + 2; j++) {
                if ((i == 0 || i == (2 * n - 1) + 1)) {
                    if ((j == 0 || j == (2 * n + 2 - 1))) {
                        System.out.print("+");
                    } else {
                        System.out.print("-");
                    }
                } else {
                    if (j == 0 || j == (2 * n + 1)) {
                        System.out.print("|");
                    }
                    if (i == n) {
                        if (j == 1) {
                            System.out.print("<");
                        }
                        if (j == 2 * n) {
                            System.out.print(">");
                        }

                        if (n % 2 == 0 && (j >= 2 && j < 2 * n) && n >= 2) {
                            System.out.print("-");
                        }
                        if (n % 2 != 0 && (j >= 2 && j < 2 * n) && n >= 2) {
                            System.out.print("=");
                        }
                    }
                    if (i < n) {
                        if (j == (n - i)) {
                            System.out.print("/");
                        }
                        if (j == (n + i) - 2) {
                            System.out.print("\\");
                        }
                        if (j >= n - i && j < (n + i) - 2 && i % 2 == 0) {
                            System.out.print("-");
                        }
                        if (j >= n - i && j < (n + i) - 2 && i % 2 != 0) {
                            System.out.print("=");
                        }
                        if (j < n - i || j > (n + i)) {
                            System.out.print(" ");
                        }
                    }
                    if (i > n) {
                        if (j == i - (n)) {
                            System.out.print("\\");
                        }
                        if (j == 3 * n - i) {
                            System.out.print("/");
                        }
                        if (j > i - (n) && j < 3 * n - i - 1 && i % 2 == 0) {
                            System.out.print("-");
                        }
                        if (j > i - (n) && j < 3 * n - i - 1 && i % 2 != 0) {
                            System.out.print("=");
                        }
                        if (j < (i - n) || j > ((3 * n - i))) {
                            System.out.print(" ");
                        }
                    }

                }
            }
            System.out.print("\n");
        }
    }
}

