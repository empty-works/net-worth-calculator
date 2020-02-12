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

    @Override
    protected void addListenerInstructions(String oldValue, String newValue) {
        
        
    }
}
