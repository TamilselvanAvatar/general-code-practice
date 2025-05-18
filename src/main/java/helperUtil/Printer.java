package helperUtil;

import java.util.Collection;

public class Printer<T> {

    public void printAsArray(T[] a) {
        int len = a.length;
        StringBuilder output = new StringBuilder("[ ");
        for (int j = 0; j < len; j++) {
            output.append(j == len - 1 ? a[j] : a[j] + ", ");
        }
        output.append(" ]");
        System.out.println(output);
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
        System.out.println( !includeBracket ? printer : "{ " + printer + " }");
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