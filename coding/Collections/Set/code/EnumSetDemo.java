import java.util.EnumSet;
import java.util.Set;

public class EnumSetDemo {
    public static void main(String[] args) {
        // EnumSet<Day> set = EnumSet.allOf(Day.class);
        // System.out.println(set);
        EnumSet<Day> set = EnumSet.of(Day.Monday, Day.Wednesday);
        System.out.println(set);
        EnumSet<Day> set2 = EnumSet.noneOf(Day.class);
        System.out.println(set2);
        EnumSet<Day> set3 = EnumSet.range(Day.Monday, Day.Wednesday);
        System.out.println(set3);
        
    }
}

enum Day {
    Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
}
