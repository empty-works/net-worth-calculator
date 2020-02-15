/*
 */
package networthcalculator.labels;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import networthcalculator.MyUtility;
import networthcalculator.NetWorthCalculator;
import networthcalculator.labels.interfaces.AmountViewController;

/**
 *
 * @author MP
 */
public class AmountLabel extends javafx.scene.layout.AnchorPane {
    
    private Label amountLabel = new Label();
    private Label dollarSignLabel = new Label();
    protected TextField amountField = new TextField();
    private HBox hbox = new HBox();
    private VBox buttonVbox = new VBox();
    private String text;
    private Button acceptButton, cancelButton;
    final private int PREF_HEIGHT = 60;
    private AmountViewController controller;
    
    private String currentAmountFieldText = "";
    
    public AmountLabel(String text, String bgColor) {
        
        this.text = text;
        amountLabel.setText(text);
        this.setId("AmountLabel");
        setCustomPadding(0, 10, 5, 10); // Default padding.
        setHBox();
        setLabelProperties();
        setTextField();
        setAcceptAndCancelButtons();
        setBackground(bgColor);
        this.getChildren().add(hbox);
    }
    
    private void setHBox() {
        
        hbox.setId("AmountLabelHBox");
        ObservableList list = hbox.getChildren();
        list.addAll(amountLabel, dollarSignLabel, amountField, buttonVbox);
        AnchorPane.setLeftAnchor(hbox, 0.0);
        AnchorPane.setRightAnchor(hbox, 0.0);
    }
    
    // Check stylesheet for stylings.
    private void setLabelProperties() {

        amountLabel.setText(text);
        amountLabel.setPrefHeight(PREF_HEIGHT);
        amountLabel.prefWidthProperty().bind(hbox.widthProperty());
        
        dollarSignLabel.setId("AmountDollarSignLabel");
        dollarSignLabel.setText(MyUtility.CURRENCY);
        dollarSignLabel.setPrefHeight(PREF_HEIGHT);
        dollarSignLabel.prefWidthProperty().bind(hbox.widthProperty().divide(5)); // w * 1/5
    }
    
    private void setTextField() {
        
        amountField.setId("AmountLabelTextField");
        amountField.setAlignment(Pos.CENTER_RIGHT);
        amountField.setMinHeight(PREF_HEIGHT);
        amountField.setPrefHeight(PREF_HEIGHT);
        amountField.prefWidthProperty().bind(hbox.widthProperty().divide(1.5));
        
        amountField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, 
                    String oldValue, String newValue) {
                
                if(!oldValue.equals(newValue)) {
                    
                    acceptButton.setVisible(true);
                    cancelButton.setVisible(true);
                }
                else {
                    
                    acceptButton.setVisible(false);
                    cancelButton.setVisible(false);
                }
            }
        });
        
        /*
        //TODO: make better filter
        UnaryOperator<Change> integerFilter = change -> {
          
            String input = change.getText();
            if(input.matches("[0-9]*")) {
                
                return change;
            }
            return null;
        };
        
        amountField.setTextFormatter(new TextFormatter<String>(integerFilter));
        */
    }
    
    private void setAcceptAndCancelButtons() {
        
        int buttonSize = 32;
        
        acceptButton = new Button();
        acceptButton.setMinHeight(buttonSize);
        acceptButton.setPrefHeight(buttonSize);
        acceptButton.setMinWidth(buttonSize);
        acceptButton.setPrefWidth(buttonSize);
        Image greenCheck = new Image(NetWorthCalculator.class.getResourceAsStream(
                "images/green_checkmark.png"));
        acceptButton.setGraphic(new ImageView(greenCheck));
        acceptButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent e) {
                
                currentAmountFieldText = amountField.getText();
                controller.amountChanged(Double.valueOf(currentAmountFieldText));
                setButtonsVisible(false);
            }
        });
        
        cancelButton = new Button();
        cancelButton.setMinHeight(buttonSize);
        cancelButton.setPrefHeight(buttonSize);
        cancelButton.setMinWidth(buttonSize);
        cancelButton.setPrefWidth(buttonSize);
        Image redXMark = new Image(NetWorthCalculator.class.getResourceAsStream(
                "images/red_xmark.png"));
        cancelButton.setGraphic(new ImageView(redXMark));
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent e) {
                
                amountField.setText(currentAmountFieldText);
                setButtonsVisible(false);
            }
        });
        
        buttonVbox.getChildren().addAll(acceptButton, cancelButton);
        buttonVbox.prefWidthProperty().bind(hbox.widthProperty().divide(6));
        
        setButtonsVisible(false);
    }
    
    private void setButtonsVisible(boolean set) {
        
        acceptButton.setVisible(set);
        cancelButton.setVisible(set);
    }
    
    public String getText() {
        
        return amountField.getText();
    }
    
    public void setCustomPadding(double padding) {
        
        this.setPadding(new Insets(padding));
    }
    
    public void setCustomPadding(double top, double right, double bottom, double left) {
        
        this.setPadding(new Insets(top, right, bottom, left));
    }
    
    private void setBackground(String bgColor) {
        
        System.out.println("Background color: " + bgColor);
        hbox.setStyle("-fx-background-color:" + bgColor + "; " + 
                "-fx-background-radius:" + MyUtility.DEFAULT_CORNER_RADIUS);
    }
    
    public void setController(AmountViewController controller) {
        
        this.controller = controller;
    }
}
