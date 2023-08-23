
package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.*;

public class FacultyController extends Controller<Faculty>{
    
    @FXML private TableView<Student> studentTable;
    @FXML private TextField nameTf;
    @FXML private TextField emailTf;
    @FXML private Button deleteBtn;
    @FXML private Button selectBtn;
    @FXML private Button slipBtn;
    
    public final Faculty getFaculty() {
        return model;
    }
    
    @FXML private void initialize() {
        studentTable.getSelectionModel().selectedItemProperty().addListener((observable, oldSubject, newSubject) -> deleteBtn.setDisable(newSubject == null));
        studentTable.getSelectionModel().selectedItemProperty().addListener((observable, oldSubject, newSubject) -> selectBtn.setDisable(newSubject == null));
        studentTable.getSelectionModel().selectedItemProperty().addListener((observable, oldSubject, newSubject) -> slipBtn.setDisable(newSubject == null));
        nameTf.textProperty().addListener(Event -> model.filterList(nameTf.getText(), "0"));
        emailTf.textProperty().addListener(Event -> model.filterList("0", emailTf.getText()));
    }
    
    @FXML private void handleAdd() throws Exception{
        Student student = new Student("", "", "", "", "", "", 0, 0.0, "Code");
        getFaculty().addStudent(student);
        Image logo = new Image(getClass().getResourceAsStream("/view/edit.png"));
        Stage studentpage = new Stage();
        studentpage.getIcons().add(logo);
        ViewLoader.showStage(student, "/view/student.fxml", "Adding New Student", studentpage);
    }
        
    @FXML private void handleDelete() {
        getFaculty().removeStudent(getSelectedStudent());
    }
    
    
    @FXML private void handleSelect() throws Exception{
        Image logo = new Image(getClass().getResourceAsStream("/view/edit.png"));
        Stage studentpage = new Stage();
        studentpage.getIcons().add(logo);
        ViewLoader.showStage(getSelectedStudent(), "/view/student.fxml", "Accessing File: " + getSelectedStudent().getName(), studentpage);
    }

    @FXML private void handleSlip() throws Exception{
        Image logo = new Image(getClass().getResourceAsStream("/view/edit.png"));
        Stage slip = new Stage();
        slip.getIcons().add(logo);
        ViewLoader.showStage(getSelectedStudent(), "/view/slip.fxml", getSelectedStudent().getName() + " SLIP Report", slip);
    }
    
    @FXML private void handleReport() throws Exception{
        TMS tms = new TMS(getFaculty());
        Image logo = new Image(getClass().getResourceAsStream("/view/uts.jpeg"));
        Stage report = new Stage();
        report.getIcons().add(logo);
        ViewLoader.showStage(tms, "/view/tms.fxml", "TMS Report", report);
    }
    
    @FXML public void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
    
    private Student getSelectedStudent() {
        return studentTable.getSelectionModel().getSelectedItem();
    }
    
    private String getName() {
        return this.nameTf.getText();
    }
    
    private String getEmail() {
        return this.emailTf.getText();
    }
    
    
}
