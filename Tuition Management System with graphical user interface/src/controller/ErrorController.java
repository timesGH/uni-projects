package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.*;


public class ErrorController extends Controller<InputException>{
    
    public InputException getException() {
        return model;
    }
    
    @FXML public void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
}
