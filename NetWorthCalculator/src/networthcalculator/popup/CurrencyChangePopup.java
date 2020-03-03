/*
 */
package networthcalculator.popup;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author MP
 */
public class CurrencyChangePopup extends javafx.stage.Popup {
    
    private VBox vbox = new VBox();
    
    public CurrencyChangePopup() {
        
        setVBoxItems();
    }
    
    private void setVBoxItems() {
        
        Label label1 = new Label("Label1");
        Label label2 = new Label("Label2");
        Label label3 = new Label("Label3");
    }
}
