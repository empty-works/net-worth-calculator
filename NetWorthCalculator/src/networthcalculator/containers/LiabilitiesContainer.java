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
import networthcalculator.MyUtility;
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
        
        setColumnConstraints();
        setGridProperties();
        setScrollPaneProperties();
        addLabels();
        addMainComponentsToVBox();
        this.setPadding(new Insets(10, 0, 0, 0));
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
        
        labelList.add(new SubCategoryLabel("Current", MyUtility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Credit card balances", MyUtility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Estimated income tax owed", MyUtility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Other outstanding bills", MyUtility.DEFAULT_LABEL_GRAY_COLOR));
        
        labelList.add(new SubCategoryLabel("Long-Term", MyUtility.DARKER_GRAY_COLOR));
        labelList.add(new AmountLabel("Home mortgage", MyUtility.DARKER_GRAY_COLOR));
        labelList.add(new AmountLabel("Home equity loan", MyUtility.DARKER_GRAY_COLOR));
        labelList.add(new AmountLabel("Mortgages on rental properties", MyUtility.DARKER_GRAY_COLOR));
        labelList.add(new AmountLabel("Car loans", MyUtility.DARKER_GRAY_COLOR));
        labelList.add(new AmountLabel("Student loans", MyUtility.DARKER_GRAY_COLOR));
        labelList.add(new AmountLabel("Life insurance policy loans", MyUtility.DARKER_GRAY_COLOR));
        labelList.add(new AmountLabel("Other long-term debt", MyUtility.DARKER_GRAY_COLOR));
        
        int xPos = 0;
        for(int i = 0; i < labelList.size(); i++) {
            
            liabilitiesGridPane.add(labelList.get(i), xPos, i);
        }
    }
    
    private void addMainComponentsToVBox() {
        
        this.getChildren().addAll(categoryTitle, scrollPane);
    }
}
