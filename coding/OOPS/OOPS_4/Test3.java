package coding.OOPS_4;

class Animal {
    public void eat() {
        System.out.println("Eating...");
    }
    public void sleep() {
        System.out.println("Sleeping...");
    }
}

class Monkey extends Animal {
    public void eat() {
        System.out.println("Steals and eats...");
    }
    public void sleep() {
        System.out.println("Monkey is sleeping...");
    }
}

class Deer extends Animal {
    public void eat() {
        System.out.println("Graze and eats...");
    }
    public void sleep() {
        System.out.println("Deer is sleeping...");
    }
}

class Lion extends Animal {
    public void eat() {
        System.out.println("Hunts and eats...");
    }
    public void sleep() {
        System.out.println("Lion is sleeping...");
    }
}

class Forest {
    public void allowAnimal(Animal a) {
        a.eat();
        a.sleep();
        System.out.println();
    }
}
public class Test3 {
    public static void main(String[] args) {
        Forest f = new Forest();
        f.allowAnimal(new Monkey());
        f.allowAnimal(new Deer());  
        f.allowAnimal(new Lion());
    }
}
