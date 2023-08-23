public class Session {
    private Faculties faculties;
    private String email;
    private String password;
    private Faculty faculty;
    private TMSLog tmslog;

    public Session() {
        faculties = new Faculties();
    }

    public static void main(String[] args) {
        new Session().use();
        System.out.println("Session Terminated!");
    }
    
    public void use() {
        boolean showHelp = true;
        boolean showTitle = true;
        boolean altTitle = false;
        while (true) {
            if (showTitle) {
                if (altTitle) {
                    System.out.println("TMS Tuition Management System:");
                }
                else {
                    System.out.println("Tuition Management System:");   
                }
                showTitle = false;
            }
            if (showHelp) {
                System.out.println("L- Login");
                System.out.println("X- Exit");
                showHelp = false;
            }
            char choice = readLoginCommand();
            switch (choice) {
                case 'L': showTitle = login(); altTitle = true; break;
                case 'X': System.out.println(""); return;
                default: showHelp = true; showTitle = true; break;
            }
        }
    }

    private char readLoginCommand() {
        String choice = "Command (L/X)";
        return Utils.choice(choice);
    }

    private boolean login() {
        String email = Utils.string("Email");
        String password = Utils.string("Password");
        this.email = email;
        this.password = password;
        Faculty faculty = faculties.matchingFaculties(email, password);
        if (faculty != null) {
            adminMenu(faculty);
            faculty = this.faculty;
            return true;
        }
        else {
            System.out.println("Incorrect faculty details!");
            return false;
        }
    }

    private void adminMenu(Faculty faculty) {
        boolean showHelp = true;
        while (true) {
            if (showHelp) {
                adminHelp();
                showHelp = false;
            }
            char choice = readAdminCommand(faculty);
            switch (choice) {
                case 'C': faculty.getStudents().addStudent(); break;
                case 'R': faculty.getStudents().viewStudent(); break;
                case 'U': faculty.getStudents().updateStudent(); break;
                case 'D': faculty.getStudents().deleteStudent(); break;
                case 'V': faculty.getStudents().viewStudents(); break;
                case 'T': TMSMenu(); break;
                case 'X': System.out.println(""); return;
                default: break;
            }
        }
    }

    private char readAdminCommand(Faculty faculty) {
        String choice = "Session Admin: " + faculty.getName() + " - Menu Commands (C/R/U/D/V/T/X)";
        return Utils.choice(choice);
    }

    private void TMSMenu() {
        boolean showHelp = true;
        Faculty faculty = faculties.matchingFaculties(email, password);
        if (tmslog == null) {
            tmslog = new TMSLog();
        }
        while (true) {
            if (showHelp) {
                TMSHelp();
                showHelp = false;
            }
        char choice = readTMSCommand(faculty);
        switch (choice) {
            case 'F': faculty.getStudents().viewSlip(); break;
            case 'V': TMS.viewTMS(faculty, faculty.getStudents()); break;
            case 'A': tmslog.archiveTMS(faculty); break;
            case 'R': tmslog.retrieveTMS(); break;
            case 'S': tmslog.showTMS(); break;
            case 'X': System.out.println(""); System.out.println("Faculty Menu:"); return;
            default: break;
            }
        }
    }

    private char readTMSCommand(Faculty faculty) {
        String choice = "Session Admin: " + faculty.getName() + " - Menu Commands (F/V/A/R/S/X)";
        return Utils.choice(choice);
    }

    private void TMSHelp() {
        System.out.println("TMS Menu: ");
        System.out.println("F- Find Tuition Slip");
        System.out.println("V- View TMS Report");
        System.out.println("A- Archive TMS Report");
        System.out.println("R- Retrieve TMS Report");
        System.out.println("S- Show TMS Log");
        System.out.println("X- Close");
    }

    private void adminHelp() {
        System.out.println("Admin Menu: ");
        System.out.println("C- Add Student");
        System.out.println("R- View Student");
        System.out.println("U- Update Student");
        System.out.println("D- Delete Student");
        System.out.println("V- View Students");
        System.out.println("T- TMS Menu");
        System.out.println("X- Logout");
    }
}
