package coding;
class Parent {
    int x = 10;
    String surname;
    int money;
    Parent(String surname, int money) {
        this.surname = surname;
        this.money = money;
    }
    void show() {
        System.out.println(surname);
        System.out.println(money);
    }
}
class Child extends Parent {
    int x = 1000;
    String name = "Ambadas";
    Child() {
        super("Gote", 2000);
        System.out.println(super.x);
        System.out.println(x);
    }

    void show() {
        System.out.println(name);
        super.show();
    }
}
public class superKeyword {
    public static void main(String[] args) {
        Child c = new Child();
        c.show();
    }
}
