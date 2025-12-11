package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: <a href="https://leetcode.com/problems/count-common-words-with-one-occurrence/description">Link</a>
 * <p>Given two string arrays words1 and words2, return the number of strings that appear exactly once in each of the two arrays.</p>
 */

public class CountCommonWordsWithOneOccurrence {
    public static void main(String[] args) {
        String[] word1 = {"leetcode", "is", "amazing", "as", "is"};
        String[] word2 = {"amazing", "leetcode", "is"};
        System.out.println(countWords(word1, word2));
    }

    public static int countWords(String[] words1, String[] words2) {
        Map<String, Integer> wordsByCount = new HashMap<>();
        int count = 0;
        for (String word : words1) {
            String lowerCaseWord = word.toLowerCase();
            wordsByCount.computeIfPresent(lowerCaseWord, (k, v) -> -1);
            wordsByCount.putIfAbsent(lowerCaseWord, 1);
        }
        for (String word : words2) {
            String lowerCaseWord = word.toLowerCase();
            wordsByCount.computeIfPresent(lowerCaseWord, (k, v) -> v - 1);
            wordsByCount.putIfAbsent(lowerCaseWord, -1);
        }
        for (Map.Entry<String, Integer> entry : wordsByCount.entrySet()) {
            if (entry.getValue() == 0) {
                count++;
            }
        }
        return count;
    }
}
