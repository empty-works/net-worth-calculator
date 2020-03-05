/*
 */
package networthcalculator.menu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import networthcalculator.popup.CurrencyChangePopup;

/**
 *
 * @author MP
 */
public class MainMenuBar extends javafx.scene.layout.VBox {
    
    final private String SETTINGS = "Settings";
    final private String CHANGE_CURRENCY = "Change Currency";
    
    public MainMenuBar() {
        
        // File menu
        Menu fileMenu = new Menu("File");
        MenuItem fileItem1 = new MenuItem("New file...");
        MenuItem fileItem2 = new MenuItem("Save");
        MenuItem fileItem3 = new MenuItem("Open file...");
        fileMenu.getItems().addAll(fileItem1, fileItem2, fileItem3);
        
        // Settings menu
        Menu settingsMenu = new Menu(SETTINGS);
        
        Menu subSettingsMenu = new Menu(CHANGE_CURRENCY);
        settingsMenu.getItems().addAll(subSettingsMenu);
        // Submenu item
        MenuItem currencyItem = new MenuItem("Test1");
        subSettingsMenu.getItems().add(currencyItem);

        // Set menu bar.
        MenuBar menubar = new MenuBar();
        menubar.getMenus().addAll(fileMenu, settingsMenu);
        this.getChildren().add(menubar);
        this.setPrefHeight(20);
    }
    
    private EventHandler<ActionEvent> setSettings() {
        return new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                MenuItem menuItem = (MenuItem) event.getSource();
                String setting = menuItem.getText();
                if(CHANGE_CURRENCY.equalsIgnoreCase(setting)) {
                    
                    System.out.println("Testing settings menu");
                    
                    CurrencyChangePopup popup = new CurrencyChangePopup();
                    popup.show(MainMenuBar.this, 0.0, 0.0);
                }
            }
        };
    }
}
