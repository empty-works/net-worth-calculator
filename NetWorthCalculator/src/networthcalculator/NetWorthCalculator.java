/*
 */
package networthcalculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author MP
 */
public class NetWorthCalculator extends Application {
    
    private Scene scene;
    private StackPane root;
    
    @Override
    public void start(Stage primaryStage) {
        
        setRoot();
        setMainScene();
        setPrimaryStage(primaryStage); 
    }
    
    private void setRoot() {
        
        Button btn = new Button();
        btn.setText("Say 'Your net worth is: '");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Your net worth is: ");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
    }
    
    private void setMainScene() {
        
        scene = new Scene(root, 400, 250);
    }
    
    private void setPrimaryStage(Stage primaryStage) {
        
        primaryStage.setTitle("Net Worth Calculator");
        primaryStage.initStyle(StageStyle.UNIFIED);
        primaryStage.setWidth(1000);
        primaryStage.setHeight(600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
