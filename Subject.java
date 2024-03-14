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
    public String GET_CODE() {
        return CODE;
    }

    public String GET_TITLE() {
        return TITLE;
    }

    public String GET_DESC() {
        return DESC;
    }

    @Override
    public String toString() {
        return "SUBJECT: \n" + TITLE + ", CODE: " + CODE + ", DESCRIPTION: " + DESC;
    }
}