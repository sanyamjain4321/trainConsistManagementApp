import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TrainManagementAppTest {

    @Test
    void testBinarySearch_BogieFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        boolean result = TrainManagementApp.binarySearch(arr, "BG309");

        assertTrue(result);
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        boolean result = TrainManagementApp.binarySearch(arr, "BG999");

        assertFalse(result);
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        boolean result = TrainManagementApp.binarySearch(arr, "BG101");

        assertTrue(result);
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        boolean result = TrainManagementApp.binarySearch(arr, "BG550");

        assertTrue(result);
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        String[] arr = {"BG101"};

        boolean result = TrainManagementApp.binarySearch(arr, "BG101");

        assertTrue(result);
    }

    @Test
    void testBinarySearch_EmptyArray() {
        String[] arr = {};

        boolean result = TrainManagementApp.binarySearch(arr, "BG101");

        assertFalse(result);
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        String[] arr = {"BG309","BG101","BG550","BG205","BG412"};

        // Sort before binary search (required)
        Arrays.sort(arr);

        boolean result = TrainManagementApp.binarySearch(arr, "BG205");

        assertTrue(result);
    }
}