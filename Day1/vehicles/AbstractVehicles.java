package vehicles;

/**
 * AbstractVehicle provides a base implementation for the Vehicle interface.
 * This abstract class implements common functionality and maintains state that all vehicles share,
 * while leaving vehicle-specific behavior to be implemented by concrete subclasses.
 */
public abstract class AbstractVehicles implements Vehicles {

    // Encapsulated fields - private to protect direct access
    private String make;
    private String model;
    private int year;
    private int currentSpeed;
    private boolean isRunning;

    /**
     * Constructor for the AbstractVehicle.
     *
     * @param make The manufacturer of the vehicle
     * @param model The model name of the vehicle
     * @param year The year the vehicle was manufactured
     */
    public AbstractVehicles(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.currentSpeed = 0;
        this.isRunning = false;
    }

    @Override
    public String start() {
        if (!isRunning) {
            isRunning = true;
            return "The " + make + " " + model + " has started.";
        } else if (isRunning) {
            return "The vehicle is already running.";
        } else {
            return "Unable to start: No fuel!";
        }
    }

    @Override
    public String stop() {
        if (isRunning) {
            isRunning = false;
            currentSpeed = 0;
            return "The " + make + " " + model + " has stopped.";
        } else {
            return "The vehicle is already stopped.";
        }
    }

    @Override
    public int getCurrentSpeed() {
        return currentSpeed;
    }

    protected void setCurrentSpeed(int speed) {
        if (speed >= 0) {
            this.currentSpeed = speed;
        }
    }
    protected boolean isRunning() {
        return isRunning;
    }

    protected abstract int getMaxSpeed();

    @Override
    public String toString() {
        return year + " " + make + " " + model +
                " (Speed: " + currentSpeed + " km/h)";
    }

    // Getters for encapsulated fields
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

}
