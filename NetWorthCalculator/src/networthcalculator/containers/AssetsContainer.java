/*
 */
package networthcalculator.containers;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import networthcalculator.labels.AmountLabel;
import networthcalculator.labels.CategoryLabel;
import networthcalculator.labels.SubCategoryLabel;
import networthcalculator.labels.SubTotalAmountLabel;

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

        // Cash and Cash Equivalents - default color
        assetsGridPane.add(new SubCategoryLabel("Cash and Cash Equivalents", DEFAULT_LABEL_GRAY_COLOR), 0, 0);
        assetsGridPane.add(new AmountLabel("Checking accounts", DEFAULT_LABEL_GRAY_COLOR), 0, 1);
        assetsGridPane.add(new AmountLabel("Savings accounts", DEFAULT_LABEL_GRAY_COLOR), 0, 2);
        assetsGridPane.add(new AmountLabel("Money market accounts", DEFAULT_LABEL_GRAY_COLOR), 0, 3);
        assetsGridPane.add(new AmountLabel("Savings bonds", DEFAULT_LABEL_GRAY_COLOR), 0, 4);
        assetsGridPane.add(new AmountLabel("CD's", DEFAULT_LABEL_GRAY_COLOR), 0, 5);
        assetsGridPane.add(new AmountLabel("Cash value of life insurance", DEFAULT_LABEL_GRAY_COLOR), 0, 6);
        assetsGridPane.add(new SubTotalAmountLabel("Total Cash"), 0, 7);
        
        //TODO: create another type of amount label that includes a subheader.
        // Invested Assets
        assetsGridPane.add(new SubCategoryLabel("Invested Assets", "#ffffff"), 0, 8);
        assetsGridPane.add(new AmountLabel("Taxable account - Brokerage", DARKER_GRAY_COLOR), 0, 9);
        assetsGridPane.add(new AmountLabel("Taxable account - Other", DARKER_GRAY_COLOR), 0, 10);
        assetsGridPane.add(new AmountLabel("Retirement accounts - IRA", DARKER_GRAY_COLOR), 0, 11);
        assetsGridPane.add(new AmountLabel("Retirement accounts - Roth IRA", DARKER_GRAY_COLOR), 0, 12);
        assetsGridPane.add(new AmountLabel("Retirement accounts - 401(k) or 403(b)", DARKER_GRAY_COLOR), 0, 13);
        assetsGridPane.add(new AmountLabel("Retirement accounts - SEP-IRA", DARKER_GRAY_COLOR), 0, 14);
        assetsGridPane.add(new AmountLabel("Retirement accounts - Pension (vested benefit)", DARKER_GRAY_COLOR), 0, 15);
        assetsGridPane.add(new AmountLabel("Retirement accounts - Annuity (accumulated value)", DARKER_GRAY_COLOR), 0, 16);
        assetsGridPane.add(new AmountLabel("Business ownership interests - Real estate", DARKER_GRAY_COLOR), 0, 17);
        assetsGridPane.add(new AmountLabel("Business ownership interests - Sole propietorship", DARKER_GRAY_COLOR), 0, 18);
        assetsGridPane.add(new AmountLabel("Business ownership interests - Partnership", DARKER_GRAY_COLOR), 0, 19);
        assetsGridPane.add(new AmountLabel("Business ownership interests - C Corporation", DARKER_GRAY_COLOR), 0, 20);
        assetsGridPane.add(new AmountLabel("Business ownership interests - S Corporation", DARKER_GRAY_COLOR), 0, 21);
        assetsGridPane.add(new AmountLabel("Business ownership interests - Limited liability company", DARKER_GRAY_COLOR), 0, 22);
        assetsGridPane.add(new AmountLabel("Business ownership interests - Other", DARKER_GRAY_COLOR), 0, 23);
        
        // Use Assets
        assetsGridPane.add(new SubCategoryLabel("Use Assets", DEFAULT_LABEL_GRAY_COLOR), 0, 24);
        assetsGridPane.add(new AmountLabel("Principal home", DEFAULT_LABEL_GRAY_COLOR), 0, 25);
        assetsGridPane.add(new AmountLabel("Vacation home", DEFAULT_LABEL_GRAY_COLOR), 0, 26);
        assetsGridPane.add(new AmountLabel("Cars, trucks, boats", DEFAULT_LABEL_GRAY_COLOR), 0, 27);
        assetsGridPane.add(new AmountLabel("Home furnishings", DEFAULT_LABEL_GRAY_COLOR), 0, 28);
        assetsGridPane.add(new AmountLabel("Art, antiques, coins, collectibles", DEFAULT_LABEL_GRAY_COLOR), 0, 29);
        assetsGridPane.add(new AmountLabel("Jewelry, furs", DEFAULT_LABEL_GRAY_COLOR), 0, 30);
        assetsGridPane.add(new AmountLabel("Other", DEFAULT_LABEL_GRAY_COLOR), 0, 31);
    }
    
    private void addMainComponentsToVBox() {
        
        this.getChildren().addAll(categoryTitle, scrollPane);
    }
}
