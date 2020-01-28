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

/**
 *
 * @author MP
 */
public class CategoryLabel extends javafx.scene.layout.AnchorPane {
    
    private Label categoryLabelLeft = new Label();
    private Label categoryLabelRight = new Label();
    
    
    public CategoryLabel(String text) {
        
        System.out.println("Label text: " + text);
        categoryLabelLeft.setText(text);
        categoryLabelLeft.setId("CategoryLabelLeft");
        categoryLabelRight.setText("RARA");
        categoryLabelRight.setId("CategoryLabelRight");
        setLabelProperties();
        setSetSize();
    }
    
    private void setLabelProperties() {
        
        setBackground();
        this.getChildren().addAll(categoryLabelLeft, categoryLabelRight);
    }
                
    private void setSetSize() {
        
        categoryLabelLeft.setPrefHeight(100);
        categoryLabelRight.setPrefHeight(100);
        AnchorPane.setRightAnchor(categoryLabelLeft, 50.0);
        AnchorPane.setLeftAnchor(categoryLabelLeft, 0.0);
        AnchorPane.setRightAnchor(categoryLabelRight, 0.0);
        AnchorPane.setLeftAnchor(categoryLabelRight, 50.0);
    }
    
    private void setBackground() {
        
        BackgroundFill bgf = new BackgroundFill(
                Paint.valueOf("orange"), 
                new CornerRadii(0.5), 
                new Insets(0.5, 0.5, 0.5, 0.5));
        categoryLabelLeft.setBackground(new Background(bgf));
    }
}
