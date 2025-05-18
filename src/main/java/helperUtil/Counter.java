package helperUtil;

/**
 * Descrption : General Use Case to count Value in Array or String
 */

public class Counter {

    public static int count(String source, char target){
        // Count the number of times the char is present in the given string
        int count = 0;
        for (int i = 0; i < source.length(); i++) {
            if (target == source.charAt(i)) {
                count++;
            }
        }
        return count;
    }

}
