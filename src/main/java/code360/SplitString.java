package code360;

import java.util.Set;

/**
 * Description: <a href="https://www.naukri.com/code360/problem-of-the-day/easy?date=2025-12-09">Link</a>
 * <p>Vowels from Right to left of the String Should be equals</p>
 * <p> Given the String in even size</p>
 */

public class SplitString {
    public static void main(String[] args) {
        System.out.println(splitString("codingNinjas"));
    }
    public static Boolean splitString(String str) {
        int i = 0;
        int j = str.length() - 1;
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int fromLeft = 0;
        int fromRight = 0;
        while(i < j){
            if(vowels.contains(str.charAt(i))){
                fromLeft++;
            }
            if(vowels.contains(str.charAt(j))){
                fromRight++;
            }
            i++;
            j--;
        }
        return fromLeft == fromRight;
    }
}
