/*
 */
package networthcalculator.labels;

import javafx.scene.control.TextField;
import networthcalculator.MyUtility;

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
            if(!value.matches("[0-9]+")) {
                
                System.out.println("Value is invalid...");
                setInvalidBackground(amountField);
                isValid = false;
            }
        }
        
        return isValid;
    }
    
    private static void setInvalidBackground(TextField amountField) {
        
        amountField.setStyle("-fx-border-color: red; -fx-border-width: 1");
    }
}
