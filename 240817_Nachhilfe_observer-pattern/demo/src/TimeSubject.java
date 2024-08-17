import javax.swing.plaf.IconUIResource;
import java.time.LocalDateTime;
import java.util.*;

public class TimeSubject {
    private final List<Runnable> listeners = new LinkedList<>();

    private int seconds;
    private int minutes;
    private int hours;

    public TimeSubject() {
        updateTime();
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateTime();
            }
        }, 0, 500);
    }

    private void updateTime() {
        var dateTime = LocalDateTime.now();

        this.seconds = dateTime.getSecond();
        this.minutes = dateTime.getMinute();
        this.hours = dateTime.getHour();

        fireAll();
    }

    private void fireAll() {
        for (var listener : listeners) {
            listener.run();
        }
    }

    public void addListener(Runnable listener) {
        if (listener == null) {
            throw new IllegalArgumentException("Listener must not be null!");
        }

        listeners.add(listener);
    }

    public List<Runnable> getListeners() {
        return listeners;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
