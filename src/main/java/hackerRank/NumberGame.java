package hackerRank;

import java.util.*;

import static helperUtil.Printer.printer;

/**
 * Number Game:
 * Alex has an integer and wants to convert it to 0 using the following operations on its binary
 * representation:
 * <p>
 * . Change the ith binary digit only if (i+1)th binary digit is 1 and all other binary digits from (i+2) to
 * the end are zeros.
 * <p>
 * · Change the rightmost digit without restriction.
 * <p>
 * Find minimum number of operations required. For example, given the number n => 8 => 1000. 15
 * operations are required to convert the number to zero under the rules:
 * 1000-1001-1011-1010-1110-1111-1101-1100-0100-0101-0111-0110-0010-0011-0001-0000
 * <p>
 * Note: In the binary representation of a number, the binary digit's positions are numbered as 0
 * to x from left to right, where x is the number of digits in the binary representation of the
 * number.
 */

public class NumberGame {
    public static void main(String[] args) {
        int givenNumber = 9;
        ArrayList<Integer> i = new ArrayList<>();
        i.add(1);
        i.add(0, 2);
        System.out.println(i);
        StringBuilder binaryNumber = convertedToBinary(givenNumber);
        int noOfSteps = performNumberGame(binaryNumber);
        System.out.println("No Steps to convert to zero ( " + binaryNumber + ") : " + noOfSteps);
    }

    private static StringBuilder convertedToBinary(int number) {
        StringBuilder binaryNumber = new StringBuilder();
        while (number >= 1) {
            int binaryValue = number % 2;
            number = number / 2;
            binaryNumber.append(binaryValue);
        }
        return binaryNumber.reverse();
    }

    private static int performNumberGame(StringBuilder binary) {
        int steps = 0;
        StringBuilder binaryNumber = new StringBuilder(binary);
        int rightMostDigitPosition = binaryNumber.length() - 1;

        Set<String> modifiedBinaryNumbers = new HashSet<>();
        modifiedBinaryNumbers.add(binaryNumber.toString());

        while (!isAllZero(binaryNumber, 0)) {
            boolean isChangedDigit = false;
            for (int i = 0; i <= rightMostDigitPosition; i++) {
                if (isConditionOneMet(binaryNumber, i)) {
                    StringBuilder newBinary = changeDigitValue(binaryNumber, i, true);
                    if (!modifiedBinaryNumbers.contains(newBinary.toString())) {
                        modifiedBinaryNumbers.add(newBinary.toString());
                        binaryNumber = newBinary;
                        isChangedDigit = true;
                    }
                    break;
                }
            }
            if (!isChangedDigit) {
                changeDigitValue(binaryNumber, rightMostDigitPosition, false);
                modifiedBinaryNumbers.add(binaryNumber.toString());
            }
            steps++;
        }
        modifiedBinaryNumbers.add(binaryNumber.toString());
        printer(modifiedBinaryNumbers, "->", "The Steps: Binary to All Digit Zero");
        return steps;
    }

    private static StringBuilder changeDigitValue(StringBuilder binaryNumber, int index, boolean returnNew) {
        char c = getChar(binaryNumber, index);
        if (!(c == '0' || c == '1')) {
            return binaryNumber;
        }
        char changedDigitValue = c == '0' ? '1' : '0';
        if (!returnNew) {
            binaryNumber.setCharAt(index, changedDigitValue);
        } else {
            StringBuilder newBinaryNumber = new StringBuilder(binaryNumber);
            newBinaryNumber.setCharAt(index, changedDigitValue);
            return newBinaryNumber;
        }
        return binaryNumber;
    }

    private static boolean isConditionOneMet(StringBuilder binaryNumber, int i) {
        return getChar(binaryNumber, i + 1) == '1' && isAllZero(binaryNumber, i + 2);
    }

    private static char getChar(StringBuilder binaryNumber, int index) {
        try {
            return binaryNumber.charAt(index);
        } catch (Exception e) {
            return '$';
        }
    }

    private static boolean isAllZero(StringBuilder binaryNumber, int index) {
        Boolean isAllIPlus2Zeros = null;
        int len = binaryNumber.length();
        if (index >= len) {
            return true;
        }
        for (int j = index; j < len; j++) {
            boolean zero = binaryNumber.charAt(j) == '0';
            isAllIPlus2Zeros = isAllIPlus2Zeros == null ? zero : (isAllIPlus2Zeros && zero);
        }
        return Boolean.TRUE.equals(isAllIPlus2Zeros);
    }

}
