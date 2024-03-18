/* 
   Fuertez, Balce Vince, Quila
   BSIS 1A
   IS 102 Computer Programming 2
   IS 103 Data Structures and Algorithms
*/

// Subject.java
// put notes here (bug notes o kahit ano)


import java.util.*;

class Subject {
    private String code; // ID for the subject
    private String title; // Title of the subject
    private String description; // Description of the subject

    // Constructor
    public Subject(String title, String description) {
        this.code = generateSubId(); // Generate subject ID for the subject
        this.title = title;
        this.description = description;
    }

    // Generate a ID for the subject
    private String generateSubId() {
        Random rand = new Random();
        return "SUB-" + (rand.nextInt(9000) + 1000);
    }

    // Getters
    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    // Override toString method 
    @Override
    public String toString() {
        return "SUBJECT: \n" + title + ", CODE: " + code + ", DESCRIPTION: " + description;
    }
}
