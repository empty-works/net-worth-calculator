/*
 */
package networthcalculator.utilities;

import java.text.DecimalFormat;

/**
 *
 * @author MP
 */
public class NumberReformatter {
    
    //TODO: Reformat amount to include comma separators
    public static String reformat(String inputAmount) {
        
        double dblAmount = Double.parseDouble(inputAmount);
        //String formattedAmount = String.format("%.2f", dblAmount);
        String formattedAmount = formatDecimal(dblAmount);
        return formattedAmount;
    }
    
    public static String reformat(double amount) {
        
        //String formattedAmount = String.format("%.2f", amount);
        String formattedAmount = formatDecimal(amount);
        return formattedAmount;
    }
    
    private static String formatDecimal(double amount) {
        
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        return formatter.format(amount);
    }
}
