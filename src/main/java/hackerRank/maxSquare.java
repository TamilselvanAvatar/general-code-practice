package hackerRank;

import java.util.*;

public class maxSquare {
    public static void main(String[] args) {
        List<List<Integer>> list = List.of(
                List.of(1,1,1,1),
                List.of(1,0,0,1),
                List.of(1,1,1,1),
                List.of(1,0,1,1)
        );
        int len = list.size();
        List<List<Integer>> dum = list.subList(0,len-1);
        for(List<Integer> dum2 : dum) {
            List<Integer> dum3 = dum2.subList(0,len-1);
            System.out.println(dum3 );
        }


        for(int i = len ; i >= 1 ; i--) {
            int j = 0;
            System.out.println("===");
            for(int k = 0 ; k < len ; k++) {
                List<Integer> l = list.get(k).subList(0,len);
                System.out.println(l);
                if(l.indexOf(0) == -1 ) {
                    j++;
                }else {
                    break;
                }

            }
            if(j == len) {
                System.out.println("Maximun Square Matrix of Defect : "+ j);
                break;
            }
            len--;
        }

    }
}
