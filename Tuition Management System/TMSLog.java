import java.util.ArrayList;
import java.util.*;

public class TMSLog {
    private ArrayList<TMS> tmsLog;
    private ArrayList<String> recordNameList;
    private ArrayList<String> recordIDList;
    private Integer count1;
    private Integer count2;
    public String IDRecord;
    public boolean similar = false;
    public Students studentList;
    public double previous = 0;
    
    public TMSLog() {
        tmsLog = new ArrayList<TMS>();
        recordNameList = new ArrayList<String>();
        recordIDList = new ArrayList<String>();
    }

    public void showTMS() {
        System.out.println("TMS Archive:");
        Utils.logHeader();
        for (int i = 0; i < tmsLog.size(); i++) {
            if (tmsLog.size() > 0) {
            System.out.format(Utils.logFormat, recordNameList.get(i), recordIDList.get(i));
            }
        }
        Utils.LogFooter();
    }

    public void archiveTMS(Faculty faculty) {
        addTMSRecord(faculty);
        if (similar) {
        }
        getRecordID(faculty);
        addRecordName();
        similar = false;
    }

    public void retrieveTMS() {
        String name = Utils.string("RecordID");
        if (tmsLog.size() <= 0) {
            System.out.println("No TMS is recorded as: " + name);
            }
        else if (!recordIDList.contains(name)) {
            System.out.println("No TMS is recorded as: " + name);
        }
        else {
            for (int i = 0; i < tmsLog.size(); i++) {
                if (recordIDList.get(i).equals(name)) {
                    TMS view = tmsLog.get(i);
                           System.out.println("TMS Report: ");
                            Utils.slipHeader();
                            for (Student student : view.getStudents().getStudentList()) {
                                Slip temp_slip = new Slip(student);
                                System.out.format(Utils.tmsFormat, temp_slip.getName(), temp_slip.gettotalFee(), temp_slip.getscholarship(), temp_slip.getnetFee(), temp_slip.getDeduction());
                                }
                                Utils.SlipFooter();
                                System.out.println("");
                                System.out.println("+--------------------+-------------+");
                                System.out.format(Utils.sumFormat, "Total Tuition", view.getTotalTuition());
                                System.out.format(Utils.sumFormat, "Total Scholarship", view.getTotalScholarship());
                                System.out.format(Utils.sumFormat, "Total NetFee", view.getTotalNetfee());
                                System.out.format(Utils.sumFormat, "Total Deduction", view.getTotalDeduction());
                                System.out.format(Utils.sumFormat, "Total Bas", view.getBas());
                                System.out.println("+--------------------+-------------+");
                                break;
                                }
                                }
                                }
                                }

    public String generateName(Faculty faculty) {
        if (count1 == null) {
            count1 = 1;
        }
        String temp = faculty.getName() + Integer.toString(count1);
        count1 += 1;
        return temp;
    }
    
    public String generateTMSName() {
        if (count2 == null) {
            count2 = 1;
        }
        String temp = "TMS " + Integer.toString(count2);
        if (recordNameList.contains(temp)) {
            count2 += 1;
            return "TMS " + Integer.toString(count2);
            }
        else {
            return temp;
        }
    }

    public void getRecordID(Faculty faculty) {
        String x = generateName(faculty);
        System.out.println("TMS record is created as:" + x);
        recordIDList.add(x);
        if (similar) {
            for (int i = 0; i < recordIDList.size(); i++) {
                recordIDList.set(i, x);
            }
        }
    }

    public void addTMSRecord(Faculty faculty){
        TMS tmsX = new TMS(faculty, faculty.getStudents());
        if (tmsX.getTotalNetfee() == previous) {
            similar = true;
        }
        studentList = tmsX.getStudents();
        tmsLog.add(tmsX);
        previous = tmsX.getTotalNetfee();
    }

    public void addRecordName() {
        String x = generateTMSName();
        recordNameList.add(x);
    }
}

