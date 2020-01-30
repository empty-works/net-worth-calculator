/*
 */
package networthcalculator.labels;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;

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
    
    public AmountLabel(String text) {
        
        System.out.println("Label text: " + text);
        amountLabel.setText(text);
        setLabelProperties();
        setSetSize();
    }
    
    private void setHBox() {
        
        
    }
    
    private void setLabelProperties() {
        
        setBackground();
        this.getChildren().add(amountLabel);
    }
                
    private void setSetSize() {
        
        amountLabel.setPrefHeight(65);
        AnchorPane.setRightAnchor(amountLabel, 0.0);
        AnchorPane.setLeftAnchor(amountLabel, 0.0);
    }
    
    private void setBackground() {
        
        BackgroundFill bgf = new BackgroundFill(
                Paint.valueOf("red"), 
                new CornerRadii(0.5), 
                new Insets(0.5, 0.5, 0.5, 0.5));
        amountLabel.setBackground(new Background(bgf));
    }
}
