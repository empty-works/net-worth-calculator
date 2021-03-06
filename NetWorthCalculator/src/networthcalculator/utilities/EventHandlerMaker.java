/*
 */
package networthcalculator.utilities;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author MP
 */
public class EventHandlerMaker {
    
    public static EventHandler<KeyEvent> maxLength() {
        
        return new EventHandler<KeyEvent>() {
            
            @Override
            public void handle(KeyEvent arg0) {

                int length = 8; // Max length of amount
                
                TextField tx = (TextField) arg0.getSource();
                if (tx.getText().length() >= length) {
                    arg0.consume();
                }
            }
        };
    }
}
