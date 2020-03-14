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
import networthcalculator.labels.TitleAndAmountLabel;
import networthcalculator.labels.labelsubclasses.AssetsCategoryLabel;
import networthcalculator.labels.labelsubclasses.AccCategoryAssets;
import networthcalculator.utilities.CurrencyChanger;

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
    private TotalAmount totalAmount;
    private CurrencyChanger changer;
    
    public AssetsContainer(TotalAmount totalAmount, CurrencyChanger changer) {
        
        this.totalAmount = totalAmount;
        this.changer = changer;
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
        
        List<SubCategoryContainer> labelList = new ArrayList<>();

        // Cash and Cash Equivalents - default color
        SubCategoryContainer cashSubCatCon = new SubCategoryContainer(
                "Cash and Cash Equivalents", lightGray, new AccCategoryAssets());
        cashSubCatCon.addAmountLabel("Checking accounts", changer);
        cashSubCatCon.addAmountLabel("Savings accounts", changer);
        cashSubCatCon.addAmountLabel("Money market accounts", changer);
        cashSubCatCon.addAmountLabel("Savings bonds", changer);
        cashSubCatCon.addAmountLabel("CD's", changer);
        cashSubCatCon.addAmountLabel("Cash value of life insurance", changer);
        cashSubCatCon.setSubTotalLabel(new SubTotalAmountLabel("Total Cash", totalAmount));
        cashSubCatCon.showLabels();
        labelList.add(cashSubCatCon);
                
        // Invested Assets
        SubCategoryContainer investedAssetsSubCatCon = new SubCategoryContainer(
                "Invested Assets", darkGray, new AccCategoryAssets());
        
        TitleAndAmountLabel taxableAccount = new TitleAndAmountLabel(
                "Taxable account", darkGray, investedAssetsSubCatCon);
        taxableAccount.addAllAmountLabels(new AmountLabel("Brokerage", darkGray), 
                                          new AmountLabel("Other", darkGray));
        investedAssetsSubCatCon.addTitleAmountLabel(taxableAccount);
        
        TitleAndAmountLabel retirementAccounts = new TitleAndAmountLabel(
                "Retirement accounts", darkGray, investedAssetsSubCatCon);
        retirementAccounts.addAllAmountLabels(
                                          new AmountLabel("IRA", darkGray), 
                                          new AmountLabel("Roth IRA", darkGray), 
                                          new AmountLabel("401(k) or 403(b)", darkGray), 
                                          new AmountLabel("SEP-IRA", darkGray), 
                                          new AmountLabel("Pension (vested benefit)", darkGray), 
                                          new AmountLabel("Annuity (accumulated value)", darkGray), 
                                          new AmountLabel("Annuity (accumulated value)", darkGray));
        investedAssetsSubCatCon.addTitleAmountLabel(retirementAccounts);
        
        TitleAndAmountLabel businessOwnership = new TitleAndAmountLabel(
                "Business ownership interests", darkGray, investedAssetsSubCatCon);
        businessOwnership.addAllAmountLabels(new AmountLabel("Real estate", darkGray), 
                                          new AmountLabel("Sole propietorship", darkGray), 
                                          new AmountLabel("Partnership", darkGray), 
                                          new AmountLabel("C Corporation", darkGray), 
                                          new AmountLabel("S Corporation", darkGray), 
                                          new AmountLabel("Limited liability company", darkGray), 
                                          new AmountLabel("Other", darkGray));
        investedAssetsSubCatCon.addTitleAmountLabel(businessOwnership);
        
        investedAssetsSubCatCon.setSubTotalLabel(new SubTotalAmountLabel("Total Invested Assets", totalAmount));
        
        investedAssetsSubCatCon.showLabels();
        labelList.add(investedAssetsSubCatCon);
        
        //Use Assets
        SubCategoryContainer useAssetsSubCatCon = new SubCategoryContainer(
                "Use Assets", lightGray, new AccCategoryAssets());
        useAssetsSubCatCon.addAmountLabel(new AmountLabel("Principal home", lightGray));
        useAssetsSubCatCon.addAmountLabel(new AmountLabel("Vacation home", lightGray));
        useAssetsSubCatCon.addAmountLabel(new AmountLabel("Cars, trucks, boats", lightGray));
        useAssetsSubCatCon.addAmountLabel(new AmountLabel("Home furnishings", lightGray));
        useAssetsSubCatCon.addAmountLabel(new AmountLabel("Art, antiques, coins, collectibles", lightGray));
        useAssetsSubCatCon.addAmountLabel(new AmountLabel("Jewelry, furs", lightGray));
        useAssetsSubCatCon.addAmountLabel(new AmountLabel("Other", lightGray));
        useAssetsSubCatCon.setSubTotalLabel(new SubTotalAmountLabel("Total Use Assets", totalAmount));
        
        useAssetsSubCatCon.showLabels();
        labelList.add(useAssetsSubCatCon);
        
        int xPos = 0;
        for(int i = 0; i < labelList.size(); i++) {
            
            assetsGridPane.add(labelList.get(i), xPos, i);
        }
    }
    
    private void addMainComponentsToVBox() {
        
        this.getChildren().addAll(categoryTitle, scrollPane);
    }
}
