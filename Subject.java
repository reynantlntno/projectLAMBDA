/* Fuertez, Balce Vince, Quila
   BSIS 1A
   IS 102 Computer Programming 2
   IS 103 Data Structures and Algorithms

*/


// Subject.java
// put notes here

import java.util.*;

class Subject {
    private String code;
    private String title;
    private String description;

    public Subject(String title, String description) {
        this.code = generateSubId();
        this.title = title;
        this.description = description;
    }

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

    @Override
    public String toString() {
        return "SUBJECT: \n" + title + ", CODE: " + code + ", DESCRIPTION: " + description;
    }
}
