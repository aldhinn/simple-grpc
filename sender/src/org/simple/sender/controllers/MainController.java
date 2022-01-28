package org.simple.sender.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import org.simple.sender.models.MainModel;

import java.net.URL;
import java.util.ResourceBundle;

// The controller component for the main view.
public class MainController implements Initializable {
    //#region FXML component references
    //#region m_messageTextField
    @FXML
    TextField m_messageTextField;
    //#endregion
    //#region m_sendMessageButton
    @FXML
    Button m_sendMessageButton;
    //#endregion
    //#endregion

    //#region FXML Event Handlers
    //#region onSendingMessage
    public void onSendingMessage(InputEvent inputEvent) {
        m_model.sendMessage(m_messageTextField.getText());
        m_messageTextField.clear();
    }
    //#endregion
    //#endregion

    //#region m_model
    // the main model instance.
    private MainModel m_model;
    //#endregion
    //#region initialize
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        m_model = new MainModel();
    }
    //#endregion
}