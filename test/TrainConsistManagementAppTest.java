import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    // Helper: create dataset
    private List<TrainConsistManagementApp.Bogie> createBogies(int size) {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", i % 100));
        }
        return bogies;
    }

    // Loop filtering
    private List<TrainConsistManagementApp.Bogie> loopFilter(List<TrainConsistManagementApp.Bogie> bogies) {
        List<TrainConsistManagementApp.Bogie> result = new ArrayList<>();
        for (TrainConsistManagementApp.Bogie b : bogies) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }
        return result;
    }

    // Stream filtering
    private List<TrainConsistManagementApp.Bogie> streamFilter(List<TrainConsistManagementApp.Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }

    @Test
    void testLoopFilteringLogic() {
        List<TrainConsistManagementApp.Bogie> bogies = createBogies(100);

        List<TrainConsistManagementApp.Bogie> result = loopFilter(bogies);

        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    void testStreamFilteringLogic() {
        List<TrainConsistManagementApp.Bogie> bogies = createBogies(100);

        List<TrainConsistManagementApp.Bogie> result = streamFilter(bogies);

        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<TrainConsistManagementApp.Bogie> bogies = createBogies(1000);

        List<TrainConsistManagementApp.Bogie> loopResult = loopFilter(bogies);
        List<TrainConsistManagementApp.Bogie> streamResult = streamFilter(bogies);

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<TrainConsistManagementApp.Bogie> bogies = createBogies(1000);

        long start = System.nanoTime();
        loopFilter(bogies);
        long end = System.nanoTime();

        long time = end - start;

        assertTrue(time > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<TrainConsistManagementApp.Bogie> bogies = createBogies(100000);

        List<TrainConsistManagementApp.Bogie> result = streamFilter(bogies);

        assertNotNull(result);
        assertTrue(result.size() > 0);
    }
}