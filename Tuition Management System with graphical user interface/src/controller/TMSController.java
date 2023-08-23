package controller;

import au.edu.uts.ap.javafx.Controller;
import java.text.DecimalFormat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import model.*;



public class TMSController extends Controller<TMS>{
    @FXML private TableView<Report> tmsTable;
    @FXML private TableColumn<Report, String> tuitionCol;
    @FXML private TableColumn<Report, String> netFeeCol;
    @FXML private TableColumn<Report, String> scholarshipCol;
    @FXML private TableColumn<Report, String> deductionCol;
    @FXML private Text totalTuition;
    @FXML private Text totalNetFee;
    @FXML private Text totalBas;
    @FXML private Text totalScholarship;
    @FXML private Text totalDeduction;
    public final DecimalFormat df2 = new DecimalFormat("#.00");
    
    private void setTuition() {
      //  double formatDecimal = new Double(df2.format(getTMS().getTotalTuitionFee()));
        totalTuition.setText("$" + df2.format(getTMS().getTotalTuitionFee()));
    }
    
    private void setNetFee() {
        totalNetFee.setText("$" + df2.format(getTMS().getTotalNetFee()));
    }
    
    private void setBas() {
        totalBas.setText("$" + df2.format(getTMS().getBas()));
    }
    
    private void setScholarship() {
        totalScholarship.setText("$" + df2.format(getTMS().getTotalScholarship()));
    }
    
    private void setDeduction() {
        totalDeduction.setText("$" + df2.format(getTMS().getTotalDeduction()));
    }
    
    @FXML private void initialize() {
        tmsTable.setItems(getTMS().reports());
        tuitionCol.setCellValueFactory(cellData -> cellData.getValue().totalFeeProperty().asString("$%.2f"));
        scholarshipCol.setCellValueFactory(cellData -> cellData.getValue().totalFeeProperty().asString("$%.2f"));
        deductionCol.setCellValueFactory(cellData -> cellData.getValue().totalFeeProperty().asString("$%.2f"));
        netFeeCol.setCellValueFactory(cellData -> cellData.getValue().totalFeeProperty().asString("$%.2f"));
        setTuition();
        setNetFee();
        setBas();
        setScholarship();
        setDeduction();
    }
    
    
    public final TMS getTMS() {
        return model;
    }
    
    @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
}
