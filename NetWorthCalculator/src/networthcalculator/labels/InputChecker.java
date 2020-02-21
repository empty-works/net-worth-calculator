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
    
    public static void check(HBox hbox, String bgColor, String value) {
        
        // Allow empty string.
        if(!value.isEmpty()) {
            
            // Check if the value only contains digits.
            if(!value.matches("[0-9]+")) {

                setInvalidBackground(hbox, bgColor);
            }
        }
    }
    
    private static void setInvalidBackground(HBox hbox, String bgColor) {
        
        hbox.setStyle("-fx-background-color:" + bgColor + "; " + 
                "-fx-background-radius:" + MyUtility.DEFAULT_CORNER_RADIUS + "; " + 
                "-fx-stroke: red;");
    }
}
