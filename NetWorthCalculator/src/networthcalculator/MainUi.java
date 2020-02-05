/*
 */
package networthcalculator;

import networthcalculator.containers.LiabilitiesContainer;
import networthcalculator.containers.AssetsContainer;
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
        ColumnConstraints column2 = new ColumnConstraints();
        column1.setPercentWidth(100);
        column1.setHgrow(Priority.ALWAYS);
        column1.setHalignment(HPos.CENTER);
        column2.setPercentWidth(100);
        column2.setHgrow(Priority.ALWAYS);
        column2.setHalignment(HPos.CENTER);
        this.getColumnConstraints().addAll(column1, column2);
        System.out.println("Added column constraints to grid pane...");
    }
    
    private void addLabels() {
        
        // ASSETS
        this.add(new AssetsContainer(), 0, 0);
        
        // LIABILITIES
        this.add(new LiabilitiesContainer(), 1, 0);
    }
}
