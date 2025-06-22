package helperUtil;

import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;

@NoArgsConstructor
public class Timer {
    private LocalDateTime dateTime;

    private void clearTimer() {
        dateTime = null;
    }

    public void startTimer() {
        dateTime = LocalDateTime.now();
    }

    public long stopTimer() {
        if (dateTime == null) return -1L;
        LocalDateTime currentTime = LocalDateTime.now();
        Duration duration = Duration.between(dateTime, currentTime);
        clearTimer();
        return duration.toMillis();
    }

}
