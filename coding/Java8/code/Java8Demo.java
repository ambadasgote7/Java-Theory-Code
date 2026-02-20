import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.lang.Math;

public class Java8Demo {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("Hello");
        });
        t.start();

        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println(isEven.test(10));

        Function<Integer, Integer> square = x -> x * x;
        System.out.println(square.apply(5));

        Consumer<Integer> print = x -> System.out.println(x);
        print.accept(10);

        Supplier<Double> random = () -> Math.random();
        System.out.println(random.get());

        Consumer<String> print2 = System.out::println;
        print2.accept("Hello");

        List<String> list = List.of("A", "B");
        Supplier<ArrayList<String>> supplier = ArrayList::new;
        list.forEach(System.out::println);

        BiPredicate<Integer, Integer> isGreater = (a, b) -> a > b;
        System.out.println(isGreater.test(10, 5));

        BiConsumer<String, Integer> print3 = (name, age) -> System.out.println(name + " " + age);
        print3.accept("John", 25);

        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        System.out.println(sum.apply(5, 3));

        UnaryOperator<Integer> square2 = x -> x * x;
        System.out.println(square2.apply(5));

        BinaryOperator<Integer> sum2 = (a, b) -> a + b;
        System.out.println(sum2.apply(10, 20));
    }
}