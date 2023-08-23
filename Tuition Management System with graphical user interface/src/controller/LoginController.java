package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Session;


public class LoginController extends Controller<Session>{
    
    @FXML private TextField emailTf;
    @FXML private TextField passwordTf;
    @FXML private Button okBtn;
    @FXML private Button cancelBtn;
    @FXML private Label error;
    
    public final Session getSession() {
        return model;
    }
    
    private String getEmailTf() {
        return emailTf.getText();
    }
    
    private String getPasswordTf() {
        return passwordTf.getText();
    }
    
    @FXML private void handleLogin(ActionEvent event) throws Exception {
        if (getSession().getFaculty(getEmailTf(), getPasswordTf()) != null){
            Image logo = new Image(getClass().getResourceAsStream("/view/faculty.png"));
            Stage faculty = new Stage();
            faculty.getIcons().add(logo);
            error.setVisible(false);
            ViewLoader.showStage(getSession().getFaculty(getEmailTf(), getPasswordTf()), "/view/faculty.fxml", "Session Admin: " + getSession().getFaculty(getEmailTf(), getPasswordTf()).getName(), faculty);
        }
        else {
            error.setVisible(true);
        }
    } 
    
    @FXML public void handleExit(ActionEvent event) throws Exception {
        stage.close();
    }
    
}