/*
 */
package networthcalculator;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml_files/MainLayout.fxml"));
        System.out.println("FXMLLoader: " + loader);
        // Set root.
        VBox vboxRoot = null;
        try {
            vboxRoot = loader.<VBox>load();
        } catch (IOException ex) {
            Logger.getLogger(NetWorthCalculator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        scene = new Scene(vboxRoot);
        setPrimaryStage(primaryStage);
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
