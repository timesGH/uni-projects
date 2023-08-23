
import java.util.ArrayList;


public class Faculties {

    private ArrayList<Faculty> faculties = new ArrayList<Faculty>();
    
    public Faculties() {
        faculties.add(new Faculty("John Smith", "john.smith@uts.com", "user222"));
        faculties.add(new Faculty("Jane Tyler", "jane.tyler@uts.com", "super123"));
    }
    
    public Faculty matchingFaculties(String email, String password) {
        for (Faculty faculty: faculties) {
            if (faculty.getEmail().equals(email) && faculty.getPassword().equals(password)){
                return faculty;
            }
        }
        return null;
    }
}

