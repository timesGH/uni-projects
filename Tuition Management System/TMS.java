import java.util.ArrayList;


public class TMS {
    private static double totalTuition;
    private static double totalScholarship;
    private static double totalNetFee;
    private static double totalDeduction;
    private static double totalBas;
    private String name;
    private Students students;
    private ArrayList<Slip> slips;
    private Faculty faculty;
    
    public TMS (Faculty faculty, Students students) {
        this.totalTuition = 0;
        this.totalScholarship = 0;
        this.totalNetFee = 0;
        this.totalDeduction = 0;
        this.totalBas = 0;
        this.slips = new ArrayList<Slip>();
        this.faculty = faculty;
        this.students = students;
        for (Student student : students.getStudentList()) {
            Slip temp = new Slip(student);
            totalTuition += temp.gettotalFee();
            totalScholarship += temp.getscholarship();
            totalNetFee += temp.getnetFee();
            totalDeduction += temp.getDeduction();
            totalBas += student.getBas();
            slips.add(temp);
        }
    }    
   
   public static void viewTMS(Faculty faculty, Students studentList) {
       System.out.println("TMS Report: ");
       Utils.slipHeader();
       for (Student student : studentList.getStudentList()) {
           Slip temp_slip = new Slip(student);
           System.out.format(Utils.tmsFormat, temp_slip.getName(), temp_slip.gettotalFee(), temp_slip.getscholarship(), temp_slip.getnetFee(), temp_slip.getDeduction());
       }
       Utils.SlipFooter();
       System.out.println("");
       TMS temp_TMS = new TMS(faculty, studentList);
       System.out.println("+--------------------+-------------+");
       System.out.format(Utils.sumFormat, "Total Tuition", temp_TMS.getTotalTuition());
       System.out.format(Utils.sumFormat, "Total Scholarship", temp_TMS.getTotalScholarship());
       System.out.format(Utils.sumFormat, "Total NetFee", temp_TMS.getTotalNetfee());
       System.out.format(Utils.sumFormat, "Total Deduction", temp_TMS.getTotalDeduction());
       System.out.format(Utils.sumFormat, "Total Bas", temp_TMS.getBas());
       System.out.println("+--------------------+-------------+");
       }

   public static double getTotalTuition() {
       return totalTuition;
   }
   
   public static double getTotalScholarship() {
       return totalScholarship;
   }

   public static double getTotalNetfee() {
       return totalNetFee;
   }

   public static double getTotalDeduction() {
       return totalDeduction;
   }

   public static double getBas() {
       return totalBas;
   }

   public ArrayList<Slip> getSlip() {
       return slips;
   }

   public boolean equals(TMS tms) {
        if (totalTuition == tms.getTotalTuition() && totalScholarship == tms.getTotalScholarship() && 
        totalNetFee == tms.getTotalNetfee() && totalDeduction == tms.getTotalDeduction() &&
        totalBas == tms.getBas()) {
        return true;
        }
        else {
            return false;
        }
   } 

   public Students getStudents() {
       return students;
   }
}
