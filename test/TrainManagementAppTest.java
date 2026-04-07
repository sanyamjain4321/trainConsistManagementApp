import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainManagementAppTest {

    @Test
    void testSearch_BogieFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        boolean result = TrainManagementApp.linearSearch(arr, "BG309");

        assertTrue(result);
    }

    @Test
    void testSearch_BogieNotFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        boolean result = TrainManagementApp.linearSearch(arr, "BG999");

        assertFalse(result);
    }

    @Test
    void testSearch_FirstElementMatch() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        boolean result = TrainManagementApp.linearSearch(arr, "BG101");

        assertTrue(result);
    }

    @Test
    void testSearch_LastElementMatch() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        boolean result = TrainManagementApp.linearSearch(arr, "BG550");

        assertTrue(result);
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] arr = {"BG101"};

        boolean result = TrainManagementApp.linearSearch(arr, "BG101");

        assertTrue(result);
    }
}