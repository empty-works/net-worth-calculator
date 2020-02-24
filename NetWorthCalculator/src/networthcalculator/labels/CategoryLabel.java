/*
 */
package networthcalculator.labels;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author MP
 */
public abstract class CategoryLabel extends javafx.scene.layout.AnchorPane {
    
    private Label categoryLabelLeft = new Label();
    private Label categoryLabelRight = new Label();
    
    protected HBox hbox = new HBox();
    protected String text1, text2;
    final private int PREF_HEIGHT = 65;
    
    public CategoryLabel(String text1, String text2) {
        
        this.setId("CategoryLabel");
        this.text1 = text1;
        this.text2 = text2;
        setHBox();
        setLabelProperties();
        this.getChildren().add(hbox);
    }
    
    private void setHBox() {
        
        hbox.setId("CategoryLabelHbox");
        ObservableList list = hbox.getChildren();
        list.addAll(categoryLabelLeft, categoryLabelRight);
        hbox.setPadding(new Insets(10, 55, 5, 15));
        AnchorPane.setLeftAnchor(hbox, 0.0);
        AnchorPane.setRightAnchor(hbox, 0.0);
    }
    
    // Check stylesheet for stylings.
    private void setLabelProperties() {
        
        // Check style sheet for child properties.
        
        categoryLabelLeft.setText(text1);
        categoryLabelLeft.setPrefHeight(PREF_HEIGHT);
        categoryLabelLeft.prefWidthProperty().bind(hbox.widthProperty());
        
        categoryLabelRight.setText(text2);
        categoryLabelRight.setAlignment(Pos.CENTER_RIGHT);
        categoryLabelRight.setPrefHeight(PREF_HEIGHT);
        categoryLabelRight.prefWidthProperty().bind(hbox.widthProperty());
    }
}
