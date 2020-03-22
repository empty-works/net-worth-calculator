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
    private String currency = "", previousCurrency = "USD";
    
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
    
    public void convertAmounts() {
        
        if(!amountFieldList.isEmpty()) {
            
            for(int i = 0; i < amountFieldList.size(); i++) {
            
                if(previousCurrency.equals("USD")) {
                    
                    amountFieldList.get(i).setText("" + convertToNonUSD(
                            amountFieldList.get(i).getText()));
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
            
            previousCurrency = currency;
            previousCurrencyRate = currencyRate;
        }
    }
    
    private double convertToNonUSD(String amount) {
        
        double newAmount = Double.valueOf(amount);
        return newAmount * currencyRate;
    }
    
    private double convertFromNonUSD(double amount) {
        
        
        return amount / previousCurrencyRate;
    }
}