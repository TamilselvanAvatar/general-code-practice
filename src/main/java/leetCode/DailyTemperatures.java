package leetCode;

import helperUtil.Printer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Stack;
import java.util.stream.IntStream;

/**
 * Given an array of daily temperatures, returns an array such that {@code answer[i]}
 * is the number of days you have to wait after the {@code i}th day to get a warmer temperature.
 * <p>
 * If there is no future day with a warmer temperature, {@code answer[i]} will be set to {@code 0}.
 *
 * <p>@param temperatures An array of integers representing daily temperatures. </p>
 * <p><b>Example:</b></p>
 * <pre>
 *  Input:  [73, 74, 75, 71, 69, 72, 76, 73]
 *  Output: [1, 1, 4, 2, 1, 1, 0, 0]
 * </pre>
 */

public class DailyTemperatures {
    private static final Printer<Integer> print = new Printer<>();

    public static void main(String[] args) {
        Integer[] arr = {79, 74, 75, 71, 69, 72, 76, 73};
        calculateDaysTraditionalWay(arr);
        calculateDays(arr);
    }

    private static void calculateDaysTraditionalWay(Integer[] arr) {
        int size = arr.length;
        Integer[] answer = new Integer[size];
        for (int i = 0; i < size; i++) {
            int count = 0;
            for (int j = i + 1; j < size; j++) {
                count++;
                if (arr[j] > arr[i]) {
                    break;
                }
                if (j == size - 1) {
                    count = 0;
                }
            }
            answer[i] = count;
        }
        print.printAsArray("\nDaily Temperature by Traditional way:", answer);
    }

    private static void calculateDays(Integer[] arr) {
        // arr = [73, 72, 74]
        // {0: 2, 1: 1, 2: 0}
        int size = arr.length;
        Integer[] answer = new Integer[size];
        IntStream.range(0, size).forEach(i -> answer[i] = 0);
        Stack<Temperature> temperatures = new Stack<>();
        for (int i = 0; i < size; i++) {
            while (!temperatures.isEmpty() && temperatures.peek().getValue() < arr[i]) {
                Temperature temperature = temperatures.pop();
                answer[temperature.getIndex()] = i - temperature.getIndex();
            }
            temperatures.add(new Temperature(i, arr[i]));
        }
        print.printAsArray("\nDaily Temperature by YouTube Solution (GregHogg)", answer);
    }

    @Setter
    @Getter
    @AllArgsConstructor
    static class Temperature {
        private int index;
        private int value;
    }

}