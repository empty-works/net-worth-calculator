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
public class SubTotalAmountLabel extends javafx.scene.layout.AnchorPane {
    
    private Label subTotal = new Label();
    private String text;
    final private int PREF_HEIGHT = 25;
    
    public SubTotalAmountLabel(String text) {
        
        this.text = text;
        this.setId("SubTotalAmountLabel");
        setLabelProperties();
        this.setMaxWidth(SetSizes.MAX_WIDTH);
    }
    
    private void setLabelProperties() {
        
        subTotal.setText(text);
        this.getChildren().add(subTotal);
        subTotal.setPrefHeight(PREF_HEIGHT);
        AnchorPane.setLeftAnchor(subTotal, 0.0);
        AnchorPane.setRightAnchor(subTotal, 0.0);
    }
}
