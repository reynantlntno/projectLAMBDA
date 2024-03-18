/* Fuertez, Balce Vince, Quila
   BSIS 1A
   IS 102 Computer Programming 2
   IS 103 Data Structures and Algorithms

*/


// Instructor.java
// put notes here (bug notes o kahit ano)


import java.util.*;

class Instructor extends Entity {
    private List<Subject> subjects; // List of subjects handled by the instructor

    // Constructor
    public Instructor(String id, String lastName, String firstName, String middleName, String address, String emailAddress, String contactNumber, int age, int year) {
        super(id, lastName, firstName, middleName, address, emailAddress, contactNumber, year, age); // Call the superclass constructor
        this.subjects = new ArrayList<>(); // Initialize the subjects list
    }

    // Add a subject to the instructor's list of subjects
    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    // Get the list of subjects handled by the instructor
    public List<Subject> getSubjects() {
        return subjects;
    }

    // Override toString method
    @Override
    public String toString() {
        return "INSTRUCTOR: \n" + super.toString(); 
    }
}
