/*
 */
package networthcalculator.labels;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import networthcalculator.MyUtility;

/**
 *
 * @author MP
 */
public class SubTotalAmountLabel extends javafx.scene.layout.AnchorPane {
    
    private Label leftPlaceholder = new Label();
    private Label subTotal = new Label();
    private Label subAmountNumLabel = new Label();
    private HBox hbox = new HBox();
    private String text;
    final private int PREF_HEIGHT = 25;
    
    public SubTotalAmountLabel(String text) {
        
        this.text = text;
        this.setId("SubTotalAmountLabel");
        setHBox();
        setLabelProperties();
        this.getChildren().add(hbox);
    }
    
    private void setHBox() {
        
        hbox.setId("SubTotalAmountLabelHBox");
        ObservableList list = hbox.getChildren();
        list.addAll(leftPlaceholder, subTotal, subAmountNumLabel);
        AnchorPane.setLeftAnchor(hbox, 0.0);
        AnchorPane.setRightAnchor(hbox, 0.0);
    }
    
    private void setLabelProperties() {
        
        leftPlaceholder.setPrefHeight(PREF_HEIGHT);
        leftPlaceholder.setAlignment(Pos.CENTER_LEFT);
        leftPlaceholder.prefWidthProperty().bind(hbox.widthProperty());

        subTotal.setId("SubTotalLabel");
        subTotal.setText(text + " " + MyUtility.CURRENCY);
        subTotal.setPrefHeight(PREF_HEIGHT);
        subTotal.prefWidthProperty().bind(hbox.widthProperty());
        
        
        subAmountNumLabel.setPrefHeight(PREF_HEIGHT);
        subAmountNumLabel.setAlignment(Pos.CENTER_RIGHT);
        subAmountNumLabel.prefWidthProperty().bind(hbox.widthProperty());
    }
    
    protected void setSubTotal(double subTotal) {
        
        subAmountNumLabel.setText(String.valueOf(subTotal));
    }
}
