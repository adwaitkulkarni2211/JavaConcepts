package solid;

public class LiskovSubstitution {
    // Violation of Liskov substitution
    class BadVehicle {
        public void startEngine() {
            // Engine starting logic
        }
    }

    class BadCar extends BadVehicle {
        @Override public void startEngine() {
            // Car-specific engine starting logic
        }
    }

    class BadBicycle extends BadVehicle {
        @Override public void startEngine() {
            // Problem: Bicycles don't have engines!
            throw new UnsupportedOperationException("Bicycles don't have engines");
        }
    }

    // Better approach following LSP
    abstract class Vehicle {
        // Common vehicle behaviors
        public void move() {
            // Movement logic
        }
    }

    abstract class EngineVehicle extends Vehicle {
        public void startEngine() {
            // Engine starting logic
        }
    }

    abstract class NonEngineVehicle extends Vehicle {
        // No engine-related methods
    }

    class Car extends EngineVehicle {
        @Override public void startEngine() {
            // Car-specific engine starting logic
        }
    }

    class Bicycle extends NonEngineVehicle {
        // Bicycle-specific methods
        // No need to implement engine-related methods
    }
}
