/*
 */
package networthcalculator;

import networthcalculator.labels.interfaces.BottomContainerController;
import networthcalculator.labels.labelsubclasses.AccCategory;

/**
 *
 * @author MP
 */
public class TotalAmount {
    
    private BottomContainerController bottomController;
    
    public TotalAmount(BottomContainerController bottomController) {
        
        this.bottomController = bottomController;
    }
    
    public void setSubTotalDifference(AccCategory category, double subTotalDifference) {
        
        bottomController.setAmounts(category, subTotalDifference);
    }
}
