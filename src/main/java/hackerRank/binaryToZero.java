package hackerRank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author TamilSelvan
 *         <p>
 *         Given a decimal number, how many minimum possible steps are required
 *         to convert this to zero provided: 1.Change the bit i if the next bit
 *         i+1 is '1' and all the other bits i+2 and later are 0 2.Change the
 *         last bit without restriction
 *         </p>
 *
 *
 *         <p>For example: if input is (8)Base10 = (1000)Base2, then the steps</p>
 *         taken are:
 *         <p>1000→1001→1011→1010→1110→1111→1101→1100→0100→0101→0111→0110→0010→0011→0001→0000</p>
 *         <p>total 15 steps are required.</p>
 *
 *         // fn + space
 *         🤦‍♀️🤦‍♀️🤦‍♀️🤦‍♀️🤦‍♀️›’''©‚¦‘]👍💕💋💋🎶🐱‍🚀🐱‍🚀✔😃✨👀👀
 *
 */

public class binaryToZero {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number : ");
        int num = sc.nextInt();
        String str = Integer.toBinaryString(num);
        System.out.println(str);
        int sum = 0;
        int sign = 1;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            int digit = Integer.parseInt(str.charAt(i) + "");
            int power = (int) (digit > 0 ? Math.pow(2, str.length() - (i + 1)) : 0);
            int steps = digit * (power * 2 - 1);
            sum += steps * sign;
            System.out.println(
                    "Digit:" + digit + " power: " + power + " steps: " + steps + " sum : " + sum + " sign :" + sign);
            sign = sign * (digit == 0 ? 1 : -1);
        }


        /* for (int i = 0; true; i++) {
             if ((1l << i) > num) { break; }
             sum += (2 * ((1l << i)) - 1) * (Math.pow(-1, count))* (num & (1l << i));
             count++;
         }*/


        System.out.println("Solution(It works well : but don't know how its work): \n" + sum);
        System.out.println("Enter :");

        System.out.println(calculateStepsRequired(sc.nextLong()));
    }

    static BigInteger calculateStepsRequired(long number) {
        // Take sign bit
        int bit = number < 0 ? 1 : 0;
        BigInteger result = BigInteger.valueOf(bit);
        for (int i = 0; i < 63; i++) {
            number = number << 1;
            int sign = number < 0 ? 1 : 0;
            bit = (bit + sign) % 2;
            result = result.shiftLeft(1).add(BigInteger.valueOf(bit));
            System.out.println("Number: "+ number+" sign :"+sign +"Bit : "+bit +" result : "+result);
        }
        return result;
    }

}

