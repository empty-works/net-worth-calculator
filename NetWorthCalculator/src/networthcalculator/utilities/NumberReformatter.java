/*
 */
package networthcalculator.utilities;

/**
 *
 * @author MP
 */
public class NumberReformatter {
    
    public static String reformat(String inputAmount) {
        
        double dblAmount = Double.parseDouble(inputAmount);
        String formattedAmount = String.format("%.2f", dblAmount);
        return formattedAmount;
    }
}
