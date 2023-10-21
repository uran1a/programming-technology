package tasks.task0.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import tasks.task0.models.Procent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private TextField amountTextField;

    @FXML
    private Button badTipsButton;

    @FXML
    private Label badTipsLabel;

    @FXML
    private Button goodTipsButton;

    @FXML
    private Label goodTipsLabel;

    @FXML
    private Button largeTipsButton;

    @FXML
    private Label largeTipsLabel;

    @FXML
    private Button paymentButton;

    @FXML
    private Label welcomeText;

    private Procent procent;
    private void calculateLargeTipsHandler(MouseEvent event){
        if(amountTextField.getText().isEmpty())
            displayWarningMessage("Введите сумма чека!");
        else
            calculateTips(largeTipsLabel, Float.parseFloat(amountTextField.getText()), 15);
    }
    private void calculateGoodTipsHandler(MouseEvent event){
        if(amountTextField.getText().isEmpty())
            displayWarningMessage("Введите сумма чека!");
        else
            calculateTips(goodTipsLabel, Float.parseFloat(amountTextField.getText()), 10);
    }
    private void calculateBadTipsHandler(MouseEvent event){
        if(amountTextField.getText().isEmpty())
            displayWarningMessage("Введите сумма чека!");
        else
            calculateTips(badTipsLabel, Float.parseFloat(amountTextField.getText()), 3);
    }
    private void paymentHandler(MouseEvent event){
        if(procent == null)
            displayWarningMessage("Выберите процент чаевых!");
        else
            displayInformationMessage("Ваш чек на отправлен на почту.");
    }
    private void calculateTips(Label label, float amount, int pt) {
        procent = new Procent(amount);
        label.setText("Чаевые: " + procent.countPr(pt) +" руб.");
        paymentButton.setText("Оплатить (" + procent.countSumInt(pt) + " руб.)");
    }
    private void displayWarningMessage(String text){
        var alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Сообщение");
        alert.setHeaderText("Предупреждение");
        alert.setContentText(text);
        alert.showAndWait();
    }
    private void displayInformationMessage(String text){
        var alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Сообщение");
        alert.setHeaderText("Оплата прошла успешно!");
        alert.setContentText(text);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.largeTipsButton.setOnMouseClicked(this::calculateLargeTipsHandler);
        this.goodTipsButton.setOnMouseClicked(this::calculateGoodTipsHandler);
        this.badTipsButton.setOnMouseClicked(this::calculateBadTipsHandler);
        this.paymentButton.setOnMouseClicked(this::paymentHandler);
    }
}
