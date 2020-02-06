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
    
    private Label subcategoryLabel = new Label(); 
            
    final private int PREF_HEIGHT = 25; // Height will not go below this due to padding.
    
    public SubCategoryLabel(String text) {
        
        subcategoryLabel.setText(text);
        this.setId("SubCategoryLabel");
        setBackground("lightgray"); // Default color
        setLabelProperties();
    }
    
    public SubCategoryLabel(String text, String bgColor) {
        
        subcategoryLabel.setText(text);
        this.setId("SubCategoryLabel");
        setBackground(bgColor);
        setLabelProperties();
    }
    
    // Check stylesheet for stylings.
    private void setLabelProperties() {

        this.getChildren().add(subcategoryLabel);
        subcategoryLabel.setPrefHeight(PREF_HEIGHT);
        subcategoryLabel.setPadding(new Insets(15));
        AnchorPane.setRightAnchor(subcategoryLabel, 0.0);
        AnchorPane.setLeftAnchor(subcategoryLabel, 0.0);
    }
    
    public void setBackground(String bgColor, 
            double topLeft, 
            double topRight, 
            double bottomRight, 
            double bottomLeft) {
        
        BackgroundFill bgf = new BackgroundFill(
                Paint.valueOf(bgColor), 
                new CornerRadii(topLeft, topRight, bottomRight, bottomLeft, false), 
                new Insets(0.5));
        subcategoryLabel.setBackground(new Background(bgf));
    }
    
    public void setBackground(String bgColor) {
        
        BackgroundFill bgf = new BackgroundFill(
                Paint.valueOf(bgColor), 
                new CornerRadii(5.5, false), 
                new Insets(0.5));
        subcategoryLabel.setBackground(new Background(bgf));
    }
}
