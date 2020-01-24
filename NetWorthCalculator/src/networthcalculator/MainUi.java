/*
 */
package networthcalculator;

/**
 *
 * @author MP
 */
public class MainUi extends javafx.scene.layout.GridPane {
    
    public void MainUi() {
        
        addLabels();
    }
    
    private void addLabels() {
        
        add(new CategoryLabel("Assets"), 0, 0);
    }
}
