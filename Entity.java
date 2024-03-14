// Entity.java
// put notes here

class Entity {
    private String ID;
    private String LAST_NAME;
    private String FIRST_NAME;
    private String MIDDLE_NAME;
    private String ADDRESS;
    private String EMAIL_ADDRESS;
    private String CONTACT_NUMBER;
    private int YEAR;
    private int AGE;


    public Entity(String ID, String LAST_NAME, String FIRST_NAME, String MIDDLE_NAME, String ADDRESS, String EMAIL_ADDRESS, String CONTACT_NUMBER, int YEAR, int AGE) {
        this.ID = ID;
        this.LAST_NAME = LAST_NAME;
        this.FIRST_NAME = FIRST_NAME;
        this.MIDDLE_NAME = MIDDLE_NAME;
        this.ADDRESS = ADDRESS;
        this.EMAIL_ADDRESS = EMAIL_ADDRESS;
        this.CONTACT_NUMBER = CONTACT_NUMBER;
        this.YEAR = YEAR;
        this.AGE = AGE;

    }

    public String GET_ID() {
        return ID;
    }

    public void SET_ID(String ID) {
        this.ID = ID;
    }

    public String GET_LASTNAME() {
        return LAST_NAME;
    }

    public void SET_LASTNAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public String GET_FIRSTNAME() {
        return FIRST_NAME;
    }

    public void SET_FIRSTNAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public String GET_MIDDLENAME() {
        return MIDDLE_NAME;
    }

    public void SET_MIDDLENAME(String MIDDLE_NAME) {
        this.MIDDLE_NAME = MIDDLE_NAME;
    }

    public String GET_ADDRESS() {
        return ADDRESS;
    }

    public void SET_ADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String GET_EMAILADD() {
        return ADDRESS;
    }

    public void SET_EMAILADD(String EMAIL_ADDRESS) {
        this.EMAIL_ADDRESS = EMAIL_ADDRESS;
    }

    public String GET_CONTACTNUM() {
        return CONTACT_NUMBER;
    }

    public void SET_CONTACTNUM(String CONTACT_NUMBER) {
        this.CONTACT_NUMBER = CONTACT_NUMBER;
    }

    public int GET_YEAR() {
        return YEAR;
    }

    public void SET_YEAR(int YEAR) {
        this.YEAR = YEAR;
    }

    public int GET_AGE() {
        return AGE;
    }

    public void SET_AGE(int AGE) {
        this.AGE = AGE;
    }

    @Override
    public String toString() {
        return "ID: " + ID + "\nName: " + FIRST_NAME + " " + LAST_NAME + "\nAddress: " + ADDRESS + "\nEmail Address: " + EMAIL_ADDRESS + "\nContact Number: " + CONTACT_NUMBER + "\nYear Start: 20" + YEAR + "\nAge: " + AGE;
    }
}