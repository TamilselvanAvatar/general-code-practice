package hackerRank;

import java.io.IOException;
import java.util.Scanner;
/**
Problem statement :
Sansa has an array. She wants to find the value obtained by XOR-ing the contiguous subarrays, followed by XOR-ing the values thus obtained. Determine this value.
Example
 arr = [3,4,5]

      Subarray	   Operation	    Result
        3		    None		    3
        4		    None		    4
        5		    None		    5
        3,4		    3 XOR 4		    7
        4,5		    4 XOR 5		    1
        3,4,5		3 XOR 4 XOR 5	2

 Now we take the resultant values and XOR them together:

 answer => 3 XOR 4 XOR 5 XOR 7 XOR 1 XOR 2 = 6

 sample input
 1 // how many time to repeat
 3 // no of element
 3 4 5 // enter the element

 */

public class SansaXOR {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
         // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int result = sansaXor(arr);
            System.out.println("Result : " + result);
        }

        scanner.close();
    }

    // Complete the sansaXor function below.
    static int sansaXor(int[] arr) {

        int min = 2;
        int max = arr.length -1 ;
        int xor = 0;

        while(min != arr.length ){
            for(int i = 0; i < min; i++){
                for(int j = i , count =1;count <= max ; count++,j++){
                    xor ^= arr[j];
                    System.out.print(arr[j]);
                }
                System.out.print("\n");

            }
            min++;
            max--;
        }

        return xor ;
    }

    
}
