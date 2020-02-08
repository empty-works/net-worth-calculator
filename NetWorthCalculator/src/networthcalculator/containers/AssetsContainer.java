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
    final private String DEFAULT_LABEL_GRAY_COLOR = "#e6e6e6";
    final private String DARKER_GRAY_COLOR = "#a6a6a6";
    
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
        labelList.add(new SubCategoryLabel("Cash and Cash Equivalents", DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Checking accounts", DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Savings accounts", DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Money market accounts", DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Savings bonds", DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("CD's", DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Cash value of life insurance", DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new SubTotalAmountLabel("Total Cash"));
        
        // Invested Assets
        labelList.add(new SubCategoryLabel("Invested Assets", DARKER_GRAY_COLOR));
        
        TitleAndAmountLabel taxableAccount = new TitleAndAmountLabel("Taxable account", DARKER_GRAY_COLOR);
        taxableAccount.addAllAmountLabels(new AmountLabel("Brokerage", DARKER_GRAY_COLOR), 
                                          new AmountLabel("Other", DARKER_GRAY_COLOR));
        labelList.add(taxableAccount);
        
        TitleAndAmountLabel retirementAccounts = new TitleAndAmountLabel("Retirement accounts", DARKER_GRAY_COLOR);
        retirementAccounts.addAllAmountLabels(new AmountLabel("IRA", DARKER_GRAY_COLOR), 
                                          new AmountLabel("Roth IRA", DARKER_GRAY_COLOR), 
                                          new AmountLabel("401(k) or 403(b)", DARKER_GRAY_COLOR), 
                                          new AmountLabel("SEP-IRA", DARKER_GRAY_COLOR), 
                                          new AmountLabel("Pension (vested benefit)", DARKER_GRAY_COLOR), 
                                          new AmountLabel("Annuity (accumulated value)", DARKER_GRAY_COLOR), 
                                          new AmountLabel("Annuity (accumulated value)", DARKER_GRAY_COLOR));
        labelList.add(retirementAccounts);
        
        TitleAndAmountLabel businessOwnership = new TitleAndAmountLabel("Business ownership interests", DARKER_GRAY_COLOR);
        businessOwnership.addAllAmountLabels(new AmountLabel("Real estate", DARKER_GRAY_COLOR), 
                                          new AmountLabel("Sole propietorship", DARKER_GRAY_COLOR), 
                                          new AmountLabel("Partnership", DARKER_GRAY_COLOR), 
                                          new AmountLabel("C Corporation", DARKER_GRAY_COLOR), 
                                          new AmountLabel("S Corporation", DARKER_GRAY_COLOR), 
                                          new AmountLabel("Limited liability company", DARKER_GRAY_COLOR), 
                                          new AmountLabel("Other", DARKER_GRAY_COLOR));
        labelList.add(businessOwnership);
        
        // Use Assets
        labelList.add(new SubCategoryLabel("Use Assets", DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Principal home", DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Vacation home", DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Cars, trucks, boats", DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Home furnishings", DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Art, antiques, coins, collectibles", DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Jewelry, furs", DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Other", DEFAULT_LABEL_GRAY_COLOR));
        
        int xPos = 0;
        for(int i = 0; i < labelList.size(); i++) {
            
            assetsGridPane.add(labelList.get(i), xPos, i);
        }
    }
    
    private void addMainComponentsToVBox() {
        
        this.getChildren().addAll(categoryTitle, scrollPane);
    }
}
