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
    
    private Label categoryLabel = new Label();
    
    public CategoryLabel(String text) {
        
        System.out.println("Label text: " + text);
        categoryLabel.setText(text);
        setLabelProperties();
        setSetSize();
    }
    
    private void setLabelProperties() {
        
        setBackground();
        this.getChildren().add(categoryLabel);
    }
                
    private void setSetSize() {
        
        categoryLabel.setPrefHeight(100);
        AnchorPane.setRightAnchor(categoryLabel, 0.0);
        AnchorPane.setLeftAnchor(categoryLabel, 0.0);
    }
    
    private void setBackground() {
        
        BackgroundFill bgf = new BackgroundFill(
                Paint.valueOf("orange"), 
                new CornerRadii(0.5), 
                new Insets(0.5, 0.5, 0.5, 0.5));
        categoryLabel.setBackground(new Background(bgf));
    }
}
