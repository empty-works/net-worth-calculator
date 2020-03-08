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
    private CurrencyChanger currencyChanger;
    
    public AssetsContainer(TotalAmount totalAmount, CurrencyChanger currencyChanger) {
        
        this.totalAmount = totalAmount;
        this.currencyChanger = currencyChanger;
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
        cashSubCatCon.addAmountLabel(new AmountLabel("Checking accounts", lightGray, currencyChanger));
        cashSubCatCon.addAmountLabel(new AmountLabel("Savings accounts", lightGray, currencyChanger));
        cashSubCatCon.addAmountLabel(new AmountLabel("Money market accounts", lightGray, currencyChanger));
        cashSubCatCon.addAmountLabel(new AmountLabel("Savings bonds", lightGray, currencyChanger));
        cashSubCatCon.addAmountLabel(new AmountLabel("CD's", lightGray, currencyChanger));
        cashSubCatCon.addAmountLabel(new AmountLabel("Cash value of life insurance", lightGray, currencyChanger));
        cashSubCatCon.setSubTotalLabel(new SubTotalAmountLabel("Total Cash", totalAmount));
        cashSubCatCon.showLabels();
        labelList.add(cashSubCatCon);
                
        // Invested Assets
        SubCategoryContainer investedAssetsSubCatCon = new SubCategoryContainer(
                "Invested Assets", darkGray, new AccCategoryAssets());
        
        TitleAndAmountLabel taxableAccount = new TitleAndAmountLabel(
                "Taxable account", darkGray, investedAssetsSubCatCon);
        taxableAccount.addAllAmountLabels(new AmountLabel("Brokerage", darkGray, currencyChanger), 
                                          new AmountLabel("Other", darkGray, currencyChanger));
        investedAssetsSubCatCon.addTitleAmountLabel(taxableAccount);
        
        TitleAndAmountLabel retirementAccounts = new TitleAndAmountLabel(
                "Retirement accounts", darkGray, investedAssetsSubCatCon);
        retirementAccounts.addAllAmountLabels(new AmountLabel("IRA", darkGray, currencyChanger), 
                                          new AmountLabel("Roth IRA", darkGray, currencyChanger), 
                                          new AmountLabel("401(k) or 403(b)", darkGray, currencyChanger), 
                                          new AmountLabel("SEP-IRA", darkGray, currencyChanger), 
                                          new AmountLabel("Pension (vested benefit)", darkGray, currencyChanger), 
                                          new AmountLabel("Annuity (accumulated value)", darkGray, currencyChanger), 
                                          new AmountLabel("Annuity (accumulated value)", darkGray, currencyChanger));
        investedAssetsSubCatCon.addTitleAmountLabel(retirementAccounts);
        
        TitleAndAmountLabel businessOwnership = new TitleAndAmountLabel(
                "Business ownership interests", darkGray, investedAssetsSubCatCon);
        businessOwnership.addAllAmountLabels(new AmountLabel("Real estate", darkGray, currencyChanger), 
                                          new AmountLabel("Sole propietorship", darkGray, currencyChanger), 
                                          new AmountLabel("Partnership", darkGray, currencyChanger), 
                                          new AmountLabel("C Corporation", darkGray, currencyChanger), 
                                          new AmountLabel("S Corporation", darkGray, currencyChanger), 
                                          new AmountLabel("Limited liability company", darkGray, currencyChanger), 
                                          new AmountLabel("Other", darkGray, currencyChanger));
        investedAssetsSubCatCon.addTitleAmountLabel(businessOwnership);
        
        investedAssetsSubCatCon.setSubTotalLabel(new SubTotalAmountLabel("Total Invested Assets", totalAmount));
        
        investedAssetsSubCatCon.showLabels();
        labelList.add(investedAssetsSubCatCon);
        
        //Use Assets
        SubCategoryContainer useAssetsSubCatCon = new SubCategoryContainer(
                "Use Assets", lightGray, new AccCategoryAssets());
        useAssetsSubCatCon.addAmountLabel(new AmountLabel("Principal home", lightGray, currencyChanger));
        useAssetsSubCatCon.addAmountLabel(new AmountLabel("Vacation home", lightGray, currencyChanger));
        useAssetsSubCatCon.addAmountLabel(new AmountLabel("Cars, trucks, boats", lightGray, currencyChanger));
        useAssetsSubCatCon.addAmountLabel(new AmountLabel("Home furnishings", lightGray, currencyChanger));
        useAssetsSubCatCon.addAmountLabel(new AmountLabel("Art, antiques, coins, collectibles", lightGray, currencyChanger));
        useAssetsSubCatCon.addAmountLabel(new AmountLabel("Jewelry, furs", lightGray, currencyChanger));
        useAssetsSubCatCon.addAmountLabel(new AmountLabel("Other", lightGray, currencyChanger));
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
