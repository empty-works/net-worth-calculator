/*
 */
package networthcalculator;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import networthcalculator.labels.AmountLabel;
import networthcalculator.labels.CategoryLabel;
import networthcalculator.labels.SubCategoryLabel;
import networthcalculator.labels.SubTotalAmountLabel;

/**
 *
 * @author MP
 */
public class AssetsContainer extends javafx.scene.control.ScrollPane {
    
    private GridPane assetsGridPane = new GridPane();
    private CategoryLabel categoryTitle = new CategoryLabel("ASSETS", "CURRENT VALUE");
    
    public AssetsContainer() {
        
        this.setId("AssetsContainer");
        this.setContent(assetsGridPane);
        setColors();
        setColumnConstraints();
        setGridProperties();
        addLabels();
        setScrollPaneProperties();
        this.setMaxWidth(Constants.MAX_WIDTH);
    }
    
    private void setColors() {
        
        categoryTitle.setBackground("#00ccff", 50.0, 5.5, 5.5, 5.5);
    }
    
    private void setColumnConstraints() {
        
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(100);
        column1.setHgrow(Priority.ALWAYS);
        column1.setHalignment(HPos.CENTER);
        assetsGridPane.getColumnConstraints().addAll(column1);
        System.out.println("Added column constraints to AssetsContainer grid...");
    }
    
    private void setGridProperties() {
        
        assetsGridPane.setAlignment(Pos.CENTER);
        assetsGridPane.setPadding(new Insets(10, 0, 0, 0)); // Adds space to the top.
    }
    
    private void addLabels() {
        
        assetsGridPane.add(categoryTitle, 0, 0);
        assetsGridPane.add(new SubCategoryLabel("Cash and Cash Equivalents"), 0, 1);
        assetsGridPane.add(new AmountLabel("Checking accounts"), 0, 2);
        assetsGridPane.add(new AmountLabel("Savings accounts"), 0, 3);
        assetsGridPane.add(new AmountLabel("Money market accounts"), 0, 4);
        assetsGridPane.add(new AmountLabel("Savings bonds"), 0, 5);
        assetsGridPane.add(new AmountLabel("CD's"), 0, 6);
        assetsGridPane.add(new AmountLabel("Cash value of life insurance"), 0, 7);
        assetsGridPane.add(new SubTotalAmountLabel("Total Cash"), 0, 8);
    }
    
    private void setScrollPaneProperties() {
        
        this.fitToWidthProperty().set(true);
        this.hbarPolicyProperty().setValue(ScrollBarPolicy.NEVER);
        this.setPannable(true);
    }
}
