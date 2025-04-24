package validate_sa_id;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidateSaId {
    
    public static boolean isIdNumberValid(String idNumber) {
        // Basic validation
        if (idNumber == null || idNumber.length() != 13 || !idNumber.matches("\\d+")) {
            return false;
        }
        
        // Extract components
        String datePart = idNumber.substring(0, 6);
        String citizenPart = idNumber.substring(10, 11);
        String checksumPart = idNumber.substring(12);
        
        // Validate date of birth
        if (!isValidDate(datePart)) {
            return false;
        }
        
        // Validate citizen status (must be 0 or 1)
        if (!citizenPart.matches("[01]")) {
            return false;
        }
        
        // Validate checksum using Luhn algorithm
        return isValidLuhn(idNumber);
    }
    
    private static boolean isValidDate(String datePart) {
        try {
            int year = Integer.parseInt(datePart.substring(0, 2));
            int currentYear = LocalDate.now().getYear() % 100;
            String prefix = (year <= currentYear) ? "20" : "19";
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            LocalDate.parse(prefix + datePart, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    
    private static boolean isValidLuhn(String number) {
        int sum = 0;
        boolean alternate = false;
        
        for (int i = number.length() - 2; i >= 0; i--) {
            int digit = Character.getNumericValue(number.charAt(i));
            
            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit = (digit % 10) + 1;
                }
            }
            
            sum += digit;
            alternate = !alternate;
        }
        
        int checksum = (10 - (sum % 10)) % 10;
        return checksum == Character.getNumericValue(number.charAt(12));
    }
}