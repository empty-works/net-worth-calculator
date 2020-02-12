/*
 */
package networthcalculator.labels.labelsubclasses;

/**
 *
 * @author MP
 */
public class InvestedAssetsAmountLabel extends networthcalculator.labels.AmountLabel {
    
    private InvestedAssetsSubTotalAmountLabel subTotalLabel;
    
    public InvestedAssetsAmountLabel(String text, String bgColor, InvestedAssetsSubTotalAmountLabel subTotalLabel) {
        
        super(text, bgColor);
        this.subTotalLabel = subTotalLabel;
    }
    
    private void addTextFieldListener() {
        
        
    }
}
