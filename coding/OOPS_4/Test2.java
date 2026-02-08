package coding.OOPS_4;

class Plane {
    public void fly() {
        System.out.println("Plane is Flying");
    }
    public void land() {
        System.out.println("Plane is Landing");
    }
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

// Instead of multiple times calling the same methods we create the other class and that has single method which will handle by single call
class Airport {
    public void allowPlane(Plane p) {
        p.fly();
        p.land();
        System.out.println();
    }
}

public class Test2 {
    public static void main(String[] args) {
        // Plane p = null;
        // System.out.println();

        // p = new PassengerPlane();
        // p.fly();
        // p.land();

        // System.out.println();

        // p = new CargoPlane();
        // p.fly();
        // p.land();

        // System.out.println();

        // p = new FighterPlane();
        // p.fly();    
        // p.land();

        // Optimization
        Airport a = new Airport();
        a.allowPlane(new PassengerPlane());
        a.allowPlane(new CargoPlane());
        a.allowPlane(new FighterPlane());

    }
}
