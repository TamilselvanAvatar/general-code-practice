package generalAmbiguous.games.bingo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static generalAmbiguous.ShuffleArray.shuffleArray;
import static helperUtil.StringUtils.BLANK;
import static helperUtil.StringUtils.EMPTY;

public class Bingo {

    private final static int BINGO_SIZE = 5;
    private final static StringBuilder BINGO = new StringBuilder("BINGO");
    private final List<List<BingoInner>> bingo = new ArrayList<>();

    @Setter
    private static boolean logger = false;

    @Setter
    private int totalRowAndColumCrossed = 0;

    public Bingo() {
        int size = getSquareBingoSize();
        Integer[] range = new Integer[size];
        IntStream.rangeClosed(1, size).forEach(i -> range[i - 1] = i);
        shuffleArray(range);
        setBingoArray(range);
    }

    public Bingo(Integer[] range) {
        setBingoArray(range);
    }

    private void setBingoArray(Integer[] range) {
        int size = getSquareBingoSize();
        if (range.length != size) {
            throw new RuntimeException("Size Should be " + size);
        }
        int k = 0;
        for (int i = 0; i < BINGO_SIZE; i++) {
            List<BingoInner> row = new ArrayList<>();
            for (int j = 0; j < BINGO_SIZE; j++) {
                BingoInner bingoInner = new BingoInner(range[k++], i, j, false);
                row.add(bingoInner);
            }
            bingo.add(row);
        }
    }

    private int getSquareBingoSize() {
        return BINGO_SIZE * BINGO_SIZE;
    }

    private void logInfo(String msg) {
        if (logger) {
            System.out.println(msg);
        }
    }

    private void incrementRowAndColumnCountIfValid(boolean canIncrement) {
        if (canIncrement) {
            ++totalRowAndColumCrossed;
        }
    }

    private boolean isCrossedPosition(int rowPosition, int columnPosition) {
        List<BingoInner> row = bingo.get(rowPosition);
        return row != null && row.get(columnPosition).isCrossed;
    }

    public void crossBingo(int element) {
        for (List<BingoInner> listBI : bingo) {
            for (BingoInner bi : listBI) {
                if (bi.value == element) {
                    bi.setCrossed(true);
                    break;
                }
            }
        }
    }

    public boolean isBingo() {
        setTotalRowAndColumCrossed(0);
        int ri = 0, rj = (BINGO_SIZE - 1);
        boolean isRightDiagonalCrossed = true;
        boolean isLeftDiagonalCrossed = true;
        for (int i = 0; i < BINGO_SIZE; i++) {
            StringBuilder row = new StringBuilder();
            StringBuilder column = new StringBuilder();
            boolean isCurrentRowCrossed = true;
            boolean isCurrentColumnCrossed = true;
            for (int j = 0; j < BINGO_SIZE; j++) {
                boolean isCrossedPosition = isCrossedPosition(i, j);
                isCurrentRowCrossed = isCurrentRowCrossed && isCrossedPosition;
                isCurrentColumnCrossed = isCurrentColumnCrossed && isCrossedPosition(j, i);
                if (i == j) {
                    isLeftDiagonalCrossed = isLeftDiagonalCrossed && isCrossedPosition;
                }
                if (i == ri && j == rj) {
                    isRightDiagonalCrossed = isRightDiagonalCrossed && isCrossedPosition;
                    ri++;
                    rj--;
                }
                row.append(i).append(j).append(BLANK);
                column.append(j).append(i).append(BLANK);
            }
            incrementRowAndColumnCountIfValid(isCurrentRowCrossed);
            incrementRowAndColumnCountIfValid(isCurrentColumnCrossed);
            logInfo(String.format("ROW %d : %b, COLUMN %d : %b", i, isCurrentRowCrossed, i, isCurrentColumnCrossed));
            logInfo(String.format("Left Diagonal : %b, Right Diagonal: %b", isLeftDiagonalCrossed, isRightDiagonalCrossed));
            logInfo(String.format("%-8s[%s]%n%-8s[%s]", "ROW", row, "COLUMN", column));
        }
        incrementRowAndColumnCountIfValid(isLeftDiagonalCrossed);
        incrementRowAndColumnCountIfValid(isRightDiagonalCrossed);
        return totalRowAndColumCrossed >= BINGO_SIZE;
    }

    public String getBingoState() {
        int size = totalRowAndColumCrossed >= BINGO_SIZE ? BINGO_SIZE : totalRowAndColumCrossed;
        return totalRowAndColumCrossed != 0 ? BINGO.substring(0, size) : EMPTY;
    }

    public void displayBingo() {
        bingo.forEach(System.out::println);
        logInfo("Bingo State: " + getBingoState());
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class BingoInner {
        private int value;
        private int x;
        private int y;
        private boolean isCrossed;

        @Override
        public String toString() {
            return String.format("%2d: %s", value, (isCrossed ? "X" : BLANK));
            // return String.format("%d%d %2d: %s", x, y, value, (isCrossed ? "X" : BLANK));
        }
    }

}
