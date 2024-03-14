// INSTRUCTOR.java
// put notes here

import java.util.*;

class INSTRUCTOR extends Entity {
    private List<SUBJECT> SUBJECTS;

    public INSTRUCTOR(String ID, String LAST_NAME, String FIRST_NAME, String MIDDLE_NAME, String ADDRESS, String EMAIL_ADDRESS, String CONTACT_NUMBER, int AGE, int YEAR) {
        super(ID, LAST_NAME, FIRST_NAME, MIDDLE_NAME, ADDRESS, EMAIL_ADDRESS, CONTACT_NUMBER, AGE, YEAR);
        this.SUBJECTS = new ArrayList<>();
    }

    public void ADD_SUBJECT(SUBJECT SUBJECT) {
        SUBJECTS.add(SUBJECT);
    }

    public List<SUBJECT> GET_SUBS() {
        return SUBJECTS;
    }

    @Override
    public String toString() {
        return "INSTRUCTOR: \n" + super.toString();
    }
}

