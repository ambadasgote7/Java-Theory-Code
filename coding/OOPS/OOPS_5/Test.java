package coding.OOPS_5;

abstract class Plane {
    public abstract void fly();
    public abstract void land();
}

class PassengerPlane extends Plane {
    public void fly() {
        System.out.println("Passenger Plane is Flying");
    }
    public void land() {
        System.out.println("Passenger Plane is Landing");
    }
}

class CargoPlane extends Plane {
    public void fly() {
        System.out.println("Cargo Plane is Flying");
    }
    public void land() {
        System.out.println("Cargo Plane is Landing");
    }
}

class FighterPlane extends Plane {
    public void fly() {
        System.out.println("Fighter Plane is Flying");
    }
    public void land() {
        System.out.println("Fighter Plane is Landing");
    }
}

class Airport {
    // We can give the reference of the abstract class
    public void allowPlane(Plane ref) {
        ref.fly();
        ref.land();
        System.out.println();
    }
}
public class Test {
    public static void main(String[] args) {

       // Plane p = new Plane(); // Cannot instantiate the type Plane
        Airport a = new Airport();
        a.allowPlane(new PassengerPlane());
        a.allowPlane(new CargoPlane()); 
        a.allowPlane(new FighterPlane());
    }
}
