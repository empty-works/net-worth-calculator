/*
 */
package networthcalculator.containers;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import networthcalculator.labels.SubCategoryLabel;

/**
 *
 * @author MP
 */
public class SubCategoryContainer {
    
    private List<Node> amountLabelList = new ArrayList<>();
    private GridPane gridPane = new GridPane(); 
    private SubCategoryLabel subCategoryLabel;
    private String bgColor;
    
    public SubCategoryContainer(String subCategoryTitle, String bgColor) {
        
        this.bgColor = bgColor;
        subCategoryLabel = new SubCategoryLabel(subCategoryTitle, bgColor);
        amountLabelList.add(subCategoryLabel);
    }
    
    
}
