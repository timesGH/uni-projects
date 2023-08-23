public class Slip {

    private String name;
    private double totalFee;
    private double scholarship;
    private double netFee;
    private double deduction;

    public Slip(Student student) {
        this.name = student.getName();
        this.totalFee = student.getTotalfee();
        this.scholarship = student.getScholarship();
        this.netFee = student.getNetfee();
        this.deduction = (student.getDeduction()) ? this.totalFee * 0.1 : 0;
    }

    public String getName() {
        return name;
    }
 
    public double gettotalFee() {
        return totalFee;
    } 
    
    public double getscholarship() {
        return scholarship;
    }
    
    public double getnetFee() {
        return netFee;
    }
    
    public double getDeduction() {
        return deduction;
    }
}
