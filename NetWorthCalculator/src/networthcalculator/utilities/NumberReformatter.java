/*
 */
package networthcalculator.utilities;

/**
 *
 * @author MP
 */
public class NumberReformatter {
    
    public static String reformat(String inputAmount) {
        
        String formattedAmount = String.format("%.2f", inputAmount);
        return formattedAmount;
    }
}
