/*
 */
package networthcalculator;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import networthcalculator.containers.LiabilitiesContainer;
import networthcalculator.containers.AssetsContainer;
import networthcalculator.containers.BottomNetWorthContainer;

/**
 *
 * @author MP
 */
public class MainUi extends javafx.scene.layout.BorderPane {
    
    public MainUi() {
        
        addLabels();
    }
    
    private void addLabels() {
        
        // Menu bar TOP
        Menu fileMenu = new Menu("File");
        MenuItem fileItem1 = new MenuItem("New file...");
        MenuItem fileItem2 = new MenuItem("Save");
        MenuItem fileItem3 = new MenuItem("Open file...");
        fileMenu.getItems().addAll(fileItem1, fileItem2, fileItem3);
        
        Menu settingsMenu = new Menu("Settings");
        MenuItem settingsItem1 = new MenuItem("Change Currency");
        settingsMenu.getItems().addAll(settingsItem1);
        
        MenuBar menubar = new MenuBar();
        menubar.getMenus().addAll(fileMenu, settingsMenu);
        VBox menuVbox = new VBox(menubar);
        menuVbox.setPrefHeight(20);
        this.setTop(menuVbox);
        
        // Bottom container amounts
        BottomNetWorthContainer netCon = new BottomNetWorthContainer();
        netCon.prefWidthProperty().bind(this.widthProperty());
        this.setBottom(netCon);
        
        TotalAmount totalAmount = new TotalAmount(netCon);
        
        // ASSETS LEFT
        AssetsContainer ac = new AssetsContainer(totalAmount);
        ac.prefWidthProperty().bind(this.widthProperty().divide(2)); // w * 1/2
        this.setLeft(ac);
        
        // LIABILITIES RIGHT
        LiabilitiesContainer lc = new LiabilitiesContainer(totalAmount);
        lc.prefWidthProperty().bind(this.widthProperty().divide(2)); // w * 1/2
        this.setRight(lc);
    }
}
