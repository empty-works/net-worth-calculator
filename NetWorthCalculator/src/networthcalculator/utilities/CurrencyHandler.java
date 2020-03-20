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
    private double currencyRate = 1.0;
    private double previousCurrencyRate = 1.0;
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
        
        if(!amountFieldList.isEmpty()) {
            
            for(int i = 0; i < amountFieldList.size(); i++) {
            
                if(currency.equals("USD")) {
                    
                    amountFieldList.get(i).setText("" + convertToNonUSD(
                            Double.valueOf(amountFieldList.get(i).getText())));
                }
                else /*Revert currency back to USD then multiply by selected currency*/ {
                    
                    double newAmount = convertToNonUSD(convertFromNonUSD(
                            Double.valueOf(amountFieldList.get(i).getText())));
                    
                    String amtStr = "";
                    if(newAmount == 0.0) {
                        
                        amtStr = "0.00";
                    }
                    else {
                        
                        amtStr = "" + newAmount;
                    }
                    amountFieldList.get(i).setText(amtStr);
                }
            }
            
            previousCurrencyRate = currencyRate;
        }
    }
    
    private double convertToNonUSD(double amount) {
        
        return amount * currencyRate;
    }
    
    private double convertFromNonUSD(double amount) {
        
        return amount / previousCurrencyRate;
    }
}