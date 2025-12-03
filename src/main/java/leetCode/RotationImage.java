package leetCode;

import static helperUtil.Printer.printAsArray;

/**
 * Description: <a href="https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/770/">Link</a>
 * <p>Rotate the given matrix to 90 degree</p>
 */

public class RotationImage {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printAsArray("ROriginal Matrix:", matrix);
        rotate(matrix);
        printAsArray("Rotated To 90 degree:", matrix);
    }

    public static void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] holder = new int[row][col];
        for (int i = 0; i < row; i++) {
            // for (int i = 0; i < row; i++) { for (int j = 0; j < col; j++) { holder[i][j] = matrix[i][j]; } } (Manual Copy)
            System.arraycopy(matrix[i], 0, holder[i], 0, col);
        }
        int k = 0;
        while (col > 0) {
            int[] rows = holder[k];
            for (int i = 0; i < row; i++) {
                matrix[i][col - 1] = rows[i];
            }
            k++;
            col--;
        }
    }
}