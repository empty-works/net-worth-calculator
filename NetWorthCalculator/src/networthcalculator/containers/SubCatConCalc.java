/*
 */
package networthcalculator.containers;

/**
 *
 * @author MP
 */
public class SubCatConCalc {
    
    public static double getAmountDifference(String currentAmountString, String previousAmountString) {
        
        double currentAmount = validateAmount(currentAmountString);
        double previousAmount = validateAmount(previousAmountString);
        double amountDifference = currentAmount - previousAmount;
        return amountDifference;
    }
    
    private static double validateAmount(String amount) {
        
        double newAmount = 0.0;
        if(!amount.isEmpty()) {
            
            newAmount = Double.parseDouble(amount);
        }
        return newAmount;
    }
    
    
}
