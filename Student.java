/* 
   Fuertez, Balce Vince, Quila
   BSIS 1A
   IS 102 Computer Programming 2
   IS 103 Data Structures and Algorithms
*/

// Student.java
// put notes here (bug notes o kahit ano)

import java.util.*;

class Student extends Entity {
    private List<Subject> subjects; // List of subjects enrolled by the student

    // Constructor
    public Student(String id, String lastName, String firstName, String middleName, String address, String emailAddress, String contactNumber, int age, int year) {
        super(id, lastName, firstName, middleName, address, emailAddress, contactNumber, year, age); // Call the superclass constructor
        this.subjects = new ArrayList<>(); // Initialize the subjects list
    }

    // Add a subject to the student's list of subjects
    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    // Get the list of subjects enrolled by the student
    public List<Subject> getSubjects() {
        return subjects;
    }

    // Override toString method 
    @Override
    public String toString() {
        return "STUDENT: \n" + super.toString(); 
    }
}
