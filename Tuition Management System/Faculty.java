
public class Faculty {

    private String name;
    private String email;
    private String password;
    private Students students;
    private TMSLog tmsLog;

    public Faculty(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.students = new Students();
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public Students getStudents() {
        return students;
    }
}
