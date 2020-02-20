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
    
    public static void check(HBox hbox, String bgColor) {
        
        
        
    }
    
    private void setInvalidBackground(HBox hbox, String bgColor) {
        
        hbox.setStyle("-fx-background-color:" + bgColor + "; " + 
                "-fx-background-radius:" + MyUtility.DEFAULT_CORNER_RADIUS + "; " + 
                "-fx-stroke: red;");
    }
}
