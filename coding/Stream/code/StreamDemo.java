import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {

        // 1. From Collection
        List<Integer> list = List.of(1,2,3,4,5);
        list.stream();

        // 2. From Array
        int[] arr = {1,2,3,4,5};
        Arrays.stream(arr);

        // 3. Using Stream.of()
        Stream<Integer> stream = Stream.of(1,2,3,4,5);

        // 4. Using Stream Builder
        Stream<Integer> stream2 = Stream.<Integer>builder().add(1).add(2).build();

        // 5. Infinite Stream
        Stream<Integer> stream3 = Stream.generate(() -> 1).limit(100);
        Stream<Integer> stream4 = Stream.iterate(0, n -> n + 1).limit(5);
    }
}
