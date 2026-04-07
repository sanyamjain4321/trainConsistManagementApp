import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    // Helper method to validate safety (same logic as main)
    private boolean isSafe(List<TrainConsistManagementApp.GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(b -> {
                    if (b.type.equals("Cylindrical")) {
                        return b.cargo.equals("Petroleum");
                    }
                    return true;
                });
    }

    @Test
    void testSafety_AllBogiesValid() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new TrainConsistManagementApp.GoodsBogie("Open", "Coal"));
        bogies.add(new TrainConsistManagementApp.GoodsBogie("Box", "Grain"));

        assertTrue(isSafe(bogies));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Coal"));

        assertFalse(isSafe(bogies));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.GoodsBogie("Open", "Coal"));
        bogies.add(new TrainConsistManagementApp.GoodsBogie("Box", "Grain"));

        assertTrue(isSafe(bogies));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Coal")); // violation
        bogies.add(new TrainConsistManagementApp.GoodsBogie("Open", "Grain"));

        assertFalse(isSafe(bogies));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = new ArrayList<>();

        assertTrue(isSafe(bogies)); // allMatch returns true for empty list
    }
}