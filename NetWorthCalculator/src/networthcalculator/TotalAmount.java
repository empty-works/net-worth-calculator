/*
 */
package networthcalculator;

import networthcalculator.labels.labelsubclasses.AccCategory;

/**
 *
 * @author MP
 */
public class TotalAmount {
    
    private double assetsSubTotal = 0.0, liabilitiesSubTotal = 0.0;
    
    public TotalAmount() {
        
        
    }
    
    public void setSubTotal(AccCategory category, double amount) {
        
        if(category.getCategory().equals(AccCategory.ASSETS)) {
            
            assetsSubTotal = amount;
        }
        if(category.getCategory().equals(AccCategory.LIABILITIES)) {
            
            liabilitiesSubTotal = amount;
        }
    }
    
    public double getAssetsTotal() {
        
        return assetsSubTotal;
    }
    
    public double getLiabilitiesTotal() {
        
        return liabilitiesSubTotal;
    }
}
