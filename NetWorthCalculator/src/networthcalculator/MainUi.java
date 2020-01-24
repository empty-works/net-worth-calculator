/*
 */
package networthcalculator;

import javafx.scene.layout.ColumnConstraints;

/**
 *
 * @author MP
 */
public class MainUi extends javafx.scene.layout.GridPane {
    
    public void MainUi() {
        
        setColumnConstraints();
        addLabels();
    }
    
    private void setColumnConstraints() {
        
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(100);
    }
    
    
    
    private void addLabels() {
        
        
        add(new CategoryLabel("Assets"), 0, 0);
    }
}
