/*
 */
package networthcalculator.labels;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author MP
 */
public class EditLabel extends javafx.scene.layout.HBox {
    
    private TextField nameField = new TextField();
    private Button editButton = new Button();
    final private int BUTTON_SIZE = 100;
    
    public EditLabel(Label amountLabelName) {
    
        setButtonSize();
        setTextFieldSize();
        setAction();
        setChildren();
    }
    
    private void setButtonSize() {
    
        editButton.setMinHeight(BUTTON_SIZE);
        editButton.setPrefHeight(BUTTON_SIZE);
        editButton.setMinWidth(BUTTON_SIZE);
        editButton.setPrefWidth(BUTTON_SIZE);
        // TODO Set a pencil icon here.
    }
    
    private void setTextFieldSize() {
    
        // TODO set text field size.
    }
    
    private void setAction() {
    
        editButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                // TODO Make text field appear here to allow user to type a new 
                // name in.
            }
        });
    }
    
    private void setChildren() {
    
        ObservableList list = this.getChildren();
        list.addAll(editButton, nameField);
    }
}