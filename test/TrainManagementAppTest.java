import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainManagementAppTest {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] arr = {};

        Exception exception = assertThrows(
                IllegalStateException.class,
                () -> TrainManagementApp.binarySearch(arr, "BG101")
        );

        assertEquals("Cannot perform search: Train has no bogies.", exception.getMessage());
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] arr = {"BG101", "BG205"};

        assertDoesNotThrow(() -> {
            TrainManagementApp.binarySearch(arr, "BG101");
        });
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] arr = {"BG101","BG205","BG309"};

        boolean result = TrainManagementApp.binarySearch(arr, "BG205");

        assertTrue(result);
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] arr = {"BG101","BG205","BG309"};

        boolean result = TrainManagementApp.binarySearch(arr, "BG999");

        assertFalse(result);
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] arr = {"BG101"};

        boolean result = TrainManagementApp.binarySearch(arr, "BG101");

        assertTrue(result);
    }
}