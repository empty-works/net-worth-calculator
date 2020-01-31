/*
 */
package networthcalculator.labels;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import networthcalculator.SetSizes;

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
        setLabelProperties();
        this.setMaxWidth(SetSizes.MAX_WIDTH);
    }
    
    // Check stylesheet for stylings.
    private void setLabelProperties() {

        this.getChildren().add(subcategoryLabel);
        subcategoryLabel.setPrefHeight(PREF_HEIGHT);
        AnchorPane.setRightAnchor(subcategoryLabel, 0.0);
        AnchorPane.setLeftAnchor(subcategoryLabel, 0.0);
    }
}
