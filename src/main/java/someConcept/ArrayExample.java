package someConcept;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayExample {

    public static void main (String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the array size");
        int size = Integer.parseInt(br.readLine());
        int arr[] = new int[size]	;
        int diff[] = new int[size]	;
        if(size<5 || size> 10) {
            System.out.println("Invalid array size");
            System.exit(0);
        }
        else {
            System.out.println("Enter the array elements");
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
        }
        for (int i = 0; i < size-2; i++) {
            if(arr[i]>arr[i+2]) {
                diff[i] = arr[i] - arr[i+2];
            }
            else {
                diff[i] = arr[i+2] - arr[i];
            }
        }
        int large = 0;

        for (int i = 0; i < diff.length; i++) {
            if(diff[i]>large) {
                large = diff[i];
            }
        }
        int pos =-1;
        for (int i = 0; i <size; i++) {
            if (arr[i]>arr[i+2]) {
                if((arr[i] - arr[i+2])==large) {
                    pos = i+2;
                    break;
                }
            }
            else {
                if((arr[i+2] - arr[i])==large) {
                    pos =i;
                    break;
                }
            }
        }

        System.out.println("Index:"+pos);
        arrayExample(size);
    }

    public static void arrayExample(int n){
        int count = 0, sum = 0;
        for (int i = 0; n > 0; i++) {
            sum = sum + ((n % 2) * ((int) Math.pow(10, i)));
            n = n / 2;
            count++;
        }
        System.out.println(sum + "**" + count);
        int arr[] = new int[count];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sum % 10;
            sum = sum / 10;
        }
        int i = 0,j=0;
        while (zeroChecker(arr)) {
            if (((i + 1) == 1) && eyePlus2(i + 2, arr.length, arr)) {
                if (arr[i] == 0) {
                    arr[i] = 1;
                } else {
                    arr[i] = 0;
                }
            }
            if (arr[i]==0) {
                arr[i] =1;
            }
            else {
                arr[i]=0;
            }
            i++;
            if (i < count-2) {
                i = 0;
            }

            j++;
        }
        System.out.println("Output:"+j);
    }

    public static boolean eyePlus2(int i, int end, int[] arr) {
        for (int j = i; j < end; j++) {
            if (arr[j] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean zeroChecker(int[] arr) {
        for (int i : arr) {
            if (i != 0) {
                return true;
            }
        }
        return false;
    }

}
