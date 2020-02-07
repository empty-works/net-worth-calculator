/*
 */
package networthcalculator.labels;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;

/**
 *
 * @author MP
 */
public class TitleAndAmountLabel extends javafx.scene.layout.VBox {
    
    private String title;
    private String bgColor;
    private Label titleLabel = new Label();
    private Label middlePlaceholder = new Label();
    private Label rightPlaceholder = new Label();
    private HBox hbox = new HBox();
    final private int PREF_HEIGHT = 25;
    
    public TitleAndAmountLabel(String title, String bgColor) {
        
        this.title = title;
        this.bgColor = bgColor;
        setBackground(bgColor);
        setTitle();
    }
    
    private void setTitle() {

        titleLabel.setText(title);
        titleLabel.setPrefHeight(PREF_HEIGHT);
        
        titleLabel.prefWidthProperty().bind(hbox.widthProperty());
        
        middlePlaceholder.setPrefHeight(PREF_HEIGHT);
        middlePlaceholder.prefWidthProperty().bind(hbox.widthProperty());
        
        rightPlaceholder.setPrefHeight(PREF_HEIGHT);
        rightPlaceholder.prefWidthProperty().bind(hbox.widthProperty());
        
        ObservableList list = hbox.getChildren();
        list.addAll(titleLabel, middlePlaceholder, rightPlaceholder);
        AnchorPane.setLeftAnchor(hbox, 0.0);
        AnchorPane.setRightAnchor(hbox, 0.0);
        
        this.getChildren().add(hbox);
    }
    
    public void addAmountLabel(AmountLabel label) {
        
        
        this.getChildren().add(label);
    }
    
    public void addAllAmountLabels(AmountLabel...labels) {
        
        this.getChildren().addAll(labels);
    }

    public void setBackground(String bgColor) {
        
        BackgroundFill bgf = new BackgroundFill(
                Paint.valueOf(bgColor), 
                new CornerRadii(5.5, false), 
                new Insets(0.5));
        this.setBackground(new Background(bgf));
    }
}
