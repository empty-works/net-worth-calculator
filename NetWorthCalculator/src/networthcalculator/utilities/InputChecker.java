/*
 */
package networthcalculator.utilities;

import javafx.scene.control.TextField;

/**
 *
 * @author MP
 */
public class InputChecker {
    
    public static boolean checkIsValid(TextField amountField, String value) {
        
        boolean isValid = true;
        
        // Allow empty string.
        if(!value.isEmpty()) {
            
            // Check if the value only contains digits.
            if(!isAllDigits(value)) {
                
                System.out.println("Value is invalid...");
                setInvalidBackground(amountField);
                isValid = false;
            }
        }
        
        return isValid;
    }
    
    private static boolean isAllDigits(String value) {
        
        boolean isValid = true;
        
        try {
            
            Double.parseDouble(value);
        }
        catch(NumberFormatException e) {
            
            System.out.println("isAllDigits Error: " + e);
            isValid = false;
        }
        
        return isValid;
    }
    
    private static void setInvalidBackground(TextField amountField) {
        
        amountField.setStyle("-fx-border-color: red; -fx-border-width: 1");
    }
}
