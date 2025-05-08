package vehicles;

/**
 * Car class that extends AbstractVehicle.
 * This represents a specific type of vehicle with its own unique implementations
 * of abstract methods and additional car-specific features.
 */
public class Car extends AbstractVehicles {

    private final int numDoors;
    private final String transmissionType;

    /**
     * Constructor for Car class.
     *
     * @param make The manufacturer of the car
     * @param model The model name of the car
     * @param year The year the car was manufactured
     * @param numDoors Number of doors the car has
     * @param transmissionType Type of transmission (automatic, manual, etc.)
     */
    public Car(String make, String model, int year, int numDoors, String transmissionType) {
        super(make, model, year);
        this.numDoors = numDoors;
        this.transmissionType = transmissionType;
    }

    @Override
    public String accelerate(int amount) {
        if (!isRunning()) {
            return "Cannot accelerate: Engine is not running.";
        }

        // Calculate new speed considering the max speed
        int currentSpeed = getCurrentSpeed();
        int newSpeed = Math.min(currentSpeed + amount, getMaxSpeed());
        setCurrentSpeed(newSpeed);

        return "The car accelerates to " + newSpeed + " km/h.";
    }

    @Override
    public String brake() {
        int currentSpeed = getCurrentSpeed();

        if (currentSpeed == 0) {
            return "The car is already stopped.";
        }

        // Calculate braking effect - cars can brake quickly
        int reduction = Math.min(currentSpeed, 20);
        setCurrentSpeed(currentSpeed - reduction);

        return "The car slows down to " + getCurrentSpeed() + " km/h.";
    }

    @Override
    protected int getMaxSpeed() {
        return 220; // Most cars have a max speed of about 220 km/h
    }

    // Removed air conditioning related methods

    /**
     * Get the number of doors on the car.
     *
     * @return Number of doors
     */
    public int getNumDoors() {
        return numDoors;
    }

    /**
     * Get the transmission type of the car.
     *
     * @return Transmission type (automatic, manual, etc.)
     */
    public String getTransmissionType() {
        return transmissionType;
    }

    @Override
    public String toString() {
        return super.toString() + " | " + numDoors + "-door, " +
                transmissionType + " transmission";
    }
}