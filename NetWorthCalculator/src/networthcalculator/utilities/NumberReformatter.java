/*
 */
package networthcalculator.utilities;

import java.text.DecimalFormat;

/**
 *
 * @author MP
 */
public class NumberReformatter {
    
    public static String reformat(String inputAmount) {
        
        double dblAmount = Double.parseDouble(inputAmount);
        //String formattedAmount = formatDecimal(dblAmount);
        return String.valueOf(dblAmount);
    }
    
    public static String reformat(double amount) {
        
        String formattedAmount = formatDecimal(amount);
        return formattedAmount;
    }
    
    private static String formatDecimal(double amount) {
        
        DecimalFormat formatter = new DecimalFormat("#,##0.00");
        return formatter.format(amount);
    }
}
