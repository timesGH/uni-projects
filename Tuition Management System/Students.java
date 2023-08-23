import java.util.ArrayList;

public class Students {

    public ArrayList<Student> students = new ArrayList<Student>();
    
    public Students() {
        students.add(new Student("Thomas Muller", "thomas.muller@uts.com", "99991111", "3 Byern St. Sydney 2001", "13697480", "Full-Time", 48, 4000, null));
        students.add(new Student("Alice Stefan", "alice.stefan@uts.com", "88881111", "24 Pitt St. Sydney 2001", "14517880", "Part-Time", 24, 0, null));
        students.add(new Student("Lucy Lu", "lucy.lu@uts.com", "98981100", "11 Hunter St. Sydney 2100", "13267102", "Full-Time", 48, 0, "2022AUT"));
        students.add(new Student("Andreas Brehme", "andreas.b@uts.com", "90001222", "91 Sussex St. Sydney 2100", "13678020", "Full-Time", 48, 0, null));
        students.add(new Student("Ruddy Voller", "ruddy.v@uts.com", "98980000", "15 Stan St. Sydney 2100", "13972870", "Full-Time", 48, 8000, null));
        students.add(new Student("Monica Shwarz", "monica.s@uts.com", "92241188", "155 Jones St. Sydney 2001", "13659610", "Part-Time", 24, 0, "2022AUT"));
    }

    public void viewStudents() {
        Utils.studentHeader();
        for (Student student : students) {
            System.out.format(Utils.studentFormat, student.getName(), student.getEmail(), student.getPhone(), student.getType());
        }
        Utils.StudentFooter();
    }

    public void addStudent() {
        String name = Utils.string("Name");
        String email = Utils.string("Email");
        String phone = Utils.string("Phone");
        String address = Utils.string("Address");
        String ID = Utils.string("ID");
        String type = Utils.string("Type");
        int credits = Utils.number("Credits");
        double scholarship = Utils.amount("Scholarship($)");
        String deductionCode = Utils.string("Deduction Code");
        System.out.println(name + " record has been created.");
        students.add(new Student(name, email, phone, address, ID, type, credits, scholarship, deductionCode));
    }    

    public void viewStudent() {
        String name = Utils.string("Name");
        boolean check = true;
        for (Student student : students) {
            if (student.hasStudent(name)) {
                Utils.studentHeader();
                System.out.format(Utils.studentFormat, student.getName(), student.getEmail(), student.getPhone(), student.getType());
                Utils.StudentFooter();
                check = false;
            }
        }
        if (check == true) {
            System.out.println(name + " record does not exist!");
        }
    }

    public void updateStudent() {
        String name = Utils.string("Name");
        int count = 0;
        boolean check = true;
        for (Student student : students) {
            if (student.hasStudent(name)) {
                System.out.println("Updating " + name + " record: ");
                name = Utils.string("Name");
                String email = Utils.string("Email");
                String phone = Utils.string("Phone");
                String address = Utils.string("Address");
                String type = Utils.string("Type");
                int credits = Utils.number("Credits");
                double scholarship = Utils.amount("Scholarship($)");
                String deductionCode = Utils.string("Deduction Code");
                students.set(count, new Student(name, email, phone, address, student.getID(), type, credits, scholarship, deductionCode));
                check = false;
                System.out.println(name + " record has been updated.");
            }
            count += 1;
        }
        if (check == true) {
            System.out.println(name + " record does not exist!");
        }     
    }

    public void deleteStudent() {
        String name = Utils.string("Name");
        int count = 0;
        boolean check = true;
        for (Student student : students) {
            if (student.hasStudent(name)) {
                System.out.println(name + " record has been deleted.");
                check = false;
                students.remove(count);
            }
            if (check == false) {
                break;
            }
            count += 1;
        }
            if (check == true) {
                System.out.println(name + " record does not exist!");
                count = 0;
        } 
    }

    public void viewSlip() {
        String name = Utils.string("Name");
        boolean check = true;
        for (Student student : students) {
            if (student.hasStudent(name)) {
                Slip temp_slip = new Slip(student);
                System.out.println("Tuition Slip:");
                Utils.slipHeader();
                System.out.format(Utils.tmsFormat, temp_slip.getName(), temp_slip.gettotalFee(), temp_slip.getscholarship(), temp_slip.getnetFee(), temp_slip.getDeduction());
                Utils.SlipFooter();
                check = false;
            } 
        }
        if (check == true) {
        System.out.println("Tuition slip does not exist for " + name + "!");
        }
    }

    public ArrayList<Student> getStudentList() {
        return this.students;
    }

    public double scholarshipTotal() {
        double scholarshipTotal = 0;
        for (Student student : students) {
            scholarshipTotal += student.getScholarship();
        }
        return scholarshipTotal;
    }
}
