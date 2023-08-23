package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import com.sun.deploy.util.StringUtils;
import java.util.LinkedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;


public class StudentController extends Controller<Student>{
    @FXML private TextField nameTf;
    @FXML private TextField emailTf;
    @FXML private TextField phoneTf;
    @FXML private TextField addressTf;
    @FXML private TextField studentIdTf;
    @FXML private TextField typeTf;
    @FXML private TextField creditsTf;
    @FXML private TextField scholarshipTf;
    @FXML private TextField deductionTf;
    @FXML private Button updateBtn;
    @FXML private Button addBtn;
//    @FXML private Label test;
    
    private final LinkedList<String> errorsList = new LinkedList<String>();
    public final Validator validator = new Validator();
//    public final StringBuilder errorsList = new StringBuilder();

//    public final LinkedList<String> getError() {
//        return errors2;
//    }
    
    private String setError() {
        errorsList.clear();
        for (String x : validator.errors()) {
            errorsList.add(x);
            }
        String s = errorsList.toString();
        String x = s.substring(1, s.length()-1);
        return x.replace(", ", "");
    }
    
    private final void setNameTf() {
        nameTf.setText(getStudent().getName());
    }
    
    private final void setEmailTf() {
        emailTf.setText(getStudent().getEmail());
    }
    
    private final void setPhoneTf() {
        phoneTf.setText(getStudent().getPhone());
    }
    
    private final void setAddressTf() {
        addressTf.setText(getStudent().getAddress());
    }
    
    private final void setStudentIdTf() {
        studentIdTf.setText(getStudent().getID());
    }
    
    private final void setTypeTf() {
        typeTf.setText(getStudent().getType());
    }
    
    private final void setCreditsTf() {
        creditsTf.setText("" + getStudent().getCredits());
    }
    
    private final void setScholarshipTf() {
        scholarshipTf.setText("" + getStudent().getScholarship());
    }
    
    private final void setDeductionTf() {
        deductionTf.setText("" + getStudent().getDeduction());
    }
    
    @FXML private void initialize() {
        if (getStudent().getName().equals("")) {
            setNameTf();
            setEmailTf();
            setPhoneTf();
            setAddressTf();
            setStudentIdTf();
            setTypeTf();
            setCreditsTf();
            setScholarshipTf();
            deductionTf.setText("Code");
            updateBtn.setDisable(true);
        }
        else {
            setNameTf();
            setEmailTf();
            setPhoneTf();
            setAddressTf();
            setStudentIdTf();
            setTypeTf();
            setCreditsTf();
            setScholarshipTf();
            setDeductionTf();
            addBtn.setDisable(true);
        }
    }
    
    public final Student getStudent() {
        return model;
    }
    
    public final Faculty getFaculty() {
        return getStudent().getFaculty();
    }
    
    public String getName() {
        return nameTf.getText();
    }
    
    public String getEmail() {
        return emailTf.getText();
    }
    
    public String getPhone() {
        return phoneTf.getText();
    }
    
    public String getAddress() {
        return addressTf.getText();
    }
    
    public String getStudentID() {
        return studentIdTf.getText();
    }
    
    public String getType() {
        return typeTf.getText();
    }
    
    public String getCredits() {
        if (validator.isEmpty(creditsTf.getText())) {
            return "0";
        }
        else {
            return creditsTf.getText();
        }
      //  String credits = creditsTf.toString();
      //  return Integer.parseInt(credits);
    }
    
    public String getScholarship() {
        if (validator.isEmpty(scholarshipTf.getText())) {
            return "0";
        }
        else {
            return scholarshipTf.getText();
        }
        //String scholarship = scholarshipTf.toString();
        //return Double.parseDouble(scholarship);
    }
    
    public String getDeductionCode() {
        if (validator.isEmpty(deductionTf.getText())) {
            return "0";
        }
        else {
            return deductionTf.getText();
        }
    }
    
    public String changeDeduction(String deductionCode) {
        try {
            if (deductionCode.equals("2022AUT")) {
                return "2022AUT";
            }
            double doubleValue = Double.parseDouble(deductionCode);
            double test = 0;
            if (doubleValue != test) {
                return "2022AUT";
            }
            else {
                return "";
            }
        }
        catch (NumberFormatException e){
            return "";
        }
    }
    
    @FXML public void handleAdd() throws Exception{
        boolean valid = validator.isValid(getName(), getEmail(), getPhone(),getAddress(),
                getType(), getStudentID(), Integer.parseInt(getCredits()), Double.parseDouble(getScholarship()));
        if (valid) {
            getStudent().updateDetails(getName(), getEmail(), getPhone(), getAddress(), getStudentID(), 
                    getType(), Integer.parseInt(getCredits()), Double.parseDouble(getScholarship()), getDeductionCode());
            stage.close();
        }
        else {
            validator.clear();
            validator.generateErrors(getName(), getEmail(), getPhone(),getAddress(), getType(), getStudentID(), Integer.parseInt(getCredits()), Double.parseDouble(getScholarship()));
            Image logo = new Image(getClass().getResourceAsStream("/view/error.png"));
            Stage error = new Stage();
            error.getIcons().add(logo);
            ViewLoader.showStage(new InputException(setError()), "/view/error.fxml", "Input Exceptions", error);  
        }
    }
    
    @FXML public void handleUpdate() throws Exception{
//        this.errors2 = validator.errors();
//        test.setText(errors2.get(0));
        boolean valid = validator.isValid(getName(), getEmail(), getPhone(),getAddress(),
                getType(), getStudentID(), Integer.parseInt(getCredits()), Double.parseDouble(getScholarship()));
        if (valid) {
            getStudent().updateDetails(getName(), getEmail(), getPhone(), getAddress(), getStudentID(), 
                    getType(), Integer.parseInt(getCredits()), Double.parseDouble(getScholarship()), changeDeduction(getDeductionCode()));
            stage.close();
        }
        else {
            validator.clear();
            validator.generateErrors(getName(), getEmail(), getPhone(),getAddress(), getType(), getStudentID(), Integer.parseInt(getCredits()), Double.parseDouble(getScholarship()));
            Image logo = new Image(getClass().getResourceAsStream("/view/error.png"));
            Stage error = new Stage();
            error.getIcons().add(logo);
            ViewLoader.showStage(new InputException(setError()), "/view/error.fxml", "Input Exceptions", error);
        }
    }
    
    @FXML public void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
    
}
