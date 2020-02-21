/*
 */
package networthcalculator.labels;

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
        char[] valueArray = value.toCharArray();
        
        for(int i = 0; i < valueArray.length; i++) {
            
            if(!Character.isDigit(valueArray[i]) 
                    && valueArray[i] != '.') { // Decimals are allowed.
                
                isValid = false;
                break;
            }
        }
        
        return isValid;
    }
    
    private static void setInvalidBackground(TextField amountField) {
        
        amountField.setStyle("-fx-border-color: red; -fx-border-width: 1");
    }
}
