package someConcept;

import java.util.Scanner;

public class javaOperator {
    // Complete the solve function below.
    static void solve(double meal_cost, int tip_percent, int tax_percent) {
    	/*
    	double total;

    	double ttip = (meal_cost *0.01*tip_percent);
    	double ttax = (meal_cost *0.01*tax_percent);

    	total = meal_cost + ttip +ttax;*/
        double total = meal_cost + (double)(meal_cost*(tip_percent/100)) + (double)(meal_cost*(tax_percent/100));
        System.out.println((int)total);

        System.out.println(total);
        System.out.println(Math.round(total));

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double meal_cost = scanner.nextDouble();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int tip_percent = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int tax_percent = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        solve(meal_cost, tip_percent, tax_percent);

        scanner.close();
    }
}
