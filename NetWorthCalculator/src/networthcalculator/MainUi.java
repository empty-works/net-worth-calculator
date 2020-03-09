/*
 */
package networthcalculator;

import javafx.scene.control.Label;
import networthcalculator.api_connection.JsonRetriever;
import networthcalculator.containers.LiabilitiesContainer;
import networthcalculator.containers.AssetsContainer;
import networthcalculator.containers.BottomNetWorthContainer;
import networthcalculator.menu.MainMenuBar;
import org.json.simple.JSONObject;

/**
 *
 * @author MP
 */
public class MainUi extends javafx.scene.layout.BorderPane {
    
    public MainUi() {
        
        addLabels();
    }
    
    private void addLabels() {

        // Bottom container amounts
        BottomNetWorthContainer netCon = new BottomNetWorthContainer();
        netCon.prefWidthProperty().bind(this.widthProperty());
        this.setBottom(netCon);
        
        TotalAmount totalAmount = new TotalAmount(netCon);
        
        // Create currency symbol label
        Label currencySymbolLabel = new Label("USD");
        
        // ASSETS LEFT
        AssetsContainer ac = new AssetsContainer(totalAmount, currencySymbolLabel);
        ac.prefWidthProperty().bind(this.widthProperty().divide(2)); // w * 1/2
        this.setLeft(ac);
        
        // LIABILITIES RIGHT
        LiabilitiesContainer lc = new LiabilitiesContainer(totalAmount, currencySymbolLabel);
        lc.prefWidthProperty().bind(this.widthProperty().divide(2)); // w * 1/2
        this.setRight(lc);
        
        // Connect to API
        JsonRetriever retriever = new JsonRetriever();
        JSONObject jObject = retriever.getJsonObject();
        
        // Menu bar TOP
        MainMenuBar menuBar = new MainMenuBar(jObject, currencySymbolLabel);
        this.setTop(menuBar);
        menuBar.setJsonCurrencyObj();
    }
}
