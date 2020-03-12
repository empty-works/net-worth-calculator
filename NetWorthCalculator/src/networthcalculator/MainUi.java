/*
 */
package networthcalculator;

import javafx.scene.control.Label;
import networthcalculator.api_connection.JsonRetriever;
import networthcalculator.containers.LiabilitiesContainer;
import networthcalculator.containers.AssetsContainer;
import networthcalculator.containers.BottomNetWorthContainer;
import networthcalculator.menu.MainMenuBar;
import networthcalculator.utilities.CurrencyChanger;
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
        CurrencyChanger changer = new CurrencyChanger();
        
        // ASSETS LEFT
        AssetsContainer ac = new AssetsContainer(totalAmount, changer);
        ac.prefWidthProperty().bind(this.widthProperty().divide(2)); // w * 1/2
        this.setLeft(ac);
        
        // LIABILITIES RIGHT
        LiabilitiesContainer lc = new LiabilitiesContainer(totalAmount, changer);
        lc.prefWidthProperty().bind(this.widthProperty().divide(2)); // w * 1/2
        this.setRight(lc);
        
        // Connect to API
        JsonRetriever retriever = new JsonRetriever();
        JSONObject jObject = retriever.getJsonObject();
        
        // Menu bar TOP
        MainMenuBar menuBar = new MainMenuBar(jObject);
        this.setTop(menuBar);
        menuBar.setJsonCurrencyObj();
    }
}
