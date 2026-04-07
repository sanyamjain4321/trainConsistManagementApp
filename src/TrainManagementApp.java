// Custom Runtime Exception
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// Goods Bogie Class
class GoodsBogie {
    private String shape;
    private String cargo;

    public GoodsBogie(String shape) {
        this.shape = shape;
    }

    public void assignCargo(String cargoType) {
        try {
            System.out.println("\nAssigning " + cargoType + " to " + shape + " bogie...");

            // Unsafe condition
            if (shape.equalsIgnoreCase("Rectangular") &&
                    cargoType.equalsIgnoreCase("Petroleum")) {
                throw new CargoSafetyException("❌ Unsafe: Petroleum cannot be assigned to Rectangular bogie!");
            }

            // Safe assignment
            this.cargo = cargoType;
            System.out.println("✅ Cargo assigned successfully.");

        } catch (CargoSafetyException e) {
            System.out.println("Exception Caught: " + e.getMessage());

        } finally {
            System.out.println("✔ Validation completed (finally block executed)");
        }
    }

    public void display() {
        System.out.println("Bogie Shape: " + shape + " | Cargo: " + (cargo == null ? "None" : cargo));
    }
}

// Main Application Class
public class TrainManagementApp {
    public static void main(String[] args) {

        System.out.println("===== UC15: Safe Cargo Assignment =====");

        // Safe case
        GoodsBogie bogie1 = new GoodsBogie("Cylindrical");
        bogie1.assignCargo("Petroleum");  // ✅ Allowed
        bogie1.display();

        // Unsafe case
        GoodsBogie bogie2 = new GoodsBogie("Rectangular");
        bogie2.assignCargo("Petroleum");  // ❌ Exception
        bogie2.display();

        // Another safe case (program continues)
        GoodsBogie bogie3 = new GoodsBogie("Rectangular");
        bogie3.assignCargo("Coal");  // ✅ Allowed
        bogie3.display();

        System.out.println("\n🚆 Program continues successfully after exception...");
    }
}