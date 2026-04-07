public class TrainManagementApp {

    // Binary Search Method
    public static boolean binarySearch(String[] arr, String key) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int comparison = key.compareTo(arr[mid]);

            if (comparison == 0) {
                return true; // found
            }
            else if (comparison < 0) {
                high = mid - 1; // search left half
            }
            else {
                low = mid + 1; // search right half
            }
        }

        return false; // not found
    }

    public static void main(String[] args) {

        // Sorted array (IMPORTANT for Binary Search)
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Search key
        String searchId = "BG309";

        System.out.println("======================================");
        System.out.println("UC19 - Binary Search for Bogie ID");
        System.out.println("======================================\n");

        System.out.println("Available Bogie IDs (Sorted):");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        // Perform binary search
        boolean found = binarySearch(bogieIds, searchId);

        System.out.println();

        if (found) {
            System.out.println("Bogie " + searchId + " found in train consist.");
        } else {
            System.out.println("Bogie " + searchId + " NOT found in train consist.");
        }

        System.out.println("\nUC19 search completed...");
    }
}