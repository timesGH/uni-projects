package controller;

import au.edu.uts.ap.javafx.Controller;
import java.text.DecimalFormat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import model.*;

public class SlipController extends Controller<Student>{
    
    @FXML private Text credit;
    @FXML private Text payPerCredit;
    @FXML private Text totalFee;
    @FXML private Text scholarship;
    @FXML private Text netFee;
    @FXML private Text deduction;
    public final DecimalFormat df2 = new DecimalFormat("0.00");
    
    public Student getStudent() {
        return model;
    }
    
    public final void setCredit() {
        credit.setText(getStudent().getCredits() + " credits");
    }
            
    public final void setPayPerCredit() {
        payPerCredit.setText("$" + df2.format(getStudent().getPayPerCredit()));
    }
        
    public final void setTotalFee() {
        totalFee.setText("$" + df2.format(getStudent().getTotalFee()));
    }

    public final void setScholarship() {
        scholarship.setText("$" + df2.format(getStudent().getScholarship()));
    }
    
    public final void setNetFee() {
        netFee.setText("$" + df2.format(getStudent().getNetFee()));
    }
    
    public final void setDeduction() {
        deduction.setText("$" + df2.format(getStudent().getDeduction()));
    }

    @FXML private void initialize() {
        setCredit();
        setPayPerCredit();
        setTotalFee();
        setScholarship();
        setNetFee();
        setDeduction();
    }
    
    @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
}
