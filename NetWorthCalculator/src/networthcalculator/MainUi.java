/*
 */
package networthcalculator;

import networthcalculator.containers.LiabilitiesContainer;
import networthcalculator.containers.AssetsContainer;

/**
 *
 * @author MP
 */
public class MainUi extends javafx.scene.layout.GridPane {
    
    public MainUi() {
        
        addLabels();
    }
    
    private void addLabels() {
        
        // ASSETS
        AssetsContainer ac = new AssetsContainer();
        ac.prefWidthProperty().bind(this.widthProperty().divide(2)); // w * 1/2
        this.add(ac, 0, 0);
        
        // LIABILITIES
        LiabilitiesContainer lc = new LiabilitiesContainer();
        lc.prefWidthProperty().bind(this.widthProperty().divide(2)); // w * 1/2
        this.add(lc, 1, 0);
    }
}
