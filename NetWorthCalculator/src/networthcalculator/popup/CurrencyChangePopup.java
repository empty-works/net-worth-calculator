/*
 */
package networthcalculator.popup;

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
        
        CurrencyPopupLabel label1 = new CurrencyPopupLabel("USD");
        CurrencyPopupLabel label2 = new CurrencyPopupLabel("PHP");
        CurrencyPopupLabel label3 = new CurrencyPopupLabel("EUR");
        
        vbox.getChildren().addAll(label1, label2, label3);
    }
}
