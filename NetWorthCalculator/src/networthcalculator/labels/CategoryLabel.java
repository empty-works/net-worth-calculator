/*
 */
package networthcalculator.labels;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 *
 * @author MP
 */
public class CategoryLabel extends javafx.scene.layout.AnchorPane {
    
    private String text;
    private Label categoryLabelLeft = new Label();
    private Label categoryLabelRight = new Label();
    private GridPane grid = new GridPane();
    
    public CategoryLabel(String text) {
        
        System.out.println("Label text: " + text);
        this.text = text;
        setGrid();
        setLabelProperties();
        setSetSize();
        this.getChildren().addAll(grid);
    }
    
    private void setGrid() {
        
        // Set up column constraints
        ColumnConstraints columnCon = new ColumnConstraints();
        columnCon.setPercentWidth(50);
        columnCon.setHgrow(Priority.ALWAYS);
        grid.getColumnConstraints().add(columnCon);
        grid.addColumn(0, categoryLabelLeft);
        grid.setGridLinesVisible(true);
        grid.addColumn(1, categoryLabelRight);
    }
    
    private void setLabelProperties() {
        
        categoryLabelLeft.setText(text);
        categoryLabelLeft.setId("CategoryLabelLeft");
        categoryLabelRight.setText("RARA");
        categoryLabelRight.setId("CategoryLabelRight");
        
        setBackground();
    }
                
    private void setSetSize() {
        
        categoryLabelLeft.setPrefHeight(100);
        categoryLabelRight.setPrefHeight(100);
        
        AnchorPane.setLeftAnchor(grid, 0.0);
        AnchorPane.setRightAnchor(grid, 0.0);
        categoryLabelLeft.prefWidthProperty().bind(grid.widthProperty());
        categoryLabelRight.prefWidthProperty().bind(grid.widthProperty());
    }
    
    private void setBackground() {
        
        BackgroundFill bgf = new BackgroundFill(
                Paint.valueOf("orange"), 
                new CornerRadii(0.5), 
                new Insets(0.5, 0.5, 0.5, 0.5));
        categoryLabelLeft.setBackground(new Background(bgf));
        categoryLabelRight.setBackground(new Background(bgf));
    }
}
