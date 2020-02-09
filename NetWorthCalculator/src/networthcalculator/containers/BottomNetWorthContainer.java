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
    private double PREF_HEIGHT = 100;
    
    public BottomNetWorthContainer() {
        
        this.prefHeight(PREF_HEIGHT);
        this.minHeight(PREF_HEIGHT);
        this.setPadding(new Insets(15));
        
        setLabels();
    }
    
    private void setLabels() {
        
        //TODO Fix height of labels
        
        totalAssets.prefWidthProperty().bind(this.widthProperty().divide(3));
        totalAssets.setText("YOOOOOOOOOOOOOOOOOOOOO");
        this.add(totalAssets, 0, 0);
        
        totalLiabilities.prefWidthProperty().bind(this.widthProperty().divide(3));
        totalLiabilities.setText("HEEEEEEEEYYYYYYYYYYYYYYYYYYYYY");
        this.add(totalLiabilities, 1, 0);
        
        netWorth.prefWidthProperty().bind(this.widthProperty().divide(3));
        netWorth.setText("WHAT UP");
        this.add(netWorth, 2, 0);
    }
}
