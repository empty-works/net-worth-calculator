/*
 */
package networthcalculator.labels;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author MP
 */
public class EditLabel extends javafx.scene.control.Button {
    
    private TextField nameField = new TextField();
    
    public EditLabel(Label amountLabelName) {
    
        setAction();
    }
    
    private void setAction() {
    
        this.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                // Make text field appear here to allow user to type a new 
                // name in.
            }
        });
    }
}