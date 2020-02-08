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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

/**
 *
 * @author MP
 */
public class TitleAndAmountLabel extends javafx.scene.layout.AnchorPane {
    
    private String title;
    private String bgColor;
    private Label titleLabel = new Label();
    private Label middlePlaceholder = new Label();
    private Label rightPlaceholder = new Label();
    private HBox hbox = new HBox();
    private VBox vboxLabelCon = new VBox();
    final private int PREF_HEIGHT = 45;
    
    public TitleAndAmountLabel(String title, String bgColor) {
        
        this.setId("TitleAndAmountLabel");
        this.title = title;
        this.bgColor = bgColor;
        setBackground(bgColor);
        setTitle();
        this.getChildren().add(vboxLabelCon);
    }
    
    private void setTitle() {

        titleLabel.setText(title);
        titleLabel.setPrefHeight(PREF_HEIGHT);
        titleLabel.setPadding(new Insets(0, 0, 0, 15)); // Text left indentation
        titleLabel.prefWidthProperty().bind(hbox.widthProperty());
        
        middlePlaceholder.setPrefHeight(PREF_HEIGHT);
        middlePlaceholder.prefWidthProperty().bind(hbox.widthProperty());
        
        rightPlaceholder.setPrefHeight(PREF_HEIGHT);
        rightPlaceholder.prefWidthProperty().bind(hbox.widthProperty());
        
        ObservableList list = hbox.getChildren();
        list.addAll(titleLabel, middlePlaceholder, rightPlaceholder);
        hbox.setPrefHeight(PREF_HEIGHT);
        AnchorPane.setLeftAnchor(vboxLabelCon, 0.0);
        AnchorPane.setRightAnchor(vboxLabelCon, 0.0);
        
        hbox.prefWidthProperty().bind(vboxLabelCon.widthProperty());
        vboxLabelCon.getChildren().add(hbox);
    }
    
    public void addAmountLabel(AmountLabel label) {
        
        label.setCustomPadding(0);
        label.prefWidthProperty().bind(vboxLabelCon.widthProperty());
        vboxLabelCon.getChildren().add(label);
    }
    
    public void addAllAmountLabels(AmountLabel...labels) {
        
        for(AmountLabel label : labels) {
            
            label.setCustomPadding(0);
            label.prefWidthProperty().bind(vboxLabelCon.widthProperty());
            vboxLabelCon.getChildren().add(label);
        }
    }

    public void setBackground(String bgColor) {
        
        BackgroundFill bgf = new BackgroundFill(
                Paint.valueOf(bgColor), 
                new CornerRadii(5.5, false), 
                new Insets(0.5));
        vboxLabelCon.setBackground(new Background(bgf));
    }
}
