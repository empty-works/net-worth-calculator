/*
 */
package networthcalculator.utilities;

import java.text.DecimalFormat;
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
    
    public void convertAmounts(double currencyRate) {
        
        if(!amountFieldList.isEmpty()) {
            
            for(int i = 0; i < amountFieldList.size(); i++) {
            
                if(previousCurrency.equals("USD") && !currency.equals("USD")) {
                    
                    
                    amountFieldList.get(i).setText(convertToNonUSD(
                            amountFieldList.get(i).getText(), currencyRate));
                }
                else if(!previousCurrency.equals("USD") && !currency.equals("USD")) {
                    
                    String usdAmount = convertBackToUSD(amountFieldList.get(i).getText());
                    String amtStr = usdAmount == "0.00" ? "0.00" : "" + usdAmount;
                    amountFieldList.get(i).setText(amtStr);
                }
            }
            
            previousCurrency = currency;
            previousCurrencyRate = currencyRate;
        }
    }
    
    public String convertToNonUSD(String amount, double inCurrencyRate) {
        
        if(amount.equals("0.00")) {
        
            return amount;
        }
        
        double newAmount = Double.valueOf(amount);
        DecimalFormat myFormatter = new DecimalFormat("###.##");
        return myFormatter.format(newAmount * inCurrencyRate);
    }
    
    public String convertBackToUSD(String amount) {
        
        if(amount.equals("0.00")) {
        
            return amount;
        }
        
        double newAmount = Double.valueOf(amount);
        return String.valueOf(newAmount / previousCurrencyRate);
    }
}