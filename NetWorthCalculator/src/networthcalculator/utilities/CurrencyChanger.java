/*
 */
package networthcalculator.utilities;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Label;

/**
 *
 * @author MP
 */
public class CurrencyChanger {
    
    private List<Label> currencyList = new ArrayList<>();
    
    public void addToList(Label currencyLabel) {
        
        currencyList.add(currencyLabel);
    }
    
    public void setLabelTexts(String text) {
        
        for(Label label : currencyList) {
            
            label.setText(text);
        }
    }
}