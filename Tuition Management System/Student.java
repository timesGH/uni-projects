
import java.util.*;

public class Student {
    private String ID;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String type; 
    private int credits;
    private static double payPerCredit;
    private double totalFee;
    private double netFee;
    private double scholarship;
    private boolean deduction;
    private static double deductionRate;
    private Faculty faculty;
    private double bas;
    private String deductionCode;

    public Student (String name, String email, String phone, String address, String ID, String type, int credits, double scholarship, String deductionCode) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.ID = ID;
        this.type = type;
        this.credits = credits;
        this.scholarship = scholarship;
        this.deductionCode = deductionCode;
        payPerCredit = 500;
        totalFee = credits * payPerCredit;
        deductionRate = 0.10;
        if (deductionCode != null && deductionCode.equals("2022AUT")) {
            this.deduction = true;
        }
        else {
            this.deduction = false;
        }
        netFee = (this.deduction) ? (totalFee * 0.9 - scholarship) : (totalFee - scholarship);
        bas = (deduction) ? (scholarship + totalFee * 0.1) : scholarship;
    }

    public String getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }
    
    public String getPhone() {
        return this.phone;
    }

    public String getAddress() {
        return this.address;
    }

    public String getType() {
        return this.type;
    }

    public String getEmail() {
        return this.email; 
    }

    public int getCredit() {
        return this.credits;
    }

    public double getScholarship() {
        return this.scholarship;
    }

    public String getDeductioncode() {
        return this.deductionCode;
    }

    public double getDeductionrate() {
        return this.deductionRate;
    }
    
    public boolean getDeduction() {
        return this.deduction;
    }

    public double getTotalfee() {
        return this.totalFee;
    }
    
    public double getNetfee() {
        return this.netFee;
    }

    public double getBas() {
        return this.bas;
    }

    public boolean hasStudent(String name) {
        return this.name.equals(name);
    }
    

}
