package generalAmbiguous;

import java.util.Scanner;

/**
 * Description: To find the number is prime (only divisible by its number or by 1)
 */

public class IsPrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = scanner.nextInt();
        System.out.println(num + (isPrime(num) ? " is " : " is not ") + "a prime number.");
    }

    private static boolean isPrime(int num) {
        if (num % 2 == 0) {
            return false;
        }
        for (int i = 3; i < Math.sqrt(num); i += 2) {
            if (num % i == 0) return false;

        }
        return true;
    }
}
