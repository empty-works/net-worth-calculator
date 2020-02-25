/*
 */
package networthcalculator;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
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
        Menu menu1 = new Menu("File");
        Menu menu2 = new Menu("Settings");
        MenuBar menubar = new MenuBar();
        menubar.getMenus().addAll(menu1, menu2);
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
