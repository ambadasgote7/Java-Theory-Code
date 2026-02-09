package coding.OOPS_5;

abstract class Bird {
    public abstract void fly();
    public abstract void eat();
}

class Sparrow extends Bird {
    public void fly() {
        System.out.println("Sparrow fly @short height");
    }
    public void eat() {
        System.out.println("Sparrow eat grains....");
    }
}

abstract class Eagle extends Bird {
    public void fly() {
        System.out.println("Eagle fly @long height");
    }
    public abstract void eat();
}

class SerpentEagle extends Eagle {
    public void eat() {
        System.out.println("Serpent Eagle eat snakes....");
    }
}

class GoldenEagle extends Eagle {
    public void eat() {
        System.out.println("Golden Eagle eat fish....");
    }
}

class Crow extends Bird {
    public void fly() {
        System.out.println("Crow fly @medium height");
    }
    public void eat() {
        System.out.println("Crow eat insects....");
    }
}

abstract class BirdApp {
    // No methods are declared in abstract class
    // Abstract class can contain the concrete methods as well as abstract methods and even no methods
}

class Sky {
    public void allowBird(Bird ref) {
        ref.fly();
        ref.eat();
        System.out.println();
    }
}
public class Test2 {
    public static void main(String[] args) {
        Sky s = new Sky();
        s.allowBird(new Sparrow());
        s.allowBird(new SerpentEagle());
        s.allowBird(new GoldenEagle());
        s.allowBird(new Crow());
    }
}
