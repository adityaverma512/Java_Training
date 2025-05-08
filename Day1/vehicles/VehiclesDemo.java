package vehicles;

public class VehiclesDemo {

    public static void main(String[] args) {
        System.out.println("=== SIMPLE VEHICLE DEMO ===\n");

        // Create a Car and a Bike
        Vehicles car = new Car("Honda", "Civic", 2022, 4, "Manual");
        Vehicles bike = new Bike("Yamaha", "FZ", 2023, "Standard");

        // Start vehicles
        System.out.println(car.start());
        System.out.println(bike.start());

        // Accelerate both
        System.out.println(car.accelerate(20));
        System.out.println(bike.accelerate(25));

        // Apply brake
        System.out.println(car.brake());
        System.out.println(bike.brake());

        // Stop vehicles
        System.out.println(car.stop());
        System.out.println(bike.stop());

        // Print final state
        System.out.println("\nFinal States:");
        System.out.println("Car: " + car);
        System.out.println("Bike: " + bike);
    }
}
