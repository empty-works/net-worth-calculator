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
import networthcalculator.labels.SubTotalAmountLabel;
import networthcalculator.labels.TitleAndAmountLabel;

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

        List<Node> labelList = new ArrayList<>();
        
        // Cash and Cash Equivalents - default color
        labelList.add(new SubCategoryLabel("Cash and Cash Equivalents", Utility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Checking accounts", Utility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Savings accounts", Utility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Money market accounts", Utility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Savings bonds", Utility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("CD's", Utility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Cash value of life insurance", Utility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new SubTotalAmountLabel("Total Cash"));
        
        // Invested Assets
        labelList.add(new SubCategoryLabel("Invested Assets", Utility.DARKER_GRAY_COLOR));
        
        TitleAndAmountLabel taxableAccount = new TitleAndAmountLabel("Taxable account", Utility.DARKER_GRAY_COLOR);
        taxableAccount.addAllAmountLabels(new AmountLabel("Brokerage", Utility.DARKER_GRAY_COLOR), 
                                          new AmountLabel("Other", Utility.DARKER_GRAY_COLOR));
        labelList.add(taxableAccount);
        
        TitleAndAmountLabel retirementAccounts = new TitleAndAmountLabel("Retirement accounts", Utility.DARKER_GRAY_COLOR);
        retirementAccounts.addAllAmountLabels(new AmountLabel("IRA", Utility.DARKER_GRAY_COLOR), 
                                          new AmountLabel("Roth IRA", Utility.DARKER_GRAY_COLOR), 
                                          new AmountLabel("401(k) or 403(b)", Utility.DARKER_GRAY_COLOR), 
                                          new AmountLabel("SEP-IRA", Utility.DARKER_GRAY_COLOR), 
                                          new AmountLabel("Pension (vested benefit)", Utility.DARKER_GRAY_COLOR), 
                                          new AmountLabel("Annuity (accumulated value)", Utility.DARKER_GRAY_COLOR), 
                                          new AmountLabel("Annuity (accumulated value)", Utility.DARKER_GRAY_COLOR));
        labelList.add(retirementAccounts);
        
        TitleAndAmountLabel businessOwnership = new TitleAndAmountLabel("Business ownership interests", Utility.DARKER_GRAY_COLOR);
        businessOwnership.addAllAmountLabels(new AmountLabel("Real estate", Utility.DARKER_GRAY_COLOR), 
                                          new AmountLabel("Sole propietorship", Utility.DARKER_GRAY_COLOR), 
                                          new AmountLabel("Partnership", Utility.DARKER_GRAY_COLOR), 
                                          new AmountLabel("C Corporation", Utility.DARKER_GRAY_COLOR), 
                                          new AmountLabel("S Corporation", Utility.DARKER_GRAY_COLOR), 
                                          new AmountLabel("Limited liability company", Utility.DARKER_GRAY_COLOR), 
                                          new AmountLabel("Other", Utility.DARKER_GRAY_COLOR));
        labelList.add(businessOwnership);
        labelList.add(new SubTotalAmountLabel("Total Invested Assets"));
        
        // Use Assets
        labelList.add(new SubCategoryLabel("Use Assets", Utility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Principal home", Utility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Vacation home", Utility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Cars, trucks, boats", Utility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Home furnishings", Utility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Art, antiques, coins, collectibles", Utility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Jewelry, furs", Utility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Other", Utility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new SubTotalAmountLabel("Total Use Assets"));
        
        int xPos = 0;
        for(int i = 0; i < labelList.size(); i++) {
            
            assetsGridPane.add(labelList.get(i), xPos, i);
        }
    }
    
    private void addMainComponentsToVBox() {
        
        this.getChildren().addAll(categoryTitle, scrollPane);
    }
}
