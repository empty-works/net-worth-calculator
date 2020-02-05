/*
 */
package networthcalculator.containers;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import networthcalculator.Constants;
import networthcalculator.labels.AmountLabel;
import networthcalculator.labels.CategoryLabel;
import networthcalculator.labels.SubCategoryLabel;
import networthcalculator.labels.SubTotalAmountLabel;

/**
 *
 * @author MP
 */
public class AssetsContainer extends javafx.scene.layout.VBox {
    
    private ScrollPane scrollPane = new ScrollPane();
    private GridPane assetsGridPane = new GridPane();
    private CategoryLabel categoryTitle = new CategoryLabel("ASSETS", "CURRENT VALUE");
    
    public AssetsContainer() {
        
        setCategoryTitleProperties();
        setColumnConstraints();
        setGridProperties();
        setScrollPaneProperties();
        addLabels();
        addMainComponentsToVBox();
        //this.setMaxWidth(Constants.MAX_WIDTH);
        this.setPadding(new Insets(10, 0, 0, 0)); // Adds space to the top.
    }
    
    private void setCategoryTitleProperties() {
        
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
    }
    
    private void setScrollPaneProperties() {
        
        scrollPane.setId("AssetsContainer");
        scrollPane.setContent(assetsGridPane);
        scrollPane.fitToWidthProperty().set(true);
        scrollPane.hbarPolicyProperty().setValue(ScrollBarPolicy.NEVER);
        scrollPane.setPannable(true);
    }
    
    private void addLabels() {

        assetsGridPane.add(new SubCategoryLabel("Cash and Cash Equivalents"), 0, 0);
        assetsGridPane.add(new AmountLabel("Checking accounts"), 0, 1);
        assetsGridPane.add(new AmountLabel("Savings accounts"), 0, 2);
        assetsGridPane.add(new AmountLabel("Money market accounts"), 0, 3);
        assetsGridPane.add(new AmountLabel("Savings bonds"), 0, 4);
        assetsGridPane.add(new AmountLabel("CD's"), 0, 5);
        assetsGridPane.add(new AmountLabel("Cash value of life insurance"), 0, 6);
        assetsGridPane.add(new SubTotalAmountLabel("Total Cash"), 0, 7);
    }
    
    private void addMainComponentsToVBox() {
        
        this.getChildren().addAll(categoryTitle, scrollPane);
    }
}
