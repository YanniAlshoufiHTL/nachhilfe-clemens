public class Main {
    public static void main(String[] args) {
        var timeSubject = new TimeSubject();
        timeSubject.addListener(() -> {
            System.out.printf(
                "%d:%d:%d%n",
                timeSubject.getHours(),
                timeSubject.getMinutes(),
                timeSubject.getSeconds()
            );
        });
        timeSubject.addListener(() -> {
            System.err.printf(
                "%d:%d:%d%n",
                timeSubject.getHours(),
                timeSubject.getMinutes(),
                timeSubject.getSeconds()
            );
        });
    }
}
