package code360;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: <a href="https://www.naukri.com/code360/problem-of-the-day/easy?date=2025-12-10">Link</a>
 * <pre>
 * You have been given a queue of integers.
 * You need to rearrange the elements of the queue by interleaving the elements of the first half of the queue with the second half.
 * Note :
 * The given queue will always be of even length.
 * For example :
 * If N= 10 and
 * Q = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
 * then the output will be
 * Q = [10, 60, 20, 70, 30, 80, 40, 90, 50, 100]
 * </pre>
 */

public class InterLeaveQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new PriorityQueue<>();
        q.addAll(List.of(10, 20, 30, 40, 50, 60, 70, 80, 90, 100));
        interLeaveQueue(q);
        System.out.println(q);
    }

    public static void interLeaveQueue(Queue<Integer> q) {
        int size = q.size();
        int i = 0;
        int j = (size / 2);
        List<Integer> firstHalf = new ArrayList<>();
        List<Integer> lastHalf = new ArrayList<>();
        while (i < j) {
            firstHalf.add(q.remove());
            i++;
        }
        while (j < size) {
            lastHalf.add(q.remove());
            j++;
        }
        q.clear();
        for (int k = 0; k < (size / 2); k++) {
            q.add(firstHalf.get(k));
            q.add(lastHalf.get(k));
        }
    }
}
