package org.simple.sender.controllers;

import javafx.fxml.Initializable;
import org.simple.sender.models.MainModel;

import java.net.URL;
import java.util.ResourceBundle;

// The controller component for the main view.
public class MainController implements Initializable {
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