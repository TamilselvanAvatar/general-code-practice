package helperUtil;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ClassUtils {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Position {
        private int x;
        private int y;

        @Override
        public String toString() {
            return String.format("%s%s", x, y);
        }
    }

}