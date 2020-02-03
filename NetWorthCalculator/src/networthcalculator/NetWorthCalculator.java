/*
 */
package networthcalculator;

import java.net.URL;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author MP
 */
public class NetWorthCalculator extends Application {
    
    private Scene scene;
    
    @Override
    public void start(Stage primaryStage) {
        
        // Set root.
        GridPane pane = new MainUi();
        // Set scene.
        scene = new Scene(pane);
        URL stylesheetURL = getClass().getResource("stylesheet.css");
        scene.getStylesheets().add(stylesheetURL.toExternalForm());
        // Set stage.
        setPrimaryStage(primaryStage);
    }
    
    private void setPrimaryStage(Stage primaryStage) {
        
        primaryStage.setTitle("Net Worth Calculator");
        primaryStage.initStyle(StageStyle.UNIFIED);
        primaryStage.setWidth(900);
        primaryStage.setHeight(650);
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
