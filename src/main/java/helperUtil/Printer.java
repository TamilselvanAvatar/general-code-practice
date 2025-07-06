package helperUtil;

import java.util.Collection;

public class Printer<T> {

    public void printAsArray(T[] a) {
        System.out.println(getAsString(a));
    }

    private StringBuilder getAsString(T[] a){
        int len = a.length;
        StringBuilder output = new StringBuilder("[ ");
        for (int j = 0; j < len; j++) {
            output.append(j == len - 1 ? a[j] : a[j] + ", ");
        }
        output.append(" ]");
        return output;
    }

    @SafeVarargs
    public final void printAsArray(String msg, T[]... arr) {
        String[] msgArr = msg.split(";");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(msgArr[i]);
            sb.append(getAsString(arr[i]));
            sb.append("\t");
        }
        System.out.println(sb);
    }

    public void printAsArray(String msg, T[] arr) {
        System.out.println(msg);
        printAsArray(arr);
    }

    public static <TYPE> void printer(Collection<TYPE> collection, String delimiter, String message, boolean includeBracket) {
        System.out.println(message);
        StringBuilder printer = new StringBuilder();
        int size = collection.size() - 1;
        int loopCount = 0;
        for (TYPE obj : collection) {
            printer.append(obj);
            if (size != loopCount) {
                printer.append(delimiter);
            }
            loopCount++;
        }
        System.out.println(!includeBracket ? printer : "{ " + printer + " }");
    }

    public static <TYPE> void printer(Collection<TYPE> collection, String delimiter, String message) {
        printer(collection, delimiter, message, false);
    }

    public static void printAsArray(int[] a) {
        int len = a.length;
        StringBuilder output = new StringBuilder("[ ");
        for (int j = 0; j < len; j++) {
            output.append(j == len - 1 ? a[j] : a[j] + ", ");
        }
        output.append(" ]");
        System.out.println(output);
    }

    public static void printAsArray(String msg, int[] a) {
        System.out.println(msg);
        printAsArray(a);
    }

    public static void printAsArray(double[] a) {
        int len = a.length;
        StringBuilder output = new StringBuilder("[ ");
        for (int j = 0; j < len; j++) {
            output.append(j == len - 1 ? a[j] : a[j] + ", ");
        }
        output.append(" ]");
        System.out.println(output);
    }

    public static void printAsArray(float[] a) {
        int len = a.length;
        StringBuilder output = new StringBuilder("[ ");
        for (int j = 0; j < len; j++) {
            output.append(j == len - 1 ? a[j] : a[j] + ", ");
        }
        output.append(" ]");
        System.out.println(output);
    }

    public static void printAsArray(char[] a) {
        int len = a.length;
        StringBuilder output = new StringBuilder("[ ");
        for (int j = 0; j < len; j++) {
            output.append(j == len - 1 ? a[j] : a[j] + ", ");
        }
        output.append(" ]");
        System.out.println(output);
    }

    public static void printAsArray(String[] a) {
        int len = a.length;
        StringBuilder output = new StringBuilder("[ ");
        for (int j = 0; j < len; j++) {
            output.append(j == len - 1 ? a[j] : a[j] + ", ");
        }
        output.append(" ]");
        System.out.println(output);
    }

}