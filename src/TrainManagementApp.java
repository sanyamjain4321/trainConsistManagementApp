import java.util.Arrays;

public class TrainManagementApp {

    public static void main(String[] args) {

        // Array of bogie names
        String[] bogieNames = {
                "Sleeper", "AC Chair", "First Class", "General", "Luxury"
        };

        System.out.println("=======================================");
        System.out.println("UC17 - Sort Bogie Names Using Arrays.sort()");
        System.out.println("=======================================\n");

        // Original array
        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));

        // Built-in sorting (Alphabetical)
        Arrays.sort(bogieNames);

        // Sorted array
        System.out.println("\nSorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames));

        System.out.println("\nUC17 sorting completed...");
    }
}