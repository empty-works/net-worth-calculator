/*
 */
package networthcalculator.utilities;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author MP
 */
public class CurrencyHandler {
    
    private List<Label> currencyList = new ArrayList<>();
    private List<TextField> amountFieldList = new ArrayList<>();
    
    public void addToCurrencySymbolList(Label currencyLabel) {
        
        currencyList.add(currencyLabel);
    }
    
    public void setLabelTexts(String text) {
        
        for(Label label : currencyList) {
            
            label.setText(text);
        }
    }
    
    public void addToAmountFieldsList(TextField amountField) {
        
        amountFieldList.add(amountField);
    }
}