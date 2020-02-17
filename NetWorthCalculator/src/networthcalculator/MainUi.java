/*
 */
package networthcalculator;

import networthcalculator.containers.LiabilitiesContainer;
import networthcalculator.containers.AssetsContainer;
import networthcalculator.containers.BottomNetWorthContainer;

/**
 *
 * @author MP
 */
public class MainUi extends javafx.scene.layout.BorderPane {
    
    public MainUi() {
        
        addLabels();
    }
    
    private void addLabels() {
        
        // Bottom container amounts
        BottomNetWorthContainer netCon = new BottomNetWorthContainer();
        netCon.prefWidthProperty().bind(this.widthProperty());
        this.setBottom(netCon);
        
        TotalAmount totalAmount = new TotalAmount(netCon);
        
        // ASSETS
        AssetsContainer ac = new AssetsContainer(totalAmount);
        ac.prefWidthProperty().bind(this.widthProperty().divide(2)); // w * 1/2
        this.setLeft(ac);
        
        // LIABILITIES
        LiabilitiesContainer lc = new LiabilitiesContainer(totalAmount);
        lc.prefWidthProperty().bind(this.widthProperty().divide(2)); // w * 1/2
        this.setRight(lc);
    }
}
