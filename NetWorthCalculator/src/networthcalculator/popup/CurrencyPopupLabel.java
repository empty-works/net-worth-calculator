/*
 */
package networthcalculator.popup;

import javafx.scene.layout.AnchorPane;

/**
 *
 * @author MP
 */
public class CurrencyPopupLabel extends javafx.scene.control.Label {
    
    public CurrencyPopupLabel(String currency) {
        
        this.setId("CurrencyPopupLabel");
        this.setText(currency);
        AnchorPane.setLeftAnchor(this, 0.0);
        AnchorPane.setRightAnchor(this, 0.0);
    }
}
