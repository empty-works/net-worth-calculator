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
import networthcalculator.labels.SubTotalAmountLabel;
import networthcalculator.labels.labelsubclasses.AccCategoryLiabilities;
import networthcalculator.labels.labelsubclasses.LiabilitiesCategoryLabel;
import networthcalculator.utilities.CurrencyChanger;

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
    private CurrencyChanger changer;
    
    public LiabilitiesContainer(TotalAmount totalAmount, CurrencyChanger changer) {
        
        this.totalAmount = totalAmount;
        this.changer = changer;
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
        currentSubCatCon.addAmountLabel("Credit card balances", changer);
        currentSubCatCon.addAmountLabel("Estimated income tax owed", changer);
        currentSubCatCon.addAmountLabel("Other outstanding bills", changer);
        currentSubCatCon.setSubTotalLabel(new SubTotalAmountLabel("Current Total", totalAmount));
        
        currentSubCatCon.showLabels();
        labelList.add(currentSubCatCon);
        
        // Long-Term
        SubCategoryContainer longTermSubCatCon = new SubCategoryContainer(
                "Long-Term", darkGray, new AccCategoryLiabilities());
        longTermSubCatCon.addAmountLabel("Home mortgage", changer);
        longTermSubCatCon.addAmountLabel("Home equity loan", changer);
        longTermSubCatCon.addAmountLabel("Mortgages on rental properties", changer);
        longTermSubCatCon.addAmountLabel("Car loans", changer);
        longTermSubCatCon.addAmountLabel("Student loans", changer);
        longTermSubCatCon.addAmountLabel("Life insurance policy loans", changer);
        longTermSubCatCon.addAmountLabel("Other long-term debt", changer);
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
