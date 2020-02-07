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
import networthcalculator.labels.AmountLabel;
import networthcalculator.labels.CategoryLabel;
import networthcalculator.labels.SubCategoryLabel;
import networthcalculator.labels.SubTotalAmountLabel;

/**
 *
 * @author MP
 */
public class LiabilitiesContainer extends javafx.scene.layout.VBox {
    
    private ScrollPane scrollPane = new ScrollPane();
    private GridPane liabilitiesGridPane = new GridPane();
    private CategoryLabel categoryTitle = new CategoryLabel("LIABILITIES", "CURRENT AMOUNT DUE");
    final private String DEFAULT_LABEL_GRAY_COLOR = "#e6e6e6";
    final private String DARKER_GRAY_COLOR = "#a6a6a6";
    
    public LiabilitiesContainer() {
        
        setCategoryTitleProperties();
        setColumnConstraints();
        setGridProperties();
        setScrollPaneProperties();
        addLabels();
        addMainComponentsToVBox();
        this.setPadding(new Insets(10, 0, 0, 0));
    }
    
    private void setCategoryTitleProperties() {
        
        categoryTitle.setBackground("#ff3333", 5.5, 50.0, 5.5, 5.5);
    }
    
    private void setColumnConstraints() {
        
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(100);
        column1.setHgrow(Priority.ALWAYS);
        column1.setHalignment(HPos.CENTER);
        liabilitiesGridPane.getColumnConstraints().addAll(column1);
        System.out.println("Added column constraints to LiabilitiesContainer grid...");
    }
    
    private void setGridProperties() {
        
        liabilitiesGridPane.setAlignment(Pos.CENTER);
    }
    
    private void setScrollPaneProperties() {
        
        scrollPane.setId("LiabilitiesContainer");
        scrollPane.setContent(liabilitiesGridPane);
        scrollPane.fitToWidthProperty().set(true);
        scrollPane.hbarPolicyProperty().setValue(ScrollBarPolicy.NEVER);
        scrollPane.setPannable(true);
    }
    
    private void addLabels() {

        liabilitiesGridPane.add(new SubCategoryLabel("Current", DEFAULT_LABEL_GRAY_COLOR), 0, 0);
        liabilitiesGridPane.add(new AmountLabel("Credit card balances", DEFAULT_LABEL_GRAY_COLOR), 0, 1);
        liabilitiesGridPane.add(new AmountLabel("Estimated income tax owed", DEFAULT_LABEL_GRAY_COLOR), 0, 2);
        liabilitiesGridPane.add(new AmountLabel("Other outstanding bills", DEFAULT_LABEL_GRAY_COLOR), 0, 3);
        liabilitiesGridPane.add(new SubCategoryLabel("Long-Term", DEFAULT_LABEL_GRAY_COLOR), 0, 4);
        liabilitiesGridPane.add(new AmountLabel("Home mortgage", DEFAULT_LABEL_GRAY_COLOR), 0, 5);
        liabilitiesGridPane.add(new AmountLabel("Home equity loan", DEFAULT_LABEL_GRAY_COLOR), 0, 6);
        liabilitiesGridPane.add(new AmountLabel("Mortgages on rental properties", DEFAULT_LABEL_GRAY_COLOR), 0, 7);
    }
    
    private void addMainComponentsToVBox() {
        
        this.getChildren().addAll(categoryTitle, scrollPane);
    }
}