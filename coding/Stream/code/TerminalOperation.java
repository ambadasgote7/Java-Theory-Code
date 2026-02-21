
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class TerminalOperation {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7);
        List<Integer> list = new ArrayList<>();

        // 1. forEach()
        // stream.forEach(System.out::print);

        // 2. collect
        // stream.map(x -> x * x).collect(Collectors.toList()).forEach(System.out::println);

        // 3. count()
        // System.out.println(stream.count());

        // 4. findFirst()
        // System.out.println(stream.findFirst().get());
        // System.out.println(list.stream().findFirst());

        // 5. reduce()
        // int sum = stream.reduce(0, (a, b) -> a + b);
        // System.out.println(sum);

        // 6. anyMatch()
        boolean result = stream.anyMatch(x -> x > 10);
        System.out.println(result);

        // 7. allMatch()
        result = stream.allMatch(x -> x > 10);
        System.out.println(result);

        // 8. noneMatch()
        result = stream.noneMatch(x -> x > 10);
        System.out.println(result); 

+














































    }
}