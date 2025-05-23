/*
 * This source file was generated by the Gradle 'init' task
 */
package validate_sa_id;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import validate_sa_id.ValidateSaId;

public class ValidateSaIdTest {

    @Test
    public void testValidIds() {
       //assertTrue(ValidateSaId.isIdNumberValid("2001014800086"));
       //assertTrue(ValidateSaId.isIdNumberValid("2909035800085"));
    }

    @Test
    public void testInvalidLength() {
        assertFalse(ValidateSaId.isIdNumberValid("123456789012"));
        assertFalse(ValidateSaId.isIdNumberValid("12345678901234"));
    }

    @Test
    public void testNonNumeric() {
        assertFalse(ValidateSaId.isIdNumberValid("20010148000A6"));
        assertFalse(ValidateSaId.isIdNumberValid("20010148000.6"));
    }

    @Test
    public void testNullInput() {
        assertFalse(ValidateSaId.isIdNumberValid(null));
    }

    @Test
    public void testInvalidDates() {
        assertFalse(ValidateSaId.isIdNumberValid("0000004800086"));
        assertFalse(ValidateSaId.isIdNumberValid("9902304800086"));
    }

    @Test
    public void testInvalidCitizenStatus() {
        assertFalse(ValidateSaId.isIdNumberValid("2001014800286"));
    }

    @Test
    public void testInvalidChecksum() {
        assertFalse(ValidateSaId.isIdNumberValid("2001014800087"));
    }
}
