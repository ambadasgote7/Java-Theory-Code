// Case5:In case of methodoverloading,compiler will bind the method call based on the
// reference type but not on the runtime object

class Animal {}
class Monkey extends Animal {}
class AnimalApp {
    public void m1(Animal a) {
        System.out.println("Animal");
    }
    public void m1(Monkey m) {
        System.out.println("Monkey");
    }
}

public class Test6 {
    public static void main(String[] args) {
        AnimalApp a = new AnimalApp();
        
        Animal animal = new Animal();
        a.m1(animal); // Animal
        Monkey monkey = new Monkey();
        a.m1(monkey); // Monkey

        // Complier will bind the method call based on the reference type but not on the runtime object
        Animal an = new Monkey();
        a.m1(an); // Animal

    }
}
