// Entity.java

import java.util.*;

class Entity {
    private String ID;
    private String LAST_NAME;
    private String FIRST_NAME;
    private String MIDDLE_NAME;
    private String ADDRESS;
    private int AGE;

    public Entity(String ID, String LAST_NAME, String FIRST_NAME, String MIDDLE_NAME, String ADDRESS, int AGE) {
        this.ID = ID;
        this.LAST_NAME = LAST_NAME;
        this.FIRST_NAME = FIRST_NAME;
        this.MIDDLE_NAME = MIDDLE_NAME;
        this.ADDRESS = ADDRESS;
        this.AGE = AGE;
    }

    // Getters and setters
    public String getId() {
        return ID;
    }

    public void setId(String ID) {
        this.ID = ID;
    }

    public String getLastName() {
        return LAST_NAME;
    }

    public void setLastName(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public String getFirstName() {
        return FIRST_NAME;
    }

    public void setFirstName(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public String getMiddleName() {
        return MIDDLE_NAME;
    }

    public void setMiddleName(String MIDDLE_NAME) {
        this.MIDDLE_NAME = MIDDLE_NAME;
    }

    public String getAddress() {
        return ADDRESS;
    }

    public void setAddress(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public int getAge() {
        return AGE;
    }

    public void setAge(int AGE) {
        this.AGE = AGE;
    }

    // Method overriding for polymorphism
    @Override
    public String toString() {
        return "ID: " + ID + "\nName: " + FIRST_NAME + " " + LAST_NAME + "\nAddress: " + ADDRESS + "\nAge: " + AGE;
    }
}