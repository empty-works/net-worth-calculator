/*
 */
package networthcalculator.containers;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import networthcalculator.Utility;

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
        setLabels();
    }
    
    private void setLabels() {
        
        totalAssets.setStyle("-fx-background-color:" + Utility.DEFAULT_LABEL_GRAY_COLOR);
        totalAssets.prefWidthProperty().bind(this.widthProperty().divide(3));
        totalAssets.setText("Total Assets:");
        totalAssets.setPadding(new Insets(10, 0, 10, 0)); // Allows for height change. Setting height directly does not work.
        this.add(totalAssets, 0, 0);
        
        totalLiabilities.setStyle("-fx-background-color:" + Utility.DARKER_GRAY_COLOR);
        totalLiabilities.prefWidthProperty().bind(this.widthProperty().divide(3));
        totalLiabilities.setText("Total Liabilities:");
        totalLiabilities.setPadding(new Insets(10, 0, 10, 0)); // Allows for height change. Setting height directly does not work.
        this.add(totalLiabilities, 1, 0);
        
        netWorth.setStyle("-fx-background-color:" + Utility.MONEY_GREEN);
        netWorth.prefWidthProperty().bind(this.widthProperty().divide(3));
        netWorth.setText("Net Worth:");
        netWorth.setPadding(new Insets(10, 0, 10, 0)); // Allows for height change. Setting height directly does not work.
        this.add(netWorth, 2, 0);
    }
}
