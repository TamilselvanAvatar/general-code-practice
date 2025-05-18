package generalAmbiguous;

import static helperUtil.Printer.printAsArray;

/**
 Shuffle the elements in the random order for the given int array
 */

public class ShuffleArray {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7} ;
        int len = a.length;
        for(int i = 0; i < len ; i++) {
            int j = giveRandomIndex(len-1);
            int temp = a[j];
            a[j] = a[i];
            a[i] = temp; // swap 2 place in the array with random index of array
        }
        printAsArray(a);
    }
    private static int giveRandomIndex(int len){
        return (int)(Math.random() * len);
    }
}
