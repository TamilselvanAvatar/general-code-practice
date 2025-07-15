import helperUtil.Printer;
import helperUtil.Timer;
import helperUtil.sort.MergeSort;
import helperUtil.sort.QuickSort;
import helperUtil.sort.Sorter;

public class SampleValidate {
    public static void main(String[] args) {
        Printer<Integer> printer = new Printer<>();
        Timer timer = new Timer();
        Integer[] arr = {20, 2, 7, 12, 15, 1, 6, 8};
        Sorter sorter = new MergeSort();
        timer.startTimer();
        sorter.sort(arr, (a, b) -> a <= b);
        printer.printAsArray("Time Taken: " + timer.stopTimer() + " ", arr);
        sorter = new QuickSort();
        timer.startTimer();
        sorter.sort(arr, (a, b) -> a >= b);
        printer.printAsArray("Time Taken: " + timer.stopTimer() + " ", arr);
    }
}