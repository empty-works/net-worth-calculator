/*
 */
package networthcalculator.menu;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

/**
 *
 * @author MP
 */
public class MainMenuBar extends javafx.scene.control.MenuBar {
    
    public MainMenuBar() {
        
        // File menu
        Menu fileMenu = new Menu("File");
        MenuItem fileItem1 = new MenuItem("New file...");
        MenuItem fileItem2 = new MenuItem("Save"); 
        MenuItem fileItem3 = new MenuItem("Open file...");
        fileMenu.getItems().addAll(fileItem1, fileItem2, fileItem3);
        
        // Settings menu
        Menu settingsMenu = new Menu("Settings");
        MenuItem settingsItem1 = new MenuItem("Change Currency");
        settingsMenu.getItems().addAll(settingsItem1);
    }
}
