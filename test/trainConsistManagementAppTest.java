import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class trainConsistManagementAppTest {

    // Same regex patterns as main code
    private final String trainPattern = "TRN-\\d{4}";
    private final String cargoPattern = "PET-[A-Z]{2}";

    private boolean isTrainValid(String input) {
        return Pattern.matches(trainPattern, input);
    }

    private boolean isCargoValid(String input) {
        return Pattern.matches(cargoPattern, input);
    }

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(isTrainValid("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(isTrainValid("TRAIN12"));
        assertFalse(isTrainValid("TRN12A"));
        assertFalse(isTrainValid("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(isCargoValid("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(isCargoValid("PET-ab"));   // lowercase
        assertFalse(isCargoValid("PET123"));   // no dash
        assertFalse(isCargoValid("AB-PET"));   // wrong format
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(isTrainValid("TRN-123"));   // 3 digits
        assertFalse(isTrainValid("TRN-12345")); // 5 digits
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(isCargoValid("PET-Ab"));
        assertFalse(isCargoValid("PET-aB"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(isTrainValid(""));
        assertFalse(isCargoValid(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(isTrainValid("TRN-1234-EXTRA"));
        assertFalse(isCargoValid("PET-ABCD"));
    }
}