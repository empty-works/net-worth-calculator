/*
 */
package networthcalculator.utilities;

import javafx.scene.control.Label;

/**
 *
 * @author MP
 */
public class CurrencySymbolSingleton {
    
    private Label currencyLabel = new Label("USD");
    
    private volatile static CurrencySymbolSingleton obj;
    
    private CurrencySymbolSingleton() {
        
        currencyLabel.setId("AmountDollarSignLabel");
        
    }
    
    public static CurrencySymbolSingleton getInstance() {
        
        if(obj == null) {
            
            synchronized (CurrencySymbolSingleton.class) {
                
                if(obj == null) {
                    
                    obj = new CurrencySymbolSingleton();
                }
            }
        }
        return obj;
    }
    
    public Label getCurrencyLabel() {
        
        return currencyLabel;
    }
    
    public void setCurText(String text) {
        
        currencyLabel.setText(text);
    }
}