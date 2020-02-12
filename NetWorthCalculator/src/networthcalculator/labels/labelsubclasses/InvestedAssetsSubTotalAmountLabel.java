/*
 */
package networthcalculator.labels.labelsubclasses;

/**
 *
 * @author MP
 */
public class InvestedAssetsSubTotalAmountLabel extends networthcalculator.labels.SubTotalAmountLabel {
    
    private double subTotal = 0.0;
    
    public InvestedAssetsSubTotalAmountLabel(String text) {
        
        super(text);
    }
    
    public void addAmount(double amount) {
        
        subTotal += amount;
    }
}
