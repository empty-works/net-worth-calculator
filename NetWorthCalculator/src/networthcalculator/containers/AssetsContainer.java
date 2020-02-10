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
import networthcalculator.labels.SubCategoryLabel;
import networthcalculator.labels.SubTotalAmountLabel;
import networthcalculator.labels.TitleAndAmountLabel;
import networthcalculator.labels.labelsubclasses.AssetsCategoryLabel;

/**
 *
 * @author MP
 */
public class AssetsContainer extends javafx.scene.layout.VBox {
    
    private ScrollPane scrollPane = new ScrollPane();
    private GridPane assetsGridPane = new GridPane();
    private AssetsCategoryLabel categoryTitle = new AssetsCategoryLabel("ASSETS", "CURRENT VALUE");
    
    public AssetsContainer() {
        
        setColumnConstraints();
        setGridProperties();
        setScrollPaneProperties();
        addLabels();
        addMainComponentsToVBox();
        this.setPadding(new Insets(10, 0, 0, 0)); // Adds space to the top.
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
        labelList.add(new SubCategoryLabel("Cash and Cash Equivalents", MyUtility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Checking accounts", MyUtility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Savings accounts", MyUtility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Money market accounts", MyUtility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Savings bonds", MyUtility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("CD's", MyUtility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Cash value of life insurance", MyUtility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new SubTotalAmountLabel("Total Cash"));
        
        // Invested Assets
        labelList.add(new SubCategoryLabel("Invested Assets", MyUtility.DARKER_GRAY_COLOR));
        
        TitleAndAmountLabel taxableAccount = new TitleAndAmountLabel("Taxable account", MyUtility.DARKER_GRAY_COLOR);
        taxableAccount.addAllAmountLabels(new AmountLabel("Brokerage", MyUtility.DARKER_GRAY_COLOR), 
                                          new AmountLabel("Other", MyUtility.DARKER_GRAY_COLOR));
        labelList.add(taxableAccount);
        
        TitleAndAmountLabel retirementAccounts = new TitleAndAmountLabel("Retirement accounts", MyUtility.DARKER_GRAY_COLOR);
        retirementAccounts.addAllAmountLabels(new AmountLabel("IRA", MyUtility.DARKER_GRAY_COLOR), 
                                          new AmountLabel("Roth IRA", MyUtility.DARKER_GRAY_COLOR), 
                                          new AmountLabel("401(k) or 403(b)", MyUtility.DARKER_GRAY_COLOR), 
                                          new AmountLabel("SEP-IRA", MyUtility.DARKER_GRAY_COLOR), 
                                          new AmountLabel("Pension (vested benefit)", MyUtility.DARKER_GRAY_COLOR), 
                                          new AmountLabel("Annuity (accumulated value)", MyUtility.DARKER_GRAY_COLOR), 
                                          new AmountLabel("Annuity (accumulated value)", MyUtility.DARKER_GRAY_COLOR));
        labelList.add(retirementAccounts);
        
        TitleAndAmountLabel businessOwnership = new TitleAndAmountLabel("Business ownership interests", MyUtility.DARKER_GRAY_COLOR);
        businessOwnership.addAllAmountLabels(new AmountLabel("Real estate", MyUtility.DARKER_GRAY_COLOR), 
                                          new AmountLabel("Sole propietorship", MyUtility.DARKER_GRAY_COLOR), 
                                          new AmountLabel("Partnership", MyUtility.DARKER_GRAY_COLOR), 
                                          new AmountLabel("C Corporation", MyUtility.DARKER_GRAY_COLOR), 
                                          new AmountLabel("S Corporation", MyUtility.DARKER_GRAY_COLOR), 
                                          new AmountLabel("Limited liability company", MyUtility.DARKER_GRAY_COLOR), 
                                          new AmountLabel("Other", MyUtility.DARKER_GRAY_COLOR));
        labelList.add(businessOwnership);
        labelList.add(new SubTotalAmountLabel("Total Invested Assets"));
        
        // Use Assets
        labelList.add(new SubCategoryLabel("Use Assets", MyUtility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Principal home", MyUtility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Vacation home", MyUtility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Cars, trucks, boats", MyUtility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Home furnishings", MyUtility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Art, antiques, coins, collectibles", MyUtility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Jewelry, furs", MyUtility.DEFAULT_LABEL_GRAY_COLOR));
        labelList.add(new AmountLabel("Other", MyUtility.DEFAULT_LABEL_GRAY_COLOR));
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
