import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class trainConsistManagementAppTest {

    // Helper method to create bogies
    private List<trainConsistManagementApp.Bogie> createBogies() {
        List<trainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new trainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new trainConsistManagementApp.Bogie("AC Chair", 56));
        bogies.add(new trainConsistManagementApp.Bogie("First Class", 24));
        bogies.add(new trainConsistManagementApp.Bogie("Sleeper", 70));

        return bogies;
    }

    // Same logic as main (map + reduce)
    private int calculateTotalSeats(List<trainConsistManagementApp.Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        int total = calculateTotalSeats(createBogies());

        assertEquals(72 + 56 + 24 + 70, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        int total = calculateTotalSeats(createBogies());

        assertTrue(total > 0);
        assertEquals(222, total);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<trainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new trainConsistManagementApp.Bogie("Sleeper", 80));

        int total = calculateTotalSeats(bogies);

        assertEquals(80, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        int total = calculateTotalSeats(new ArrayList<>());

        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<trainConsistManagementApp.Bogie> bogies = createBogies();

        List<Integer> capacities = bogies.stream()
                .map(b -> b.capacity)
                .toList();

        assertTrue(capacities.contains(72));
        assertTrue(capacities.contains(56));
        assertTrue(capacities.contains(24));
        assertTrue(capacities.contains(70));
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<trainConsistManagementApp.Bogie> bogies = createBogies();

        int total = calculateTotalSeats(bogies);

        int manualSum = 0;
        for (trainConsistManagementApp.Bogie b : bogies) {
            manualSum += b.capacity;
        }

        assertEquals(manualSum, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<trainConsistManagementApp.Bogie> original = createBogies();
        List<trainConsistManagementApp.Bogie> copy = new ArrayList<>(original);

        calculateTotalSeats(original);

        assertEquals(copy.size(), original.size());
        for (int i = 0; i < original.size(); i++) {
            assertEquals(copy.get(i).name, original.get(i).name);
            assertEquals(copy.get(i).capacity, original.get(i).capacity);
        }
    }
}