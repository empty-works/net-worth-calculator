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
import networthcalculator.SetSizes;

/**
 *
 * @author MP
 */
public class SubCategoryLabel extends javafx.scene.layout.AnchorPane {
    
    private Label subcategoryLabel = new Label();
    final private int PREF_HEIGHT = 55;
    
    public SubCategoryLabel(String text) {
        
        subcategoryLabel.setText(text);
        this.setId("SubCategoryLabel");
        setLabelProperties();
        setBackground();
        this.setMaxWidth(SetSizes.MAX_WIDTH);
    }
    
    private void setLabelProperties() {

        this.getChildren().add(subcategoryLabel);
        subcategoryLabel.setPrefHeight(PREF_HEIGHT);
        AnchorPane.setRightAnchor(subcategoryLabel, 0.0);
        AnchorPane.setLeftAnchor(subcategoryLabel, 0.0);
    }
    
    private void setBackground() {
        
        BackgroundFill bgf = new BackgroundFill(
                Paint.valueOf("gray"), 
                new CornerRadii(5.5), 
                new Insets(0.5, 0.5, 0.5, 0.5));
        subcategoryLabel.setBackground(new Background(bgf));
    }
}
