package generalAmbiguous;

import static helperUtil.Printer.printAsArray;

/**
 * @author TamilSelvan
 *<p></p>
 * Alternate sorting:
 * Given an array of integers, rearrange the array in such a way that
 * the first element is first maximum and second element is first minimum.
 * <p> Eg.) </p>
 * <p>     Input  : {1, 2, 3, 4, 5, 6, 7} </p>
 * <p>     Output : {7, 1, 6, 2, 5, 3, 4} </p>
 *
 */
public class SortArrayElementAlternatively {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 9, 11};
        int[] b = {1, 2, 3, 4, 5, 6, 7, 9, 11};
        int[] c = {1, 2, 3, 4, 5, 6, 7, 9, 11};
        // int[] a = {1, 2, 3, 4, 5, 6};
        // int[] b = {1, 2, 3, 4, 5, 6};
        // int[] a = {1, 5};
        // int[] b = {1, 5};
        // int[] a = {};
        // int[] b = {};
        long timeStart = System.nanoTime();
        solution1(a);
        long timeEnd = System.nanoTime();
        System.out.println("Time taken for solution 1: " + (timeEnd - timeStart));
        long timeStart1 = System.nanoTime();
        solution2(b);
        long timeEnd1 = System.nanoTime();
        System.out.println("Time taken for solution 2: " + (timeEnd1 - timeStart1));

    }

    private static void solution2(int[] a) {
        for(int i = 0 ; i < a.length  ; i= i+2) {
            findMaxAndMinAndSwap(a, i);
        }
        printAsArray(a);
    }

    private static void findMaxAndMinAndSwap(int[] a, int i) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int li = -1;
        int hi = -1;
        for (int j = i; j < a.length; j++) {
            if(max <= a[j]) {
                max = a[j];
                hi = j;

            }
            if(min >= a[j]) {
                min = a[j];
                li = j;
            }
        }

        if((li == i  && hi == (i+1)) || (li == (i + 1)  && hi == i)) {
            a[i] = max;
            if(!(i == a.length -1)) {
                a[i+1] = min;
            }
        } else if(li == i) {
            a[i] = max;
            if(!(i == a.length -1)) {
                int temp = a[i+1];
                a[i+1] = min;
                a[hi] = temp;
            }

        } else if(li == (i+1)) {
            int temp = a[i];
            a[i] = max;
            a[hi] = temp;
            if(!(i == a.length -1)) {
                a[i+1] = min;
            }
        } else if(hi == i) {
            a[i] = max;
            if(!(i == a.length -1)) {
                int temp = a[i+1];
                a[i+1] = min;
                a[li] = temp;
            }
        } else if(hi == (i+1)) {
            if(!(i == a.length -1)) {
                int temp = a[i];
                a[i] = max;
                a[i+1] = min;
                a[li] = temp;
            }
        } else {
            int temp = a[i];
            a[i] = max;
            a[hi] = temp;
            if(!(i == a.length -1)) {
                temp = a[i+1];
                a[i+1] = min;
                a[li] = temp;
            }
        }

    }

    private static void solution1(int[] a) {
        for(int i = 0 ; i < a.length ; i++) {
            if(i % 2 == 0) {
                int[] maxArr = findMaxNumInArray(a,i);
                int temp = a[i];
                a[i] = maxArr[0];
                a[maxArr[1]] = temp;

            }
            else {
                int[] minArr = findMinNumInArray(a, i);
                int temp = a[i];
                a[i] = minArr[0];
                a[minArr[1]] = temp;
            }
        }
        printAsArray(a);

    }

    private static int[] findMaxNumInArray(int[] a, int i) {
        int max = 0;
        int index = i;
        int[] ans = new int[2];
        for (int j = i; j < a.length; j++) {
            if(max <= a[j]) {
                max = a[j];
                index = j;
            }
        }
        ans[0] = max;
        ans[1] = index;
        return ans ;
    }

    private static int[] findMinNumInArray(int[] a, int i) {
        int min = a[0];
        int index = i;
        int[] ans = new int[2];
        for (int j = i; j < a.length; j++) {
            if(min >= a[j]) {
                min = a[j];
                index = j;
            }
        }
        ans[0] = min;
        ans[1] = index;
        return ans ;
    }

}

