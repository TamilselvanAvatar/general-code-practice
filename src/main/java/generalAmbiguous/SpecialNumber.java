package generalAmbiguous;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Description : To find the give number is special or not (Special number is where the sum of the factorial of its digits equals the number itself.)
 * <p>Example : </p>
 * <p>Input: 40585</p>
 * <p>Output: It is special number[4! + 0! + 5! + 8! + 5! = 40585]</p>
 */

public class SpecialNumber {
    static List<String> arr;
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number to find it is special:");
        String num = s.nextLine();
        arr = Arrays.asList(num.split(""));
        int sumFactorialOfNum = 0 ;
        for(String i : arr){
            sumFactorialOfNum += factorialOfNumber(parse(i));
        }
        if(parse(num) == sumFactorialOfNum){
            System.out.println(num + " is a special number");
        }
        else{
            System.out.println(num + " is not a special number");
        }

    }

    public static int factorialOfNumber(int i) {
        int factValue = 1;
        for (int j = 1; j <= i; j++) {
            factValue *= j;
        }
        return factValue;
    }

    public static int parse(String str){
        try{
            return Integer.parseInt(str);
        }
        catch(Exception e){
            return 0;
        }
    }
}
