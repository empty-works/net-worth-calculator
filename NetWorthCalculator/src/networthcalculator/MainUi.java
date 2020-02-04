/*
 */
package networthcalculator;

import javafx.geometry.HPos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;

/**
 *
 * @author MP
 */
public class MainUi extends javafx.scene.layout.GridPane {
    
    public MainUi() {
        
        setColumnConstraints();
        addLabels();
    }
    
    private void setColumnConstraints() {
        
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(100);
        column1.setHgrow(Priority.ALWAYS);
        column1.setHalignment(HPos.CENTER);
        this.getColumnConstraints().addAll(column1);
        System.out.println("Added column constraints to grid pane...");
    }
    
    private void addLabels() {
        
        // ASSETS
        this.add(new AssetsContainer(), 0, 1);
    }
}
