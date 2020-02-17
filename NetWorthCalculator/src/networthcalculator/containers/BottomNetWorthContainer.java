/*
 */
package networthcalculator.containers;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import networthcalculator.labels.interfaces.BottomContainerController;
import networthcalculator.labels.labelsubclasses.AccCategory;
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
    
    public BottomNetWorthContainer() {
        
        this.setId("BottomNetWorthContainer");
        setLabels();
    }
    
    private void setLabels() {
        
        totalAssets.setStyle("-fx-background-color:" + LEFT_COLOR);
        totalAssets.prefWidthProperty().bind(this.widthProperty().divide(3));
        totalAssets.setText("Total Assets:");
        totalAssets.setPadding(new Insets(DEFAULT_HEIGHT, 0, DEFAULT_HEIGHT, DEFAULT_LEFT_INDENT)); // Allows for height change. Setting height directly does not work.
        this.add(totalAssets, 0, 0);
        
        totalLiabilities.setStyle("-fx-background-color:" + MID_COLOR);
        totalLiabilities.prefWidthProperty().bind(this.widthProperty().divide(3));
        totalLiabilities.setText("Total Liabilities:");
        totalLiabilities.setPadding(new Insets(DEFAULT_HEIGHT, 0, DEFAULT_HEIGHT, DEFAULT_LEFT_INDENT)); // Allows for height change. Setting height directly does not work.
        this.add(totalLiabilities, 1, 0);
        
        netWorth.setStyle("-fx-background-color:" + RIGHT_COLOR);
        netWorth.prefWidthProperty().bind(this.widthProperty().divide(3));
        netWorth.setText("Net Worth:");
        netWorth.setPadding(new Insets(DEFAULT_HEIGHT, 0, DEFAULT_HEIGHT, DEFAULT_LEFT_INDENT)); // Allows for height change. Setting height directly does not work.
        this.add(netWorth, 2, 0);
    }

    @Override
    public void setAmounts(AccCategory category, double amount) {
        
        
    }
}
