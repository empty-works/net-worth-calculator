/*
 */
package networthcalculator;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.scene.layout.GridPane;

/**
 *
 * @author MP
 */
public class MainUi extends javafx.scene.control.ScrollPane {
    
    private GridPane grid = new GridPane();
    
    public MainUi() {
        
        setColumnConstraints();
        addLabels();
    }
    
    private void setColumnConstraints() {
        
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(100);
        column1.setHgrow(Priority.ALWAYS);
        grid.getColumnConstraints().addAll(column1);
        System.out.println("Added column constraints to grid pane...");
    }
    
    private void addLabels() {
        
        grid.add(new CategoryLabel("Assets"), 0, 0);
    }
}
