package generalAmbiguous;

import helperUtil.Printer;

/**
 * Shuffle the elements in the random order for the given int array
 */

public class ShuffleArray {
    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5, 6, 7};
        Printer<Integer> printer = new Printer<>();
        shuffleArray(a);
        printer.printAsArray(a);
    }

    public static <T> void shuffleArray(T[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int j = giveRandomIndex(len - 1);
            T temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp; // swap 2 place in the array with random index of array
        }
    }

    private static int giveRandomIndex(int len) {
        return (int) (Math.random() * len);
    }
}
