import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class trainConsistManagementAppTest {

    // Helper method to create bogie list
    private List<trainConsistManagementApp.Bogie> createBogies() {
        List<trainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new trainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new trainConsistManagementApp.Bogie("AC Chair", 56));
        bogies.add(new trainConsistManagementApp.Bogie("First Class", 24));
        bogies.add(new trainConsistManagementApp.Bogie("Sleeper", 80));
        bogies.add(new trainConsistManagementApp.Bogie("AC Chair", 60));

        return bogies;
    }

    // Grouping method (same logic as main)
    private Map<String, List<trainConsistManagementApp.Bogie>> groupBogies(
            List<trainConsistManagementApp.Bogie> bogies) {

        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        Map<String, List<trainConsistManagementApp.Bogie>> result = groupBogies(createBogies());

        assertTrue(result.get("Sleeper").size() >= 1);
        assertTrue(result.get("AC Chair").size() >= 1);
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        Map<String, List<trainConsistManagementApp.Bogie>> result = groupBogies(createBogies());

        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        Map<String, List<trainConsistManagementApp.Bogie>> result = groupBogies(createBogies());

        assertEquals(3, result.keySet().size());
    }

    @Test
    void testGrouping_EmptyBogieList() {
        Map<String, List<trainConsistManagementApp.Bogie>> result = groupBogies(new ArrayList<>());

        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<trainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new trainConsistManagementApp.Bogie("Sleeper", 70));
        bogies.add(new trainConsistManagementApp.Bogie("Sleeper", 80));

        Map<String, List<trainConsistManagementApp.Bogie>> result = groupBogies(bogies);

        assertEquals(1, result.keySet().size());
        assertTrue(result.containsKey("Sleeper"));
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        Map<String, List<trainConsistManagementApp.Bogie>> result = groupBogies(createBogies());

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        Map<String, List<trainConsistManagementApp.Bogie>> result = groupBogies(createBogies());

        assertEquals(2, result.get("Sleeper").size());
        assertEquals(2, result.get("AC Chair").size());
        assertEquals(1, result.get("First Class").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<trainConsistManagementApp.Bogie> original = createBogies();
        List<trainConsistManagementApp.Bogie> copy = new ArrayList<>(original);

        groupBogies(original);

        assertEquals(copy.size(), original.size());
        for (int i = 0; i < original.size(); i++) {
            assertEquals(copy.get(i).name, original.get(i).name);
            assertEquals(copy.get(i).capacity, original.get(i).capacity);
        }
    }
}