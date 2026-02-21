import java.util.stream.Stream;

public class ParallelStream {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Stream.iterate(1, x -> x + 1)
                .limit(20000)
                .map(x -> factorial(x))
                .toList();   // terminal operation

        long end = System.currentTimeMillis();

        System.out.println("Sequential Time: " +
                (end - start) + " ms");


        start = System.currentTimeMillis();

        Stream.iterate(1, x -> x + 1)
                .limit(20000)
                .parallel()
                .map(x -> factorial(x))
                .toList();

        end = System.currentTimeMillis();

        System.out.println("Parallel Time: " +
                (end - start) + " ms");
    }

    static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}