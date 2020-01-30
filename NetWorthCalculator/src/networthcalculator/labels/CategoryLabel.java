/*
 */
package networthcalculator.labels;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import networthcalculator.SetSizes;

/**
 *
 * @author MP
 */
public class CategoryLabel extends javafx.scene.layout.AnchorPane {
    
    private Label categoryLabelLeft = new Label();
    private Label categoryLabelRight = new Label();
    private HBox hbox = new HBox();
    private String text1, text2;
    final private int PREF_HEIGHT = 65;
    
    public CategoryLabel(String text1, String text2) {
        
        this.text1 = text1;
        this.text2 = text2;
        this.setId("CategoryLabel");
        setHBox();
        setLabelProperties();
        setBackground();
        this.setPadding(new Insets(10 /*Top*/, 10 /*Right*/, 0 /*Bottom*/, 10 /*Left*/));
        this.getChildren().add(hbox);
        this.setMaxWidth(SetSizes.MAX_WIDTH);
    }
    
    private void setHBox() {
        
        ObservableList list = hbox.getChildren();
        list.addAll(categoryLabelLeft, categoryLabelRight);
        AnchorPane.setLeftAnchor(hbox, 0.0);
        AnchorPane.setRightAnchor(hbox, 0.0);
    }
    
    private void setLabelProperties() {
        
        categoryLabelLeft.setText(text1);
        categoryLabelLeft.setPrefHeight(PREF_HEIGHT);
        categoryLabelLeft.prefWidthProperty().bind(hbox.widthProperty());
        
        categoryLabelRight.setText(text2);
        categoryLabelRight.setAlignment(Pos.CENTER_RIGHT);
        categoryLabelRight.setPrefHeight(PREF_HEIGHT);
        categoryLabelRight.prefWidthProperty().bind(hbox.widthProperty());
    }
    
    private void setBackground() {
        
        BackgroundFill bgf = new BackgroundFill(
                Paint.valueOf("#999966"), 
                new CornerRadii(5.5, 50, 5.5, 5.5, false), 
                new Insets(0.5, 0.5, 0.5, 0.5));
        categoryLabelLeft.setBackground(new Background(bgf));
        categoryLabelRight.setBackground(new Background(bgf));
        hbox.setBackground(new Background(bgf));
    }
}
