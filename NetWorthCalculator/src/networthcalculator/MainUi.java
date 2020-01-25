/*
 */
package networthcalculator;

import java.awt.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

/**
 *
 * @author MP
 */
public class MainUi extends javafx.scene.control.ScrollPane {
    
    private GridPane grid = new GridPane();
    private AnchorPane anchor = new AnchorPane();
    
    public MainUi() {
        
        setColumnConstraints();
        addLabels();
        setScrollPaneProperties();
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
    
    private void setScrollPaneProperties() {
        
        this.fitToWidthProperty().set(true);
        this.setPannable(true);
        this.setContent(grid);
    }
}
