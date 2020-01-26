/*
 */
package networthcalculator.labels;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.scene.control.Label;

/**
 *
 * @author MP
 */
public class CategoryLabel extends javafx.scene.layout.AnchorPane {
    
    private Label label = new Label();
    
    public CategoryLabel(String text) {
        
        System.out.println("Label text: " + text);
        label.setText(text);
        setBackground();
        setSetSize();
    }
                
    private void setSetSize() {
        
        this.setPrefHeight(100);
        
    }
    
    private void setBackground() {
        
        BackgroundFill bgf = new BackgroundFill(
                Paint.valueOf("orange"), 
                new CornerRadii(0.5), 
                new Insets(0.5, 0.5, 0.5, 0.5));
        this.setBackground(new Background(bgf));
    }
}
