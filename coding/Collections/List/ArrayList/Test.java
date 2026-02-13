import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(2);

        // System.out.println(list.get(0)); // 1
        // System.out.println(list.size());
        // System.out.println(list.contains(2));
        // System.out.println(list.indexOf(2));
        // System.out.println(list.lastIndexOf(2));

        // List<String> list = new ArrayList<>();
        // list.add("A");
        // list.add("B");
        // list.add("A");
        // list.add("C");

        // System.out.println(list);

        // List<String> fruits = Arrays.asList("Apple", "Banana", "Orange", "Mango");
        // System.out.println(fruits);
        // //fruits.add("apple"); // java.lang.UnsupportedOperationException
        // fruits.set(1, "Cherry");
        // System.out.println(fruits);

        // List<String> numbers = List.of("One", "Two", "Three", "Four");
        // System.out.println(numbers);
        // //numbers.add("One"); // java.lang.UnsupportedOperationException

        // int[] arr = {1, 2, 3};
        // List<int[]> list = Arrays.asList(arr);
        // System.out.println(list); // create the List containing one element (the entire array)

        Integer[] arr = {1, 2, 3};
        List<Integer> list = Arrays.asList(arr);
        System.out.println(list); 
    }
}
