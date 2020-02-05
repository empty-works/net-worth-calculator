/*
 */
package networthcalculator;

import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import networthcalculator.labels.CategoryLabel;

/**
 *
 * @author MP
 */
public class LiabilitiesContainer extends javafx.scene.layout.VBox {
    
    private ScrollPane scrollPane = new ScrollPane();
    private GridPane liabilitiesGridPane = new GridPane();
    private CategoryLabel categoryTitle = new CategoryLabel("LIABILITIES", "CURRENT AMOUNT DUE");
    
    public LiabilitiesContainer() {
        
        this.maxWidth(Constants.MAX_WIDTH);
        this.setPadding(new Insets(10, 0, 0, 0));
        
    }
}
