/*
 */
package networthcalculator.containers;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import networthcalculator.Utility;
import networthcalculator.labels.AmountLabel;
import networthcalculator.labels.CategoryLabel;
import networthcalculator.labels.SubCategoryLabel;

/**
 *
 * @author MP
 */
public class LiabilitiesContainer extends javafx.scene.layout.VBox {
    
    private ScrollPane scrollPane = new ScrollPane();
    private GridPane liabilitiesGridPane = new GridPane();
    private CategoryLabel categoryTitle = new CategoryLabel("LIABILITIES", "CURRENT AMOUNT DUE");
    
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

        List<Node> labelList = new ArrayList<>();
        
        labelList.add(new SubCategoryLabel("Current", Utility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Credit card balances", Utility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Estimated income tax owed", Utility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Other outstanding bills", Utility.DEFAULT_LABEL_GRAY_COLOR));
        
        labelList.add(new SubCategoryLabel("Long-Term", Utility.DARKER_GRAY_COLOR));
        labelList.add(new AmountLabel("Home mortgage", Utility.DARKER_GRAY_COLOR));
        labelList.add(new AmountLabel("Home equity loan", Utility.DARKER_GRAY_COLOR));
        labelList.add(new AmountLabel("Mortgages on rental properties", Utility.DARKER_GRAY_COLOR));
        labelList.add(new AmountLabel("Car loans", Utility.DARKER_GRAY_COLOR));
        labelList.add(new AmountLabel("Student loans", Utility.DARKER_GRAY_COLOR));
        labelList.add(new AmountLabel("Life insurance policy loans", Utility.DARKER_GRAY_COLOR));
        labelList.add(new AmountLabel("Other long-term debt", Utility.DARKER_GRAY_COLOR));
        
        int xPos = 0;
        for(int i = 0; i < labelList.size(); i++) {
            
            liabilitiesGridPane.add(labelList.get(i), xPos, i);
        }
    }
    
    private void addMainComponentsToVBox() {
        
        this.getChildren().addAll(categoryTitle, scrollPane);
    }
}
