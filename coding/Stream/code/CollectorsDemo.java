import java.util.List;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void main(String[] args) {
        // 1. toList()
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9);
        list.stream().collect(Collectors.toList());

        // 2. toSet()
        list.stream().collect(Collectors.toSet());

        // 3. joining()
        list.stream().map(String::valueOf).collect(Collectors.joining(","));

        // 4. counting()
        list.stream().collect(Collectors.counting());

        // 5. groupingBy()
        List<String> names = List.of("John", "Jane", "John", "Mary", "John");
        names.stream().collect(Collectors.groupingBy(String::length));

        // 6. partitioningBy()
        List<Integer> list2 = List.of(1,2,3,4,5,6,7,8,9);
        list2.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));

        // 7. mapping()
        List<Integer> list3 = List.of(1,2,3,4,5,6,7,8,9);
        list3.stream().collect(Collectors.groupingBy(
                x -> x % 2,
                Collectors.mapping(
                        x -> x * 2,
                        Collectors.toList()
                )
        ));

        // 8. toMap()
        List<Integer> list4 = List.of(1,2,3,4,5,6,7,8,9);
        list4.stream().collect(Collectors.toMap(
                x -> x,
                x -> "Value" + x
        ));

        // 9 . mapping and collecting
        List<Integer> list5 = List.of(1,2,3,4,5,6,7,8,9);
        list5.stream().collect(Collectors.mapping(
                x -> x * 2,
                Collectors.toList()
        ));

        
    }
}
