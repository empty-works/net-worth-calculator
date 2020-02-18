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
import networthcalculator.labels.labelsubclasses.AccCategory;

/**
 *
 * @author MP
 */
public class SubCategoryContainer extends javafx.scene.layout.GridPane implements AmountViewController {
    
    private List<Node> amountLabelList = new ArrayList<>();
    private SubCategoryLabel subCategoryLabel;
    private SubTotalAmountLabel subTotalLabel = null;
    private double subTotal = 0.0;
    private AccCategory category;
    
    public SubCategoryContainer(String subCategoryTitle, String titleColor, AccCategory category) {
        
        this.category = category;
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
        calculateSubTotal(amountDifference);
    }
    
    private void calculateSubTotal(double amountDifference) {
        
        subTotal += amountDifference;
        System.out.println("Subtotal: " + subTotal);
        subTotalLabel.setSubTotal(subTotal);
        setSubTotalDifference(amountDifference);
    }
    
    private double validateAmount(String amount) {
        
        double newAmount = 0.0;
        if(!amount.isEmpty()) {
            
            newAmount = Double.parseDouble(amount);
        }
        return newAmount;
    }
    
    public void setSubTotalDifference(double amountDifference) {
        
        subTotalLabel.setSubTotalDifference(category, amountDifference);
    }
    
    public AccCategory getCategory() {
        
        return category;
    }
}
