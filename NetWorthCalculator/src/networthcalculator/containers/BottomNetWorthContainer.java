/*
 */
package networthcalculator.containers;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import networthcalculator.labels.interfaces.BottomContainerController;
import networthcalculator.labels.labelsubclasses.AccCategory;
import networthcalculator.utilities.NumberReformatter;
/**
 *
 * @author MP
 */
public class BottomNetWorthContainer extends javafx.scene.layout.GridPane implements BottomContainerController {
    
    private Label totalAssets = new Label();
    private Label totalLiabilities = new Label();
    private Label netWorth = new Label();
    final private double DEFAULT_HEIGHT = 6;
    final private double DEFAULT_LEFT_INDENT = 10;
    final private String LEFT_COLOR = "lightgray";
    final private String MID_COLOR = "lightgray";
    final private String RIGHT_COLOR = "palegreen";
    final public String DEFAULT_AMOUNT = "0.00";
    private double currentAssetsTotal = 0.0, 
            currentLiabilitiesTotal = 0.0, 
            totalNetWorth = 0.0;
    
    public BottomNetWorthContainer() {
        
        this.setId("BottomNetWorthContainer");
        setLabels();
    }
    
    private void setLabels() {
        
        totalAssets.setStyle("-fx-background-color:" + LEFT_COLOR);
        totalAssets.prefWidthProperty().bind(this.widthProperty().divide(3));
        totalAssets.setText("Total Assets: " + NumberReformatter.reformat(currentAssetsTotal));
        totalAssets.setPadding(new Insets(DEFAULT_HEIGHT, 0, DEFAULT_HEIGHT, DEFAULT_LEFT_INDENT)); // Allows for height change. Setting height directly does not work.
        this.add(totalAssets, 0, 0);
        
        totalLiabilities.setStyle("-fx-background-color:" + MID_COLOR);
        totalLiabilities.prefWidthProperty().bind(this.widthProperty().divide(3));
        totalLiabilities.setText("Total Liabilities: " + NumberReformatter.reformat(currentLiabilitiesTotal));
        totalLiabilities.setPadding(new Insets(DEFAULT_HEIGHT, 0, DEFAULT_HEIGHT, DEFAULT_LEFT_INDENT)); // Allows for height change. Setting height directly does not work.
        this.add(totalLiabilities, 1, 0);
        
        netWorth.setStyle("-fx-background-color:" + RIGHT_COLOR);
        netWorth.prefWidthProperty().bind(this.widthProperty().divide(3));
        netWorth.setText("Net Worth: " + NumberReformatter.reformat(totalNetWorth));
        netWorth.setPadding(new Insets(DEFAULT_HEIGHT, 0, DEFAULT_HEIGHT, DEFAULT_LEFT_INDENT)); // Allows for height change. Setting height directly does not work.
        this.add(netWorth, 2, 0);
    }

    @Override
    public void setAmounts(AccCategory category, double subTotalDifference) {
        
        if(category.getCategory().equals(AccCategory.ASSETS)) {
            
            currentAssetsTotal += subTotalDifference;
            totalAssets.setText("Total Assets: " + NumberReformatter.reformat(currentAssetsTotal));
        }
        if(category.getCategory().equals(AccCategory.LIABILITIES)) {
            
            currentLiabilitiesTotal += subTotalDifference;
            totalLiabilities.setText("Total Liabilities: " + NumberReformatter.reformat(currentLiabilitiesTotal));
        }
        
        // Calculate total net worth
        totalNetWorth = currentAssetsTotal - currentLiabilitiesTotal;
        netWorth.setText("Net Worth: " + NumberReformatter.reformat(totalNetWorth));
    }
}
