public class Test3 {
    public static void main(String[] args) throws Exception {

        Thread t = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {}
        });

        System.out.println(t.getState());  // NEW

        t.start();
        System.out.println(t.getState());  // RUNNABLE

        Thread.sleep(100);
        System.out.println(t.getState());  // TIMED_WAITING

        t.join();
        System.out.println(t.getState());  // TERMINATED
    }
}