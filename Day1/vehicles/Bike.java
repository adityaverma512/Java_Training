package vehicles;

/**
 * Bike class that extends AbstractVehicle.
 * This represents a motorcycle with unique implementations
 * for the abstract methods and bike-specific features.
 */
public class Bike extends AbstractVehicles {

    private final String bikeType; // e.g., "Sport", "Cruiser", "Touring"
    private boolean standDown;     // Kickstand status

    /**
     * Constructor for Bike class.
     *
     * @param make The manufacturer of the bike
     * @param model The model name of the bike
     * @param year The year the bike was manufactured
     * @param bikeType The type of motorcycle
     */
    public Bike(String make, String model, int year, String bikeType) {
        super(make, model, year);
        this.bikeType = bikeType;
        this.standDown = true; // Kickstand starts down when bike is parked
    }

    @Override
    public String start() {
        if (standDown) {
            return "Cannot start: Please raise the kickstand first.";
        }
        return super.start();
    }

    @Override
    public String accelerate(int amount) {
        if (!isRunning()) {
            return "Cannot accelerate: Engine is not running.";
        }

        // Bikes accelerate faster than cars
        int currentSpeed = getCurrentSpeed();
        int effectiveAmount = (int)(amount * 1.5); // Bikes accelerate faster
        int newSpeed = Math.min(currentSpeed + effectiveAmount, getMaxSpeed());
        setCurrentSpeed(newSpeed);

        return "The motorcycle accelerates rapidly to " + newSpeed + " km/h.";
    }

    @Override
    public String brake() {
        int currentSpeed = getCurrentSpeed();

        if (currentSpeed == 0) {
            return "The motorcycle is already stopped.";
        }

        // Calculate braking effect - bikes can brake harder than cars
        int reduction = Math.min(currentSpeed, 25);
        setCurrentSpeed(currentSpeed - reduction);

        return "The motorcycle slows down to " + getCurrentSpeed() + " km/h.";
    }

    @Override
    protected int getMaxSpeed() {
        // Sport bikes are faster than regular cars
        if (bikeType.equalsIgnoreCase("Sport")) {
            return 300;
        } else if (bikeType.equalsIgnoreCase("Cruiser")) {
            return 180;
        } else {
            return 220; // Default for other types
        }
    }

    /**
     * Set the kickstand status.
     *
     * @param down true to put the kickstand down, false to raise it
     * @return Status message about the kickstand
     */
    public String setKickstand(boolean down) {
        if (getCurrentSpeed() > 0 && down) {
            return "Cannot lower kickstand while moving!";
        }

        this.standDown = down;

        if (down) {
            // Stop the engine if kickstand is down
            if (isRunning()) {
                super.stop();
                return "Kickstand down. Engine stopped for safety.";
            }
            return "Kickstand down.";
        } else {
            return "Kickstand up.";
        }
    }

    /**
     * Check if the kickstand is down.
     *
     * @return true if the kickstand is down, false otherwise
     */
    public boolean isStandDown() {
        return standDown;
    }

    /**
     * Get the type of motorcycle.
     *
     * @return Bike type (Sport, Cruiser, etc.)
     */
    public String getBikeType() {
        return bikeType;
    }

    @Override
    public String toString() {
        return super.toString() + " | " + bikeType + " motorcycle" +
                (standDown ? " (Kickstand DOWN)" : " (Kickstand UP)");
    }
}