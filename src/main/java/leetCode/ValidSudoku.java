package leetCode;

import helperUtil.CustomException.NotValidSudokuException;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: <a href="https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/769/">Link</a>
 * <pre>
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * <pre>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 * </pre>
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * </pre>
 */

public class ValidSudoku {

    public static int subMatrixRow = 3;
    public static int subMatrixCol = 3;
    public static char EMPTY_SPACE_DELIMITER = '.';

    public static void main(String[] args) {
        char[][] SUDOKU_BOARD = {
                // Row 0
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                // Row 1
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                // Row 2
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                // Row 3
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                // Row 4
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                // Row 5
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                // Row 6
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                // Row 7
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                // Row 8
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(isValidSudoku(SUDOKU_BOARD));
    }

    public static boolean isValidSudoku(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        // Check Each Rows And Columns are Valid (No Duplicate Number);
        try {
            for (int i = 0; i < row; i++) {
                Set<Character> rowHolder = new HashSet<>();
                Set<Character> colHolder = new HashSet<>();
                for (int j = 0; j < col; j++) {
                    checkIfExist(board[i][j], rowHolder); // row check
                    checkIfExist(board[j][i], colHolder); // col check
                }
            }
        } catch (NotValidSudokuException e) {
            return false;
        }

        // Check Each Sub-matrix (3 x 3) are valid (No Duplicate Number);
        try {
            for (int i = 0; i < row; i = i + subMatrixRow) {
                for (int j = 0; j < col; j = j + subMatrixCol) {
                    subMatrixCheckIfExist(board, i, j);
                }
            }
        } catch (NotValidSudokuException e) {
            return false;
        }

        return true;
    }

    public static void subMatrixCheckIfExist(char[][] board, int i, int j) {
        Set<Character> subMatrixHolder = new HashSet<>();
        for (int k = i; k < (subMatrixRow + i); k++) {
            for (int l = j; l < (subMatrixCol + j); l++) {
                checkIfExist(board[k][l], subMatrixHolder);
            }
        }
    }

    public static void checkIfExist(char ch, Set<Character> holder) {
        if (ch != EMPTY_SPACE_DELIMITER && holder.contains(ch)) {
            throw new NotValidSudokuException();
        } else {
            holder.add(ch);
        }
    }

}