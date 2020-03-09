/*
 */
package networthcalculator.menu;

import java.util.Iterator;
import java.util.Map;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import org.json.simple.JSONObject;

/**
 *
 * @author MP
 */
public class MainMenuBar extends javafx.scene.layout.VBox {
    
    final private String SETTINGS = "Settings";
    final private String SELECT_CURRENCY = "Select Currency";
    private Menu settingsMenu;
    
    public MainMenuBar() {
        
        // File menu
        Menu fileMenu = new Menu("File");
        MenuItem fileItem1 = new MenuItem("New file...");
        MenuItem fileItem2 = new MenuItem("Save");
        MenuItem fileItem3 = new MenuItem("Open file...");
        fileMenu.getItems().addAll(fileItem1, fileItem2, fileItem3);
        
        // Settings menu
        settingsMenu = new Menu(SETTINGS);

        // Set menu bar.
        MenuBar menubar = new MenuBar();
        menubar.getMenus().addAll(fileMenu, settingsMenu);
        this.getChildren().add(menubar);
        this.setPrefHeight(20);
    }
    
    public void setJsonCurrencyObj(JSONObject obj) {
        
        Menu subSettingsMenu = new Menu(SELECT_CURRENCY);
        settingsMenu.getItems().addAll(subSettingsMenu);
        
        // Get currencies and their rates
        Map currency = ((Map) obj.get("rates"));
        
        // Iterate through each currency and add to toggle group.
        ToggleGroup toggleGroup = new ToggleGroup();
        Iterator<Map.Entry> iter1 = currency.entrySet().iterator();
        while(iter1.hasNext()) {
            
            Map.Entry pair = iter1.next();
            String keyAndValue = pair.getKey() + " : " + pair.getValue();
            System.out.println("Key and value: " + keyAndValue);
            RadioMenuItem currencyItem = new RadioMenuItem(keyAndValue);
            toggleGroup.getToggles().add(currencyItem);
            subSettingsMenu.getItems().add(currencyItem);
        }
    }
}
