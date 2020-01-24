/*
 */
package networthcalculator;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 *
 * @author MP
 */
public class CategoryLabel extends javafx.scene.control.Label {
    
    public CategoryLabel(String text) {
        
        setText(text);
        setBackground();
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
