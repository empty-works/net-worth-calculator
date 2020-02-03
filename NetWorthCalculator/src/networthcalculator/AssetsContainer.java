/*
 */
package networthcalculator;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import networthcalculator.labels.AmountLabel;
import networthcalculator.labels.SubCategoryLabel;
import networthcalculator.labels.SubTotalAmountLabel;

/**
 *
 * @author MP
 */
public class AssetsContainer {
    
    private ScrollPane assetsScrollPane = new ScrollPane();
    private GridPane assetsGridPane = new GridPane();
    
    public AssetsContainer() {
        
        assetsScrollPane.setContent(assetsGridPane);
        assetsGridPane.add(new SubCategoryLabel("Cash and Cash Equivalents"), 0, 1);
        assetsGridPane.add(new AmountLabel("Checking accounts"), 0, 2);
        assetsGridPane.add(new AmountLabel("Savings accounts"), 0, 3);
        assetsGridPane.add(new AmountLabel("Money market accounts"), 0, 4);
        assetsGridPane.add(new AmountLabel("Savings bonds"), 0, 5);
        assetsGridPane.add(new AmountLabel("CD's"), 0, 6);
        assetsGridPane.add(new AmountLabel("Cash value of life insurance"), 0, 7);
        assetsGridPane.add(new SubTotalAmountLabel("Total Cash"), 0, 8);
    } 
}
