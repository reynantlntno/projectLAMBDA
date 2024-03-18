/* Fuertez, Balce Vince, Quila
   BSIS 1A
   IS 102 Computer Programming 2
   IS 103 Data Structures and Algorithms

*/


// Instructor.java
// put notes here

import java.util.*;

class Instructor extends Entity {
    private List<Subject> subjects;

    public Instructor(String id, String lastName, String firstName, String middleName, String address, String emailAddress, String contactNumber, int age, int year) {
        super(id, lastName, firstName, middleName, address, emailAddress, contactNumber, year, age);
        this.subjects = new ArrayList<>();
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    @Override
    public String toString() {
        return "INSTRUCTOR: \n" + super.toString();
    }
}
