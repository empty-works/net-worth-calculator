/*
 */
package networthcalculator;

import networthcalculator.labels.CategoryLabel;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.scene.layout.GridPane;
import networthcalculator.labels.AmountLabel;
import networthcalculator.labels.SubCategoryLabel;

/**
 *
 * @author MP
 */
public class MainUi extends javafx.scene.control.ScrollPane {
    
    private GridPane grid = new GridPane();
    
    public MainUi() {
        
        setColumnConstraints();
        addLabels();
        setScrollPaneProperties();
    }
    
    private void setColumnConstraints() {
        
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(100);
        column1.setHgrow(Priority.ALWAYS);
        grid.getColumnConstraints().addAll(column1);
        System.out.println("Added column constraints to grid pane...");
    }
    
    private void addLabels() {
        
        grid.add(new CategoryLabel(), 0, 0);
        grid.add(new SubCategoryLabel("Cash and Cash Equivalents"), 0, 1);
        grid.add(new AmountLabel("Checking Accounts"), 0, 2);
    }
    
    private void setScrollPaneProperties() {
        
        this.fitToWidthProperty().set(true);
        this.hbarPolicyProperty().setValue(ScrollBarPolicy.NEVER);
        this.setPannable(true);
        this.setContent(grid);
    }
}
