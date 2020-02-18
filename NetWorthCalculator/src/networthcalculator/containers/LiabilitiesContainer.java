/*
 */
package networthcalculator.containers;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import networthcalculator.TotalAmount;
import networthcalculator.labels.AmountLabel;
import networthcalculator.labels.SubTotalAmountLabel;
import networthcalculator.labels.labelsubclasses.AccCategoryLiabilities;
import networthcalculator.labels.labelsubclasses.LiabilitiesCategoryLabel;

/**
 *
 * @author MP
 */
public class LiabilitiesContainer extends javafx.scene.layout.VBox {
    
    private ScrollPane scrollPane = new ScrollPane();
    private GridPane liabilitiesGridPane = new GridPane();
    private LiabilitiesCategoryLabel categoryTitle = 
            new LiabilitiesCategoryLabel("LIABILITIES", "CURRENT AMOUNT DUE");
    private String darkGray = "darkgray";
    private String lightGray = "lightgray";
    private TotalAmount totalAmount;
    
    public LiabilitiesContainer(TotalAmount totalAmount) {
        
        this.totalAmount = totalAmount;
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

        List<SubCategoryContainer> labelList = new ArrayList<>();
        
        // Current
        SubCategoryContainer currentSubCatCon = new SubCategoryContainer(
                "Current", lightGray, new AccCategoryLiabilities());
        currentSubCatCon.addAmountLabel(new AmountLabel("Credit card balances", lightGray));
        currentSubCatCon.addAmountLabel(new AmountLabel("Estimated income tax owed", lightGray));
        currentSubCatCon.addAmountLabel(new AmountLabel("Other outstanding bills", lightGray));
        currentSubCatCon.setSubTotalLabel(new SubTotalAmountLabel("Current Total", totalAmount));
        
        currentSubCatCon.showLabels();
        labelList.add(currentSubCatCon);
        
        // Long-Term
        SubCategoryContainer longTermSubCatCon = new SubCategoryContainer(
                "Long-Term", lightGray, new AccCategoryLiabilities());
        longTermSubCatCon.addAmountLabel(new AmountLabel("Home mortgage", darkGray));
        longTermSubCatCon.addAmountLabel(new AmountLabel("Home equity loan", darkGray));
        longTermSubCatCon.addAmountLabel(new AmountLabel("Mortgages on rental properties", darkGray));
        longTermSubCatCon.addAmountLabel(new AmountLabel("Car loans", darkGray));
        longTermSubCatCon.addAmountLabel(new AmountLabel("Student loans", darkGray));
        longTermSubCatCon.addAmountLabel(new AmountLabel("Life insurance policy loans", darkGray));
        longTermSubCatCon.addAmountLabel(new AmountLabel("Other long-term debt", darkGray));
        longTermSubCatCon.setSubTotalLabel(new SubTotalAmountLabel("Long-Term Total", totalAmount));
        
        longTermSubCatCon.showLabels();
        labelList.add(longTermSubCatCon);

        int xPos = 0;
        for(int i = 0; i < labelList.size(); i++) {
            
            liabilitiesGridPane.add(labelList.get(i), xPos, i);
        }
    }
    
    private void addMainComponentsToVBox() {
        
        this.getChildren().addAll(categoryTitle, scrollPane);
    }
}
