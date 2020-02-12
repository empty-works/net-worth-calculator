/*
 */
package networthcalculator.containers;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.Node;
import networthcalculator.labels.SubCategoryLabel;

/**
 *
 * @author MP
 */
public class SubCategoryContainer extends javafx.scene.layout.GridPane {
    
    private List<Node> amountLabelList = new ArrayList<>();
    private SubCategoryLabel subCategoryLabel;
    
    public SubCategoryContainer(String subCategoryTitle, String titleColor) {
        
        subCategoryLabel = new SubCategoryLabel(subCategoryTitle, titleColor);
        amountLabelList.add(subCategoryLabel);
    }
    
    public void addLabel(Node label) {
        
        amountLabelList.add(label);
    }
    
    public void showLabels() {
        
        int xPos = 0;
        
        for(int i = 0; i < amountLabelList.size(); i++) {
            
            this.add(amountLabelList.get(i), xPos, i);
        }
    }
}
