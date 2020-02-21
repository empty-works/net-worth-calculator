/*
 */
package networthcalculator.labels;

import javafx.scene.layout.HBox;
import networthcalculator.MyUtility;

/**
 *
 * @author MP
 */
public class InputChecker {
    
    public static boolean checkIsValid(HBox hbox, String bgColor, String value) {
        
        boolean isValid = true;
        
        // Allow empty string.
        if(!value.isEmpty()) {
            
            // Check if the value only contains digits.
            if(!value.matches("[0-9]+")) {
                
                System.out.println("Value is invalid...");
                setInvalidBackground(hbox, bgColor);
                isValid = false;
            }
        }
        
        return isValid;
    }
    
    private static void setInvalidBackground(HBox hbox, String bgColor) {
        
        hbox.setStyle("-fx-background-color:" + bgColor + "; " + 
                "-fx-background-radius:" + MyUtility.DEFAULT_CORNER_RADIUS + "; " + 
                "-fx-border-color: red; -fx-border-width: 1");
    }
}
