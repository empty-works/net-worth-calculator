/*
 */
package networthcalculator.labels;

import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import networthcalculator.SetSizes;

/**
 *
 * @author MP
 */
public class SubTotalAmountLabel extends javafx.scene.layout.AnchorPane {
    
    private Label leftPlaceholder = new Label();
    private Label subTotal = new Label();
    private Label rightPlaceholder = new Label();
    private HBox hbox = new HBox();
    private String text;
    final private int PREF_HEIGHT = 25;
    
    public SubTotalAmountLabel(String text) {
        
        this.text = text;
        this.setId("SubTotalAmountLabel");
        setHBox();
        setLabelProperties();
        this.setMaxWidth(SetSizes.MAX_WIDTH);
    }
    
    private void setHBox() {
        
        hbox.setId("SubTotalAmountLabelHBox");
        ObservableList list = hbox.getChildren();
        list.addAll(leftPlaceholder, subTotal, rightPlaceholder);
        AnchorPane.setLeftAnchor(hbox, 0.0);
        AnchorPane.setRightAnchor(hbox, 0.0);
    }
    
    private void setLabelProperties() {
        
        subTotal.setText(text);
        this.getChildren().add(subTotal);
        subTotal.setPrefHeight(PREF_HEIGHT);
    }
}
