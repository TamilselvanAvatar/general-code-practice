package generalAmbiguous.games.flames;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static helperUtil.StringUtils.notIntersectLetters;

public class Flames {

    public enum FlamesEnum {
        F("FRIENDS"),
        L("LOVE"),
        A("AFFECTION"),
        M("MARRIAGE"),
        E("ENEMY"),
        S("SISTER");

        private final String longForm;

        FlamesEnum(String longForm) {
            this.longForm = longForm;
        }

        @Override
        public String toString() {
            return longForm;
        }

    }

    public static void main(String[] args) {
        String maleName = "Selva";
        String femaleName = "Selvi";
        callFlames(maleName, femaleName);
    }

    private static void callFlames(String maleName, String femaleName) {
        String notIntersect = notIntersectLetters(maleName, femaleName);
        int count = notIntersect.length();
        FlamesEnum flamesEnum = getFlames(count);
        System.out.printf("Not Intersect Letters : `%s` And Counts : %d%n", notIntersect, count);
        System.out.printf("Flames between %s snd %s : %s", maleName, femaleName, flamesEnum);
    }

    public static FlamesEnum getFlames(int count) {
        StringBuilder sb = new StringBuilder("FLAMES");
        List<String> steps = new ArrayList<>();
        while (sb.length() != 1) {
            steps.add(String.valueOf(sb));
            int flamesLen = sb.length();
            int position = count % flamesLen;
            position = position == 0 ? flamesLen : position;
            String suffix = sb.substring(0, position - 1);
            String prefix = sb.substring(position);
            sb.delete(0, flamesLen);
            sb.append(prefix).append(suffix);
        }
        steps.add(String.valueOf(sb));
        AtomicInteger stepCount = new AtomicInteger(1);
        steps.forEach((str) -> System.out.printf("Step %d : %s%n", stepCount.getAndIncrement(), str));
        return FlamesEnum.valueOf(sb.toString());
    }

}
