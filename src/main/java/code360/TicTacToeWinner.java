package code360;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static helperUtil.Printer.printAsArray;

public class TicTacToeWinner {
    public static void main(String[] args) {
        int n = 9;
        List<List<Integer>> moves = List.of(
                List.of(0, 0),
                List.of(0, 1),
                List.of(1, 1),
                List.of(1, 0),
                List.of(2, 1),
                List.of(2, 2),
                List.of(2, 0),
                List.of(0, 2),
                List.of(1, 2)
        );
        System.out.println(ticTacToeWinner(moves, n));
        System.out.println(ticTacToeWinner(moves, n));
    }

    private static final char X = 'X';
    private static final char O = 'O';

    public static String ticTacToeWinner(List<List<Integer>> moves, int n) {
        // OPTIMIZED WAY
        int[] rowSum = new int[3];
        int[] colSum = new int[3];
        int[] diagonalSum = new int[2];
        int i = 0;
        while (i < n) {
            int curMove;
            List<Integer> move = moves.get(i);
            int row = move.get(0);
            int col = move.get(1);
            if (i % 2 == 0) {
                curMove = 1;
            } else {
                curMove = 4;
            }
            rowSum[row] += curMove;
            colSum[col] += curMove;
            if (row == col) {
                diagonalSum[0] += curMove;
            }
            if (row == (2 - col)) {
                diagonalSum[1] += curMove;
            }
            if (rowSum[row] == 3 || colSum[col] == 3 || diagonalSum[0] == 3 || diagonalSum[1] == 3) {
                return RESULT.PLAYER_1.name();
            }
            if (rowSum[row] == 12 || colSum[col] == 12 || diagonalSum[0] == 12 || diagonalSum[1] == 12) {
                return RESULT.PLAYER_2.name();
            }
            i++;
        }
        if (i == 9) {
            return RESULT.DRAW.name();
        } else {
            return RESULT.UNCERTAIN.name();
        }
    }

    public static String ticTacToeWinner(int[][] moves, int n) {
        char[][] ticTacToe = new char[3][3];
        for (int i = 0; i < n; i++) {
            int[] move = moves[i];
            char cross = i % 2 == 0 ? X : O;
            int row = move[0];
            int col = move[1];
            ticTacToe[row][col] = cross;
        }
        printAsArray("THE TIC TAC TOE BOX:", ticTacToe);
        return checkTheWinner(ticTacToe);
    }

    private static String checkTheWinner(char[][] ticTacToe) {
        int dRI = 0;
        int dRJ = 2;
        int dLX = 0;
        int dLO = 0;
        int dRX = 0;
        int dRO = 0;
        boolean isEmptyThere = false;
        for (int i = 0; i < 3; i++) {
            int rowXTrack = 0;
            int colXTrack = 0;
            int rowOTrack = 0;
            int colOTrack = 0;
            for (int j = 0; j < 3; j++) {
                if (ticTacToe[i][j] == X) {
                    rowXTrack++;
                }
                if (ticTacToe[i][j] == O) {
                    rowOTrack++;
                }
                if (ticTacToe[j][i] == X) {
                    colXTrack++;
                }
                if (ticTacToe[j][i] == O) {
                    colOTrack++;
                }
                if (i == j) {
                    if (ticTacToe[j][i] == X) {
                        dLX++;
                    }
                    if (ticTacToe[j][i] == O) {
                        dLO++;
                    }
                }
                if (i == dRI && j == dRJ) {
                    if (ticTacToe[j][i] == X) {
                        dRX++;
                    }
                    if (ticTacToe[j][i] == O) {
                        dRO++;
                    }
                    dRI++;
                    dRJ--;
                }
                if (ticTacToe[i][j] == '\u0000') {
                    isEmptyThere = true;
                }
            }
            if (colXTrack == 3 || rowXTrack == 3) {
                return RESULT.PLAYER_1.name();
            }
            if (colOTrack == 3 || rowOTrack == 3) {
                return RESULT.PLAYER_2.name();
            }
        }
        if (dLX == 3 || dRX == 3) {
            return RESULT.PLAYER_1.name();
        }
        if (dLO == 3 || dRO == 3) {
            return RESULT.PLAYER_1.name();
        }
        return isEmptyThere ? RESULT.UNCERTAIN.name() : RESULT.DRAW.name();
    }


    private enum RESULT {
        PLAYER_1,
        PLAYER_2,
        DRAW,
        UNCERTAIN
    }
}
