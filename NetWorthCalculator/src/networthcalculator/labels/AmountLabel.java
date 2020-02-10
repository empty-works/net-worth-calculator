/*
 */
package networthcalculator.labels;

import java.util.function.UnaryOperator;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import networthcalculator.MyUtility;

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
    
    public AmountLabel(String text, String bgColor) {
        
        this.text = text;
        amountLabel.setText(text);
        this.setId("AmountLabel");
        setCustomPadding(0, 10, 5, 10); // Default padding.
        setHBox();
        setLabelProperties();
        setTextField();
        setBackground(bgColor);
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
        dollarSignLabel.setText(MyUtility.CURRENCY);
        dollarSignLabel.setPrefHeight(PREF_HEIGHT);
        dollarSignLabel.prefWidthProperty().bind(hbox.widthProperty().divide(5)); // w * 1/5
    }
    
    private void setTextField() {
        
        amountField.setId("AmountLabelTextField");
        amountField.setAlignment(Pos.CENTER_RIGHT);
        amountField.prefWidthProperty().bind(hbox.widthProperty().divide(1.5));
        
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
    
    public void setCustomPadding(double padding) {
        
        this.setPadding(new Insets(padding));
    }
    
    public void setCustomPadding(double top, double right, double bottom, double left) {
        
        this.setPadding(new Insets(top, right, bottom, left));
    }
    
    private void setBackground(String bgColor) {
        
        System.out.println("Background color: " + bgColor);
        hbox.setStyle("-fx-background-color:" + bgColor + "; " + 
                "-fx-background-radius:" + MyUtility.DEFAULT_CORNER_RADIUS);
    }
}
