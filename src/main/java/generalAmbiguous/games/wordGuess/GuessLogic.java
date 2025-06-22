package generalAmbiguous.games.wordGuess;

import helperUtil.ClassUtils.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuessLogic {

    private final List<List<Character>> alphabets = new ArrayList<>();
    private final Map<Integer, Position> positionByLetterPlace = new HashMap<>();

    private int row = 0;
    private int column = 0;

    public GuessLogic() {
        int A = 65;
        int Z = A + 25;
        while (A <= Z) {
            List<Character> letters = new ArrayList<>();
            for (int i = 1; i <= 5; i++) {
                letters.add((char) A);
                A++;
                if (A > Z) {
                    break;
                }
            }
            alphabets.add(letters);
        }
    }

    private void incrementRowOrColumn(boolean isRow) {
        if (isRow) {
            row++;
        } else {
            column++;
        }
    }

    private void checkAndModifyRowAndColumn() {
        if (row >= 6) {
            row = 0;
        }
        if (column >= 6) {
            column = 0;
        }
    }

    public List<Character> getRowOrColumn(boolean isRow) {
        checkAndModifyRowAndColumn();
        if (isRow) {
            return alphabets.get(row);
        } else {
            List<Character> columns = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                try {
                    char c = alphabets.get(i).get(column);
                    columns.add(c);
                } catch (Exception ignored) {
                }
            }
            return columns;
        }
    }

    public void setPositionByLetterPlace(boolean isThere, boolean isRow, int letterPlace) {
        if (isThere) {
            if (isRow) {
                positionByLetterPlace.computeIfAbsent(letterPlace, k -> new Position()).setX(row);
                row = 0;
            } else {
                positionByLetterPlace.get(letterPlace).setY(column);
                column = 0;
            }
        } else {
            incrementRowOrColumn(isRow);
        }
    }

    public String guessTheWord() {
        StringBuilder word = new StringBuilder();
        positionByLetterPlace.forEach((k, v) -> {
            char c = alphabets.get(v.getX()).get(v.getY());
            word.append(c);
        });
        return word.toString();
    }

    public void display() {
        alphabets.forEach(System.out::println);
    }

}