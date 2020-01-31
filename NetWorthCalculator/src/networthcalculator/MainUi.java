/*
 */
package networthcalculator;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import networthcalculator.labels.CategoryLabel;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
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
        setGridProperties();
        addLabels();
        setScrollPaneProperties();
    }
    
    private void setColumnConstraints() {
        
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(100);
        column1.setHgrow(Priority.ALWAYS);
        column1.setHalignment(HPos.CENTER);
        grid.getColumnConstraints().addAll(column1);
        System.out.println("Added column constraints to grid pane...");
    }
    
    private void setGridProperties() {
        
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 0, 0, 0)); // Adds space to the top.
    }
    
    private void addLabels() {
        
        grid.add(new CategoryLabel("ASSETS", "CURRENT VALUE"), 0, 0);
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
