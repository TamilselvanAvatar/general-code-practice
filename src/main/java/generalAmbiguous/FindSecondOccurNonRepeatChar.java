package generalAmbiguous;

import helperUtil.Counter;

import java.util.Scanner;

/**
 * Description: Find the second non-repeating char in the given string
 * <p>General: Given a string str of length n (1 <= n <= 106) and a number k, the task is to find the kth non-repeating character in the string.</p>
 * <p>Example:</p>
 * <br>
 * <p>Input : str = geeksforgeeks, k = 3</p>
 * <p>Output : r</p>
 * <p>Explanation: First non-repeating character is f, second is o and third is r.</p>
 * <br>
 * <p>Input : str = geeksforgeeks, k = 2 </p>
 * <p>Output : o </p>
 * <br>
 * <p> Input : str = geeksforgeeks, k = 4 </p>
 * <p> Output : Less than k non-repeating characters in input. </p>
 */

public class FindSecondOccurNonRepeatChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the  String:");
        String source = sc.nextLine();
        System.out.println("Enter the n-th non-repeat char to find");
        int k = sc.nextInt(); // General case to handle n-th non-repeat
        boolean isThereNonRepeatChar = false;
        StringBuilder resultString = new StringBuilder(k + " -th non-repeat characters in the " + source + " is : ");
        for (int i = 0, inc = 0 ; i < source.length() ; i++){
            char currentChar = source.charAt(i);
            if(Counter.count(source, currentChar) == 1){
                inc++;
                if(k == inc) {
                    isThereNonRepeatChar = true;
                    resultString.append(currentChar);
                    break;
                }
            }
        }
        System.out.println(isThereNonRepeatChar ? resultString : "Less than " + k + " non-repeating characters in " + source);
    }
}
