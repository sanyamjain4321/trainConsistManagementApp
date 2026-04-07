import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TrainManagementAppTest {

    // Helper to capture console output
    private String captureOutput(Runnable task) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(output));

        task.run();

        System.setOut(original);
        return output.toString();
    }

    @Test
    void testCargo_SafeAssignment() {
        GoodsBogie bogie = new GoodsBogie("Cylindrical");

        String output = captureOutput(() -> bogie.assignCargo("Petroleum"));

        assertTrue(output.contains("Cargo assigned successfully"));
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        String output = captureOutput(() -> bogie.assignCargo("Petroleum"));

        assertTrue(output.contains("Exception Caught"));
        assertTrue(output.contains("Unsafe"));
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        String output = captureOutput(() -> bogie.display());

        assertTrue(output.contains("Cargo: None"));
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        GoodsBogie bogie1 = new GoodsBogie("Rectangular");
        GoodsBogie bogie2 = new GoodsBogie("Rectangular");

        // First call throws internally but is handled
        bogie1.assignCargo("Petroleum");

        // Program should continue normally
        assertDoesNotThrow(() -> bogie2.assignCargo("Coal"));
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        String output = captureOutput(() -> bogie.assignCargo("Petroleum"));

        assertTrue(output.contains("Validation completed"));
    }
}