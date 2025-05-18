package hackerRank;

import java.io.IOException;
import java.util.Scanner;

/**
 * Problem Statement:
 * <p><a href="https://www.hackerrank.com/challenges/minimum-loss/problem">https://www.hackerrank.com/challenges/minimum-loss/problem</a></p>
 */

public class minimunLoss {
    // Complete the minimumLoss function below.
    static long min = -1L;

    static int minimumLoss(long[] price) {

        for(int i = 0; i<price.length - 1 ; i++){
            long dummy = price[i];
            minimumOfRow(i,dummy,price);
        }
        return (int)min;

    }

    static void minimumOfRow(int i , long dummy , long[] price){
        for(int j = i+1; j < price.length ; j++){
            if(price[j] <= dummy){
                long a = dummy - price[j];
                if(min == -1L){
                    min = a;
                }
                else{
                    if(a < min){
                        min =  a;
                    }
                }
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?"); //

        long[] price = new long[n];

        String[] priceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long priceItem = Long.parseLong(priceItems[i]);
            price[i] = priceItem;
        }

        int result = minimumLoss(price);
        System.out.println(result);
        /*
         * bufferedWriter.write(String.valueOf(result)); bufferedWriter.newLine();
         *
         * bufferedWriter.close();
         */

        scanner.close();
    }
}
