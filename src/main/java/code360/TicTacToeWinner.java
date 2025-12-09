package code360;

import static helperUtil.Printer.printAsArray;

public class TicTacToeWinner {
    public static void main(String[] args) {

    }
    
    private static final char X = 'X';
    private static final char O = 'O';

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
