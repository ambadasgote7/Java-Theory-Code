package coding.Stream.code;

import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperations {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7);
        
        // 1. filter()
        stream.filter(x -> x % 2 == 0);

        // 2. map()
        stream.map(x -> x * x);

        // 3.sorted()
        stream.sorted();

        // 4. distinct()
        stream.distinct();

        // 5. limit()
        stream.limit(5);

        // 6. skip()
        stream.skip(2);

        // 7. flatMap()
        List<List<Integer>> list = List.of(List.of(1,2), List.of(3,4), List.of(5,6));
        list.stream().flatMap(List::stream);
    }
}
