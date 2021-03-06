/*
 */
package networthcalculator.labels;

import networthcalculator.utilities.InputChecker;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import networthcalculator.utilities.MyUtility;
import networthcalculator.NetWorthCalculator;
import networthcalculator.labels.interfaces.AmountViewController;
import networthcalculator.utilities.CurrencyHandler;
import networthcalculator.utilities.EventHandlerMaker;
import networthcalculator.utilities.NumberReformatter;

/**
 *
 * @author MP
 */
public class AmountLabel extends javafx.scene.layout.AnchorPane {
    
    private Label amountLabel = new Label();
    protected TextField amountField = new TextField("0.00");
    private HBox hbox = new HBox();
    private VBox buttonVbox = new VBox();
    private String text;
    private Button acceptButton, cancelButton;
    final private int PREF_HEIGHT = 60;
    private AmountViewController controller;
    private String bgColor;
    private Label curLabel = new Label();
    private CurrencyHandler currencyHandler;
    
    private String currentAmountFieldText = "";
    
    public AmountLabel(String text, String bgColor) {
        
        this.bgColor = bgColor;
        this.text = text;
        
        amountLabel.setText(text);
        this.setId("AmountLabel");
        setCustomPadding(0, 10, 5, 10); // Default padding.
        setHBox();
        setLabelProperties();
        setTextField();
        setAcceptAndCancelButtons();
        setBackground();
        setTextFieldProperties();
        this.getChildren().add(hbox);
    }
    
    private void setHBox() {
        
        hbox.setId("AmountLabelHBox");
        ObservableList list = hbox.getChildren();
        list.addAll(amountLabel, curLabel, amountField, buttonVbox);
        AnchorPane.setLeftAnchor(hbox, 0.0);
        AnchorPane.setRightAnchor(hbox, 0.0);
    }
    
    // Check stylesheet for stylings.
    private void setLabelProperties() {

        amountLabel.setText(text);
        amountLabel.setPrefHeight(PREF_HEIGHT);
        amountLabel.prefWidthProperty().bind(hbox.widthProperty());
        
        curLabel.setId("AmountDollarSignLabel");
        curLabel.setText("USD");
        curLabel.setPrefHeight(PREF_HEIGHT);
        curLabel.prefWidthProperty().bind(hbox.widthProperty().divide(1.3)); // w * 1/5
    }
    
    private void setTextField() {
        
        amountField.setId("AmountLabelTextField");
        amountField.setAlignment(Pos.CENTER_RIGHT);
        amountField.setMinHeight(PREF_HEIGHT);
        amountField.setPrefHeight(PREF_HEIGHT);
        amountField.prefWidthProperty().bind(hbox.widthProperty().divide(1.5));
        
        amountField.addEventFilter(KeyEvent.KEY_TYPED, EventHandlerMaker.maxLength());
        
        amountField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, 
                    String oldValue, String newValue) {
                
                if(!oldValue.equals(newValue) && 
                        currencyHandler.isCurrencyChange() == false) {
                    
                    clearInvalidWarning();
                    acceptButton.setVisible(true);
                    cancelButton.setVisible(true);
                }
                else {
                    
                    // This case might happen with copy/pasting
                    acceptButton.setVisible(false);
                    cancelButton.setVisible(false);
                    currencyHandler.setIsCurrencyChange(false); // Reset "is currency" flag
                }
            }
        });
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
                
                String inputAmount = amountField.getText();
                
                if(InputChecker.checkIsValid(amountField, inputAmount.trim())) {
                    
                    controller.amountChanged(inputAmount, currentAmountFieldText);
                    currentAmountFieldText = NumberReformatter.reformat(inputAmount);
                    amountField.setText(currentAmountFieldText);
                    setButtonsVisible(false);
                }
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
    
    private void setBackground() {
        
        System.out.println("Background color: " + bgColor);
        hbox.setStyle("-fx-background-color:" + bgColor + "; " + 
                "-fx-background-radius:" + MyUtility.DEFAULT_CORNER_RADIUS);
    }
    
    private void setTextFieldProperties() {
        
        amountField.setStyle("-fx-border-color: black; -fx-border-width: 1");
    }

    public void setController(AmountViewController controller) {
        
        this.controller = controller;
    }
    
    private void clearInvalidWarning() {
        
        setTextFieldProperties();
    }
    
    public Label getCurLabel(){
        
        return curLabel;
    }
    
    public TextField getAmountField() {
        
        return amountField;
    }
    
    public void setCurrencyHandler(CurrencyHandler curHand) {
    
        this.currencyHandler = curHand;
    }
}
