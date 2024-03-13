// STUDENT.java

import java.util.*;

class STUDENT extends Entity {
    private List<SUBJECT> SUBJECTS;

    public STUDENT(String ID, String LAST_NAME, String FIRST_NAME, String MIDDLE_NAME, String ADDRESS, int AGE) {
        super(ID, LAST_NAME, FIRST_NAME, MIDDLE_NAME, ADDRESS, AGE);
        this.SUBJECTS = new ArrayList<>();
    }

    public void ADD_SUBJECT(SUBJECT SUBJECT) {
        SUBJECTS.add(SUBJECT);
    }

    public List<SUBJECT> GET_SUBS() {
        return SUBJECTS;
    }

    // Method overriding for polymorphism
    @Override
    public String toString() {
        return "STUDENT: \n" + super.toString();
    }
}
