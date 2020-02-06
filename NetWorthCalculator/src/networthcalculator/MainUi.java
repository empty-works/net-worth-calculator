/*
 */
package networthcalculator;

import networthcalculator.containers.LiabilitiesContainer;
import networthcalculator.containers.AssetsContainer;

/**
 *
 * @author MP
 */
public class MainUi extends javafx.scene.layout.BorderPane {
    
    public MainUi() {
        
        addLabels();
    }
    
    private void addLabels() {
        
        // ASSETS
        AssetsContainer ac = new AssetsContainer();
        ac.prefWidthProperty().bind(this.widthProperty().divide(2)); // w * 1/2
        this.setLeft(ac);
        
        // LIABILITIES
        LiabilitiesContainer lc = new LiabilitiesContainer();
        lc.prefWidthProperty().bind(this.widthProperty().divide(2)); // w * 1/2
        this.setRight(lc);
    }
}
