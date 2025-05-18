package code360;

/*
Link: https://www.naukri.com/code360/problem-of-the-day/easy?date=2025-05-14&leftPanelTabValue=PROBLEM
Approach:
An observation is that if we move from a smaller number to a larger one, their MSB in binary representation changes from 0 to 1 or remains unchanged.
In our pair (a, b), both numbers should be in the range [L, R], then the position of MSB (from right to left in binary) in a⊕b can never be greater than in L⊕R.

Let’s understand by an example.
        Let L = 16 and R = 20.
        L ⊕ R = (10000) ⊕ (10100) = (00100). Here, MSB is in 3rd position from the right side, which ensures that MSB can’t exceed the 3rd position for any pair (a, b) in the range [L, R].
        Currently, our answer is 1xxxxx, where we know the position of bit ‘1’.

Now, the question arises, what to do with the remaining positions/bits?
To answer this question, our another observation is that, the position where we got MSB in L⊕R, one among L and R has bit ‘1’ at that place and another has bit ‘0’.
So in the given range, at least once, the number is changed from ‘1111…..’ to ‘1000…..’ i.e., (2^p - 1) to (2^p). Hence it is always possible to choose combinations such that in 1xxxxx, each bit becomes ‘1’.


Time Complexity O(log R), where ‘R’ is the right endpoint of array ‘A’, and given in input data. The number of bits in ‘L_xor_R’ can’t exceed bits in ‘R’, and finding the position of MSB takes logarithmic time. Hence overall time complexity becomes O(log R).
Space Complexity O(1).
We are using only constant space. Hence overall space complexity is O(1).
*/

public class MaxXor {
    public static void main(String[] args) {
        int maxXor = maxXor(8, 20);
        System.out.println("MAX OR => " + maxXor);
    }

    public static int maxXor(int L, int R) {
        int L_XOR_R = L ^ R; // Will get MSB 1 ( Between L and R -> so that no max xor exceed that MSB)
        int MSB_POSITION = 0; // Most Significant Bit Position (from right to left in binary) `L XOR R` ( 2's power )
        while (L_XOR_R > 0) {
            MSB_POSITION++;
            L_XOR_R >>= 1; // L_XOR_R /= 2;
        }
        int maxXOR = 0;
        for(int i = 0; i < MSB_POSITION; i++) {
            maxXOR += (int) Math.pow(2, i); // ( 1 << i ) === ( 2 ** i [ which is in python ])
        }
        return maxXOR;
    }

}
