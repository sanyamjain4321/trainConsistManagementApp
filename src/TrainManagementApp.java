public class TrainManagementApp {

    // Linear Search Method
    public static boolean linearSearch(String[] arr, String key) {

        for (int i = 0; i < arr.length; i++) {

            // Compare using equals()
            if (arr[i].equals(key)) {
                return true; // found → stop early
            }
        }

        return false; // not found
    }

    public static void main(String[] args) {

        // Array of bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Search key
        String searchId = "BG309";

        System.out.println("======================================");
        System.out.println("UC18 - Linear Search for Bogie ID");
        System.out.println("======================================\n");

        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        // Perform search
        boolean found = linearSearch(bogieIds, searchId);

        System.out.println();

        if (found) {
            System.out.println("Bogie " + searchId + " found in train consist.");
        } else {
            System.out.println("Bogie " + searchId + " NOT found in train consist.");
        }

        System.out.println("\nUC18 search completed...");
    }
}