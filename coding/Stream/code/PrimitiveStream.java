import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class PrimitiveStream {
    public static void main(String[] args) {
        // 1. By range()
        IntStream range = IntStream.range(1, 5);
        // range.forEach(System.out::println);

        // 2. From Array
        int[] arr = {1,2,3};
        IntStream stream = Arrays.stream(arr);
        // stream.forEach(System.out::println);

        // 3. Generate
        IntStream stream2 = IntStream.iterate(0, n -> n + 1)
                .limit(5);
        stream2.forEach(System.out::println);

        // 4. sum()
        int sum = IntStream.of(1,2,3).sum();
        System.out.println(sum);

        // 5. average()
        OptionalDouble avg = IntStream.of(1,2,3).asDoubleStream().average();
        System.out.println(avg);

        // 6. max()
        int max = IntStream.of(1,2,3).max().getAsInt();
        System.out.println(max);

        // 7. boxed()
        IntStream.range(1,5)
                .boxed();

    }
}
