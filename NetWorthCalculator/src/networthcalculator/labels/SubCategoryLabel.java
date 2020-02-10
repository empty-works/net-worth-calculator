/*
 */
package networthcalculator.labels;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import networthcalculator.MyUtility;

/**
 *
 * @author MP
 */
public class SubCategoryLabel extends javafx.scene.layout.AnchorPane {
    
    private Label subcategoryLabel = new Label(); 
            
    final private int PREF_HEIGHT = 60; // Height will not go below this due to padding.
    
    public SubCategoryLabel(String text, String bgColor) {
        
        subcategoryLabel.setId("SubCategoryLabel");
        subcategoryLabel.setText(text);
        this.setId("SubCategoryLabel");
        setProperties(bgColor);
        setLabelProperties();
        this.getChildren().add(subcategoryLabel);
    }
    
    // Check stylesheet for stylings.
    private void setLabelProperties() {

        subcategoryLabel.setPrefHeight(PREF_HEIGHT);
        subcategoryLabel.setPadding(new Insets(15));
        AnchorPane.setRightAnchor(subcategoryLabel, 0.0);
        AnchorPane.setLeftAnchor(subcategoryLabel, 0.0);
    }
    
    private void setProperties(String bgColor) {
        
        subcategoryLabel.setStyle("-fx-background-color:" + bgColor + "; " + 
                "-fx-background-radius:" + MyUtility.DEFAULT_CORNER_RADIUS);
    }
}
