/*
 */
package networthcalculator.labels;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;

/**
 *
 * @author MP
 */
public class SubCategoryLabel extends javafx.scene.layout.AnchorPane {
    
    private Label label = new Label();
    
    public SubCategoryLabel(String text) {
        
        System.out.println("Label text: " + text);
        label.setText(text);
        setLabelProperties();
        setSetSize();
    }
    
    private void setLabelProperties() {
        
        setBackground();
        this.getChildren().add(label);
    }
                
    private void setSetSize() {
        
        label.setPrefHeight(75);
        AnchorPane.setRightAnchor(label, 0.0);
        AnchorPane.setLeftAnchor(label, 0.0);
    }
    
    private void setBackground() {
        
        BackgroundFill bgf = new BackgroundFill(
                Paint.valueOf("gray"), 
                new CornerRadii(0.5), 
                new Insets(0.5, 0.5, 0.5, 0.5));
        label.setBackground(new Background(bgf));
    }
}
