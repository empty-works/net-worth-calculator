/*
 */
package networthcalculator.popup;

/**
 *
 * @author MP
 */
public class CurrencyPopupLabel extends javafx.scene.control.Label {
    
    private String currency;
    
    public CurrencyPopupLabel(String currency) {
        
        this.setId("CurrencyPopupLabel");
        this.currency = currency;
        this.setText(currency);
    }
    
    
}
