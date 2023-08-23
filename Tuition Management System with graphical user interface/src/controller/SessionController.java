package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Session;


public class SessionController extends Controller<Session> {
    @FXML private Button loginBtn;
    @FXML private Button exitBtn;
    
    public final Session getSession() {
        return model;
    }
    
    @FXML private void handleLogin(ActionEvent event) throws Exception {
        Image logo = new Image(getClass().getResourceAsStream("/view/book.png"));
        Stage login = new Stage();
        login.getIcons().add(logo);
        ViewLoader.showStage(getSession(), "/view/login.fxml", "Sign In", login);
    }
   
    @FXML private void handleExit(ActionEvent event) throws Exception {
        Platform.exit();
    }
    
}
