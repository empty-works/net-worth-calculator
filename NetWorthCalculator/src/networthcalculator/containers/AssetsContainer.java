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
import networthcalculator.labels.SubCategoryLabel;
import networthcalculator.labels.SubTotalAmountLabel;
import networthcalculator.labels.TitleAndAmountLabel;
import networthcalculator.labels.labelsubclasses.AssetsCategoryLabel;
import networthcalculator.labels.labelsubclasses.InvestedAssetsAmountLabel;
import networthcalculator.labels.labelsubclasses.InvestedAssetsSubTotalAmountLabel;

/**
 *
 * @author MP
 */
public class AssetsContainer extends javafx.scene.layout.VBox {
    
    private ScrollPane scrollPane = new ScrollPane();
    private GridPane assetsGridPane = new GridPane();
    private AssetsCategoryLabel categoryTitle = new AssetsCategoryLabel("ASSETS", "CURRENT VALUE");
    private String darkGray = "darkgray";
    private String lightGray = "lightgray";
    
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
        SubCategoryContainer subCatCon = new SubCategoryContainer("Cash and Cash Equivalents", lightGray);
        subCatCon.addLabel(new SubCategoryLabel("Cash and Cash Equivalents", lightGray));
        subCatCon.addLabel(new SubCategoryLabel("Cash and Cash Equivalents", lightGray));
                
        InvestedAssetsSubTotalAmountLabel investAssetsSubTotal = new InvestedAssetsSubTotalAmountLabel("Total Cash");
        labelList.add(new SubCategoryLabel("Cash and Cash Equivalents", lightGray));
        labelList.add(new InvestedAssetsAmountLabel("Checking accounts", lightGray, investAssetsSubTotal));
        labelList.add(new InvestedAssetsAmountLabel("Savings accounts", lightGray, investAssetsSubTotal));
        labelList.add(new InvestedAssetsAmountLabel("Money market accounts", lightGray, investAssetsSubTotal));
        labelList.add(new InvestedAssetsAmountLabel("Savings bonds", lightGray, investAssetsSubTotal));
        labelList.add(new InvestedAssetsAmountLabel("CD's", lightGray, investAssetsSubTotal));
        labelList.add(new InvestedAssetsAmountLabel("Cash value of life insurance", lightGray, investAssetsSubTotal));
        labelList.add(investAssetsSubTotal);
        
        // Invested Assets
        labelList.add(new SubCategoryLabel("Invested Assets", darkGray));
        
        TitleAndAmountLabel taxableAccount = new TitleAndAmountLabel("Taxable account", darkGray);
        taxableAccount.addAllAmountLabels(new AmountLabel("Brokerage", darkGray), 
                                          new AmountLabel("Other", darkGray));
        labelList.add(taxableAccount);
        
        TitleAndAmountLabel retirementAccounts = new TitleAndAmountLabel("Retirement accounts", darkGray);
        retirementAccounts.addAllAmountLabels(new AmountLabel("IRA", darkGray), 
                                          new AmountLabel("Roth IRA", darkGray), 
                                          new AmountLabel("401(k) or 403(b)", darkGray), 
                                          new AmountLabel("SEP-IRA", darkGray), 
                                          new AmountLabel("Pension (vested benefit)", darkGray), 
                                          new AmountLabel("Annuity (accumulated value)", darkGray), 
                                          new AmountLabel("Annuity (accumulated value)", darkGray));
        labelList.add(retirementAccounts);
        
        TitleAndAmountLabel businessOwnership = new TitleAndAmountLabel("Business ownership interests", darkGray);
        businessOwnership.addAllAmountLabels(new AmountLabel("Real estate", darkGray), 
                                          new AmountLabel("Sole propietorship", darkGray), 
                                          new AmountLabel("Partnership", darkGray), 
                                          new AmountLabel("C Corporation", darkGray), 
                                          new AmountLabel("S Corporation", darkGray), 
                                          new AmountLabel("Limited liability company", darkGray), 
                                          new AmountLabel("Other", darkGray));
        labelList.add(businessOwnership);
        labelList.add(new SubTotalAmountLabel("Total Invested Assets"));
        
        // Use Assets
        labelList.add(new SubCategoryLabel("Use Assets", lightGray));
        labelList.add(new AmountLabel("Principal home", lightGray));
        labelList.add(new AmountLabel("Vacation home", lightGray));
        labelList.add(new AmountLabel("Cars, trucks, boats", lightGray));
        labelList.add(new AmountLabel("Home furnishings", lightGray));
        labelList.add(new AmountLabel("Art, antiques, coins, collectibles", lightGray));
        labelList.add(new AmountLabel("Jewelry, furs", lightGray));
        labelList.add(new AmountLabel("Other", lightGray));
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
