/*
 */
package networthcalculator.utilities;

import javafx.scene.control.Label;

/**
 *
 * @author MP
 */
public class CurrencySymbolSingleton {
    
    private Label currencyLabel = new Label();
    
    private volatile static CurrencySymbolSingleton obj;
    
    private CurrencySymbolSingleton() {}
    
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
    
   
}