public class Main {
    public static void main(String[] args) {
        var timeSubject = new TimeSubject();
        timeSubject.addListener((hours, minutes, seconds) -> {
            System.out.printf(
                "%d:%d:%d%n",
                hours,
                minutes,
                seconds
            );
        });
        timeSubject.addListener((hours, minutes, seconds) -> {
            System.err.printf(
                "%d:%d:%d%n",
                hours,
                minutes,
                seconds
            );
        });

        timeSubject.addListener(new MyTimeSubjectListener());
    }

    private static class MyTimeSubjectListener implements ITimeSubjectListener {
        @Override
        public void provideTime(int hours, int minutes, int seconds) {
            System.out.printf("IMPORTANT: %d:%d:%d%n", hours, minutes, seconds);
        }
    }
}
