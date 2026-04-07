import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    @Test
    void testException_ValidCapacityCreation() {
        assertDoesNotThrow(() -> {
            new TrainConsistManagementApp.PassengerBogie("Sleeper", 72);
        });
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception exception = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.PassengerBogie("AC Chair", -10)
        );

        assertNotNull(exception);
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        Exception exception = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.PassengerBogie("Sleeper", 0)
        );

        assertNotNull(exception);
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Exception exception = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.PassengerBogie("Sleeper", -5)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws Exception {
        TrainConsistManagementApp.PassengerBogie bogie =
                new TrainConsistManagementApp.PassengerBogie("Sleeper", 72);

        assertEquals("Sleeper", bogie.type);
        assertEquals(72, bogie.capacity);
    }

    @Test
    void testException_MultipleValidBogiesCreation() {
        assertDoesNotThrow(() -> {
            new TrainConsistManagementApp.PassengerBogie("Sleeper", 72);
            new TrainConsistManagementApp.PassengerBogie("AC Chair", 56);
            new TrainConsistManagementApp.PassengerBogie("First Class", 24);
        });
    }
}