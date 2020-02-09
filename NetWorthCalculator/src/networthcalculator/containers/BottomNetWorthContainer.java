/*
 */
package networthcalculator.containers;

import javafx.geometry.Insets;
import javafx.scene.control.Label;

/**
 *
 * @author MP
 */
public class BottomNetWorthContainer extends javafx.scene.layout.GridPane {
    
    private Label totalAssets = new Label();
    private Label totalLiabilities = new Label();
    private Label netWorth = new Label();
    
    public BottomNetWorthContainer() {
        
        this.setId("BottomNetWorthContainer");
        //this.setPadding(new Insets(0, 10, 0, 10)); // Allows for height change. Setting height directly does not work.
        
        setLabels();
    }
    
    private void setLabels() {
        
        totalAssets.setId("TotalAssets");
        totalAssets.prefWidthProperty().bind(this.widthProperty().divide(3));
        totalAssets.setText("Total Assets:");
        totalAssets.setPadding(new Insets(10, 0, 10, 0));
        
        this.add(totalAssets, 0, 0);
        
        totalLiabilities.prefWidthProperty().bind(this.widthProperty().divide(3));
        totalLiabilities.setText("Total Liabilities:");
        totalLiabilities.setPadding(new Insets(10, 0, 10, 0));
        this.add(totalLiabilities, 1, 0);
        
        netWorth.prefWidthProperty().bind(this.widthProperty().divide(3));
        netWorth.setText("Net Worth:");
        netWorth.setPadding(new Insets(10, 0, 10, 0));
        this.add(netWorth, 2, 0);
    }
    
    
}
