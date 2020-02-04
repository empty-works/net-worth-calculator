/*
 */
package networthcalculator.labels;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

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
    final private int FONT_SIZE = 18;
    
    public CategoryLabel(String text1, String text2) {
        
        this.text1 = text1;
        this.text2 = text2;
        this.setId("CategoryLabel");
        setHBox();
        setLabelProperties();
        setFont();
        this.getChildren().add(hbox);
    }
    
    private void setHBox() {
        
        hbox.setId("CategoryLabelHBox");
        ObservableList list = hbox.getChildren();
        list.addAll(categoryLabelLeft, categoryLabelRight);
        AnchorPane.setLeftAnchor(hbox, 0.0);
        AnchorPane.setRightAnchor(hbox, 0.0);
    }
    
    // Check stylesheet for stylings.
    private void setLabelProperties() {
        
        categoryLabelLeft.setText(text1);
        categoryLabelLeft.setPrefHeight(PREF_HEIGHT);
        categoryLabelLeft.prefWidthProperty().bind(hbox.widthProperty());
        
        categoryLabelRight.setText(text2);
        categoryLabelRight.setAlignment(Pos.CENTER_RIGHT);
        categoryLabelRight.setPrefHeight(PREF_HEIGHT);
        categoryLabelRight.prefWidthProperty().bind(hbox.widthProperty());
    }
    
    private void setFont() {
        
        Font font = Font.font("arial", FontWeight.BOLD, FONT_SIZE);
        categoryLabelLeft.setFont(font);
        categoryLabelLeft.setTextFill(Paint.valueOf("#ffffff"));
        
        categoryLabelRight.setFont(font);
        categoryLabelRight.setTextFill(Paint.valueOf("#ffffff"));
    }
    
    

    public void setBackground(String bgColor, 
            double topLeft, 
            double topRight, 
            double bottomRight, 
            double bottomLeft) {
        
        BackgroundFill bgf = new BackgroundFill(
                Paint.valueOf(bgColor), 
                new CornerRadii(topLeft, topRight, bottomRight, bottomLeft, false), 
                new Insets(0.5));
        categoryLabelLeft.setBackground(new Background(bgf));
        categoryLabelRight.setBackground(new Background(bgf));
        hbox.setBackground(new Background(bgf));
    }
}
