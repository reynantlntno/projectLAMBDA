// SUBJECT.java

import java.util.*;

class SUBJECT {
    private String CODE;
    private String TITLE;
    private String DESC;

    public SUBJECT(String TITLE, String DESC) {
        this.CODE = GENERATE_SUB_ID();
        this.TITLE = TITLE;
        this.DESC = DESC;
    }

    private String GENERATE_SUB_ID() {
        Random rand = new Random();
        return "SUB-" + (rand.nextInt(9000) + 1000);
    }

    // Getters and setters
    public String getCode() {
        return CODE;
    }

    public String getTitle() {
        return TITLE;
    }

    public String getDescription() {
        return DESC;
    }

    // Method overriding for polymorphism
    @Override
    public String toString() {
        return "SUBJECT: \n" + TITLE + ", CODE: " + CODE + ", DESC: " + DESC;
    }
}