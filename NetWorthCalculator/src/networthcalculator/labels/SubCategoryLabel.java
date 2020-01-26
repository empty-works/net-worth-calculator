/*
 */
package networthcalculator.labels;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
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
        setBackground();
        setSetSize();
    }
    
    private void setSetSize() {
        
        this.setPrefHeight(75);
        
    }
    
    private void setBackground() {
        
        BackgroundFill bgf = new BackgroundFill(
                Paint.valueOf("gray"), 
                new CornerRadii(0.5), 
                new Insets(0.5, 0.5, 0.5, 0.5));
        this.setBackground(new Background(bgf));
    }
}
