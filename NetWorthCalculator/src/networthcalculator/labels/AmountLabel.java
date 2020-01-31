/*
 */
package networthcalculator.labels;

import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import networthcalculator.SetSizes;

/**
 *
 * @author MP
 */
public class AmountLabel extends javafx.scene.layout.AnchorPane {
    
    private Label amountLabel = new Label();
    private Label dollarSignLabel = new Label();
    private TextField amountField = new TextField();
    private HBox hbox = new HBox();
    private String text;
    final private int PREF_HEIGHT = 25;
    
    public AmountLabel(String text) {
        
        this.text = text;
        amountLabel.setText(text);
        this.setId("AmountLabel");
        setHBox();
        setLabelProperties();
        this.getChildren().add(hbox);
        this.setMaxWidth(SetSizes.MAX_WIDTH);
    }
    
    private void setHBox() {
        
        hbox.setId("AmountLabelHBox");
        ObservableList list = hbox.getChildren();
        list.addAll(amountLabel, dollarSignLabel, amountField);
        AnchorPane.setLeftAnchor(hbox, 0.0);
        AnchorPane.setRightAnchor(hbox, 0.0);
    }
    
    // Check stylesheet for stylings.
    private void setLabelProperties() {

        amountLabel.setText(text);
        amountLabel.setPrefHeight(PREF_HEIGHT);
        AnchorPane.setRightAnchor(amountLabel, 0.0);
        AnchorPane.setLeftAnchor(amountLabel, 0.0);
    }
}
