import java.util.EnumMap;

public class EnumMapDemo {
    public static void main(String[] args) {
        EnumMap<Day, String> map = new EnumMap<>(Day.class);
        map.put(Day.MONDAY, "Work");
        map.put(Day.TUESDAY, "Gym");
        map.put(Day.WEDNESDAY, "Study");
        System.out.println(map);
    }
}

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
