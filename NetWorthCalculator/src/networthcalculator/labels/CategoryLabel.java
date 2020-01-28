/*
 */
package networthcalculator.labels;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author MP
 */
public class CategoryLabel extends javafx.scene.layout.AnchorPane {
    
    private String text;
    private Label categoryLabelLeft = new Label();
    private Label categoryLabelRight = new Label();
    private HBox hbox = new HBox();
    final private int PREF_HEIGHT = 100;
    
    public CategoryLabel(String text) {
        
        this.setId("CategoryLabel");
        this.text = text;
        setHBox();
        setLabelProperties();
        this.getChildren().add(hbox);
    }
    
    private void setHBox() {
        
        ObservableList list = hbox.getChildren();
        list.addAll(categoryLabelLeft, categoryLabelRight);
        AnchorPane.setLeftAnchor(hbox, 0.0);
        AnchorPane.setRightAnchor(hbox, 0.0);
    }
    
    private void setLabelProperties() {
        
        categoryLabelLeft.setText(text);
        categoryLabelLeft.setId("CategoryLabelLeft");
        categoryLabelRight.setText("RARA");
        categoryLabelRight.setId("CategoryLabelRight");
        categoryLabelLeft.setPrefHeight(PREF_HEIGHT);
        categoryLabelRight.setPrefHeight(PREF_HEIGHT);
        categoryLabelLeft.prefWidthProperty().bind(hbox.widthProperty());
        categoryLabelRight.prefWidthProperty().bind(hbox.widthProperty());
        setBackground();
    }
    
    private void setBackground() {
        
        BackgroundFill bgf = new BackgroundFill(
                Paint.valueOf("orange"), 
                new CornerRadii(0.5), 
                new Insets(0.5, 0.5, 0.5, 0.5));
        categoryLabelLeft.setBackground(new Background(bgf));
        categoryLabelRight.setBackground(new Background(bgf));
    }
}
