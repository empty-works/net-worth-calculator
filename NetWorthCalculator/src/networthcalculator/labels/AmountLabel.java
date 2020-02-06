/*
 */
package networthcalculator.labels;

import java.util.function.UnaryOperator;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.converter.IntegerStringConverter;
import networthcalculator.Constants;

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
        setTextField();
        this.getChildren().add(hbox);
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
        amountLabel.prefWidthProperty().bind(hbox.widthProperty());
        
        dollarSignLabel.setId("AmountDollarSignLabel");
        dollarSignLabel.setText(Constants.CURRENCY);
        dollarSignLabel.setPrefHeight(PREF_HEIGHT);
        dollarSignLabel.prefWidthProperty().bind(hbox.widthProperty().divide(5)); // w * 1/5
    }
    
    private void setTextField() {
        
        amountField.setId("AmountLabelTextField");
        amountField.setAlignment(Pos.CENTER_RIGHT);
        amountField.prefWidthProperty().bind(hbox.widthProperty());
        
        //TODO: make better filter
        UnaryOperator<Change> integerFilter = change -> {
          
            String input = change.getText();
            if(input.matches("[0-9]*")) {
                
                return change;
            }
            return null;
        };
        
        amountField.setTextFormatter(new TextFormatter<String>(integerFilter));
    }
}
