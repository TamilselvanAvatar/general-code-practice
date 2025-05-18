package code360;
import java.util.*;
public class Submatrix {
    public static void main(String[] args) {
        Integer a = 0;
        Map<Integer, Integer> f = new HashMap<>();
        f.putIfAbsent(0,0);
        f.computeIfPresent(0, (k, i) -> i + 1);
        f.computeIfPresent(0, (k, i) -> i + 1);
        Math.sqrt(17);
        f.forEach((k,v)-> {System.out.println(k + ":"+v);});
    }
}
