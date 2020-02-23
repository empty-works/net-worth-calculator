/*
 */
package networthcalculator.labels;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import networthcalculator.utilities.MyUtility;
import networthcalculator.TotalAmount;
import networthcalculator.labels.labelsubclasses.AccCategory;
import networthcalculator.utilities.NumberReformatter;

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
    private TotalAmount totalAmount;
    
    public SubTotalAmountLabel(String text, TotalAmount totalAmount) {
        
        this.totalAmount = totalAmount;
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
    
    public void setSubTotal(double subTotal, AccCategory category) {
        
        String sign = "";
        if(category.getCategory().equals(AccCategory.LIABILITIES)) {
            
            sign = "-";
        }
        subAmountNumLabel.setText(sign + NumberReformatter.reformat(subTotal));
    }
    
    public void setSubTotalDifference(AccCategory category, double subTotalDifference) {
        
        totalAmount.setSubTotalDifference(category, subTotalDifference);
    }
}
