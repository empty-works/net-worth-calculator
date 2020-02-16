/*
 */
package networthcalculator.containers;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.Node;
import networthcalculator.labels.AmountLabel;
import networthcalculator.labels.SubCategoryLabel;
import networthcalculator.labels.SubTotalAmountLabel;
import networthcalculator.labels.TitleAndAmountLabel;
import networthcalculator.labels.interfaces.AmountViewController;

/**
 *
 * @author MP
 */
public class SubCategoryContainer extends javafx.scene.layout.GridPane implements AmountViewController {
    
    private List<Node> amountLabelList = new ArrayList<>();
    private SubCategoryLabel subCategoryLabel;
    private SubTotalAmountLabel subTotalLabel = null;
    private double subTotal = 0.0;
    
    public SubCategoryContainer(String subCategoryTitle, String titleColor) {
        
        subCategoryLabel = new SubCategoryLabel(subCategoryTitle, titleColor);
        amountLabelList.add(subCategoryLabel);
        
    }
    
    public void addAmountLabel(AmountLabel label) {
        
        label.setController(this);
        label.prefWidthProperty().bind(this.widthProperty());
        amountLabelList.add(label);
    }
    
    public void addTitleAmountLabel(TitleAndAmountLabel label) {
        
        label.prefWidthProperty().bind(this.widthProperty());
        amountLabelList.add(label);
    }
    
    // There can only be one.
    public void setSubTotalLabel(SubTotalAmountLabel label) {
        
        subTotalLabel = label;
    }
    
    public void showLabels() {
        
        int xPos = 0;
        int i = 0;
        for(; i < amountLabelList.size(); i++) {
            
            this.add(amountLabelList.get(i), xPos, i);
        }
        // Lastly add subtotal label.
        if(subTotalLabel != null) {
            
            this.add(subTotalLabel, xPos, i);
        }
    }

    @Override
    public void amountChanged(String currentAmountString, String previousAmountString) {
        
        double currentAmount = validateAmount(currentAmountString);
        double previousAmount = validateAmount(previousAmountString);
        
        double amountDifference = currentAmount - previousAmount;
        
        System.out.println("Current Amount: " + currentAmount);
        System.out.println("Previous Amount: " + previousAmount);
        System.out.println("Amount Difference: " + amountDifference);
        
        calculateSubTotal(amountDifference);
    }
    
    private void calculateSubTotal(double amountDifference) {
        
        subTotal += amountDifference; 
        System.out.println("Subtotal: " + subTotal);
        setSubTotal(subTotal);
    }
    
    private double validateAmount(String amount) {
        
        double newAmount = 0.0;
        if(!amount.isEmpty()) {
            
            newAmount = Double.parseDouble(amount);
        }
        return newAmount;
    }
    
    public void setSubTotal(double subTotal) {
        
        subTotalLabel.setSubTotal(subTotal);
    }
}
