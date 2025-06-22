package generalAmbiguous.games.bingo;

import helperUtil.ClassUtils.Position;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

import static generalAmbiguous.ShuffleArray.shuffleArray;
import static helperUtil.GeneralUtils.sumOfXNaturalNumber;
import static helperUtil.StringUtils.BLANK;
import static helperUtil.StringUtils.EMPTY;

public class Bingo {

    private final static int BINGO_SIZE = 5;
    private final static StringBuilder BINGO = new StringBuilder("BINGO");
    private final List<List<BingoInner>> bingo = new ArrayList<>();
    private final List<Position> positions = new ArrayList<>();

    private final List<Position> leftDiagonal = new ArrayList<>();
    private final List<Position> rightDiagonal = new ArrayList<>();
    private final List<Position> rowsAndColumn = new ArrayList<>();

    @Setter
    private static boolean logger = false;

    @Setter
    private boolean isComputer;

    @Setter
    private int totalRowAndColumCrossed = 0;

    private int isMinimumCrossReached = 0;

    public Bingo() {
        int size = getSquareBingoSize();
        Integer[] range = new Integer[size];
        IntStream.rangeClosed(1, size).forEach(i -> range[i - 1] = i);
        shuffleArray(range);
        setBingoArray(range);
    }

    public Bingo(boolean isComputer) {
        this();
        this.setComputer(isComputer);
    }

    public Bingo(Integer[] range) {
        setBingoArray(range);
    }

    private void setBingoArray(Integer[] range) {
        int size = getSquareBingoSize();
        if (range.length != size) {
            throw new RuntimeException("Size Should be " + size);
        }
        int k = 0, ri = 0, rj = BINGO_SIZE - 1;
        for (int i = 0; i < BINGO_SIZE; i++) {
            List<BingoInner> row = new ArrayList<>();
            for (int j = 0; j < BINGO_SIZE; j++) {
                BingoInner bingoInner = new BingoInner(range[k++], i, j, false);
                row.add(bingoInner);
                if (setComputerGuessCrossPositionAndIsRightDiagonal(i, j, ri, rj)) {
                    ri++;
                    rj--;
                }
            }
            bingo.add(row);
        }
        setComputerGuessPositions();
    }

    private boolean setComputerGuessCrossPositionAndIsRightDiagonal(int i, int j, int rightDiagonalRow, int rightDiagonalColumn) {
        if (i == j) {
            leftDiagonal.add(new Position(i, j));
        }
        if (i % 2 == 1 || j == 0) {
            rowsAndColumn.add(new Position(i, j));
        }
        if (rightDiagonalRow == i && rightDiagonalColumn == j) {
            rightDiagonal.add(new Position(i, j));
            return true; // if right diagonal
        }
        return false;
    }

    private void setComputerGuessPositions() {
        positions.addAll(leftDiagonal);
        positions.addAll(rightDiagonal);
        positions.addAll(rowsAndColumn);
    }

    private int getSquareBingoSize() {
        return BINGO_SIZE * BINGO_SIZE;
    }

    private boolean isEligibleForBingo() {
        return isMinimumCrossReached >= sumOfXNaturalNumber(BINGO_SIZE);
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

    private BingoInner getBingoInner(int rowPosition, int columnPosition) {
        List<BingoInner> row = bingo.get(rowPosition);
        return row.get(columnPosition);
    }


    private boolean isCrossedPosition(int rowPosition, int columnPosition) {
        return getBingoInner(rowPosition, columnPosition).isCrossed;
    }

    public void crossBingo(int element) {
        for (List<BingoInner> listBI : bingo) {
            for (BingoInner bi : listBI) {
                if (bi.value == element) {
                    bi.setCrossed(true);
                    ++isMinimumCrossReached;
                    break;
                }
            }
        }
    }

    public boolean isBingo() {
        if (!isEligibleForBingo()) {
            return false;
        }
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

    public int getNextCrossValue() {
        if (!isComputer) {
            return -1;
        }
        logInfo("Positions " + positions);
        Iterator<Position> positionIterator = positions.iterator();
        while (positionIterator.hasNext()) {
            Position position = positionIterator.next();
            BingoInner bingoInner = getBingoInner(position.getX(), position.getY());
            if (bingoInner.isCrossed) {
                positionIterator.remove();
                continue;
            }
            positionIterator.remove();
            return bingoInner.value;
        }
        for (List<BingoInner> listBI : bingo) {
            for (BingoInner bi : listBI) {
                if (bi.isCrossed) {
                    continue;
                }
                return bi.value;
            }
        }
        return -1;
    }

    @Getter
    @Setter
    public static class BingoInner extends Position {
        private int value;
        private boolean isCrossed;

        public BingoInner(int value, int x, int y, boolean isCrossed) {
            super(x, y);
            this.value = value;
            this.isCrossed = isCrossed;
        }

        @Override
        public String toString() {
            return String.format("%2d: %s", value, (isCrossed ? "X" : BLANK));
            // return String.format("%d%d %2d: %s", x, y, value, (isCrossed ? "X" : BLANK));
        }
    }

}