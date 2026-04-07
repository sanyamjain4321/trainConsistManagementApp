public class TrainManagementApp {

    // Binary Search with Defensive Check
    public static boolean binarySearch(String[] arr, String key) {

        // UC20: Fail-Fast Validation
        if (arr == null || arr.length == 0) {
            throw new IllegalStateException("Cannot perform search: Train has no bogies.");
        }

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int comparison = key.compareTo(arr[mid]);

            if (comparison == 0) {
                return true;
            }
            else if (comparison < 0) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        // Change this to test different cases
        String[] bogieIds = {};

        String searchId = "BG309";

        System.out.println("==============================================");
        System.out.println("UC20 - Exception Handling During Search");
        System.out.println("==============================================\n");

        try {
            boolean found = binarySearch(bogieIds, searchId);

            if (found) {
                System.out.println("Bogie " + searchId + " found in train consist.");
            } else {
                System.out.println("Bogie " + searchId + " NOT found in train consist.");
            }

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nUC20 operation completed...");
    }
}