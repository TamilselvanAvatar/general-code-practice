package generalAmbiguous;

/**
 * Task: Find the Last Word and Length of that Word of the Given String
 */

public class LastWordOfString {
    public static void main(String[] args) {
        String str = " The King is super strong  ";
        String lastWord = findLastWord(str);
        System.out.printf("The Last Word: %s and length: %d", lastWord, lastWord.length());
    }

    public static String findLastWord(String str) {
        int len = str.length() - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = len; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch == ' ' && sb.length() == 0) {
                continue;
            } else if (ch == ' ') {
                break;
            }
            sb.append(ch);
        }
        return sb.reverse().toString();
    }

}