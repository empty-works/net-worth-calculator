/*
 */
package networthcalculator.menu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import networthcalculator.popup.CurrencyChangePopup;

/**
 *
 * @author MP
 */
public class MainMenuBar extends javafx.scene.layout.VBox {
    
    final private String SETTINGS = "Settings";
    final private String SELECT_CURRENCY = "Select Currency";
    
    public MainMenuBar() {
        
        // File menu
        Menu fileMenu = new Menu("File");
        MenuItem fileItem1 = new MenuItem("New file...");
        MenuItem fileItem2 = new MenuItem("Save");
        MenuItem fileItem3 = new MenuItem("Open file...");
        fileMenu.getItems().addAll(fileItem1, fileItem2, fileItem3);
        
        // Settings menu
        Menu settingsMenu = new Menu(SETTINGS);
        
        Menu subSettingsMenu = new Menu(SELECT_CURRENCY);
        settingsMenu.getItems().addAll(subSettingsMenu);
        // Submenu item
        RadioMenuItem currencyItem1 = new RadioMenuItem("Currency1");
        RadioMenuItem currencyItem2 = new RadioMenuItem("Currency2");
        RadioMenuItem currencyItem3 = new RadioMenuItem("Currency3");
        RadioMenuItem currencyItem4 = new RadioMenuItem("Currency4");
        
        ToggleGroup toggleGroup = new ToggleGroup();
        toggleGroup.getToggles().add(currencyItem1);
        toggleGroup.getToggles().add(currencyItem2);
        toggleGroup.getToggles().add(currencyItem3);
        toggleGroup.getToggles().add(currencyItem4);

        subSettingsMenu.getItems().addAll(
                currencyItem1, currencyItem2, currencyItem3, currencyItem4);

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
                if(SELECT_CURRENCY.equalsIgnoreCase(setting)) {
                    
                    System.out.println("Testing settings menu");
                    
                    CurrencyChangePopup popup = new CurrencyChangePopup();
                    popup.show(MainMenuBar.this, 0.0, 0.0);
                }
            }
        };
    }
}
