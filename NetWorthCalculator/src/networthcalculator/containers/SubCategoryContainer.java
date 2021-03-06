/*
 */
package networthcalculator.containers;

import networthcalculator.utilities.SubCatConCalc;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Node;
import networthcalculator.labels.AmountLabel;
import networthcalculator.labels.SubCategoryLabel;
import networthcalculator.labels.SubTotalAmountLabel;
import networthcalculator.labels.TitleAndAmountLabel;
import networthcalculator.labels.interfaces.AmountViewController;
import networthcalculator.labels.labelsubclasses.AccCategory;
import networthcalculator.utilities.CurrencyHandler;

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
    
    public void addAmountLabel(String title, CurrencyHandler changer) {
        
        AmountLabel newLabel = new AmountLabel(title, "lightgray");
        changer.addToCurrencySymbolList(newLabel.getCurLabel());
        changer.addToAmountFieldsList(newLabel.getAmountField());
        newLabel.setController(this);
        newLabel.prefWidthProperty().bind(this.widthProperty());
        newLabel.setCurrencyHandler(changer);
        amountLabelList.add(newLabel);
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
        
        double amountDifference = SubCatConCalc.getAmountDifference(
                currentAmountString, previousAmountString);
        // Set subtotal.
        subTotal += amountDifference;
        subTotalLabel.setSubTotal(subTotal, category);
        // Set amount difference.
        setSubTotalDifference(amountDifference);
    }
    
    public void setSubTotalDifference(double amountDifference) {
        
        subTotalLabel.setSubTotalDifference(category, amountDifference);
    }
    
    public AccCategory getCategory() {
        
        return category;
    }
}
