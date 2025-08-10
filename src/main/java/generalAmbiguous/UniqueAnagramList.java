package generalAmbiguous;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * <p>Description: Will provide the Array and Should Return the Unique Anagram Array In Sorted</p>
 */

public class UniqueAnagramList {
    public static void main(String[] args) {
        String[] str = {"ate", "race", "care", "eat"};
        uniqueAnagramList(str);
    }

    private static void uniqueAnagramList(String[] str) {
        Set<String> result = new TreeSet<>();
        Set<String> mapper = new HashSet<>();
        for (String s : str) {
            String sb = Arrays.stream(s.split("")).sorted().collect(Collectors.joining());
            if (!mapper.contains(sb)) {
                result.add(s);
                mapper.add(sb);
            }
        }
        System.out.println(result);
    }
}