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
    private double currencyRate = 0.0;
    private String currency = "";
    
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
    
    public void setCurrency(String currency) {
        
        this.currency = currency;
    }
    
    public void setCurrencyRate(String currencyRate) {
        
        this.currencyRate = Double.valueOf(currencyRate);
        convertAmounts();
    }
    
    private void convertAmounts() {
        
        
    }
}