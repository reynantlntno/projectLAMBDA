/* Fuertez, Balce Vince, Quila
   BSIS 1A
   IS 102 Computer Programming 2
   IS 103 Data Structures and Algorithms

*/

// Entity.java
// put notes here (bug notes o kahit ano)


class Entity {
    private String id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private String emailAddress;
    private String contactNumber;
    private int year;
    private int age;

    public Entity(String id, String lastName, String firstName, String middleName, String address, String emailAddress, String contactNumber, int year, int age) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.emailAddress = emailAddress;
        this.contactNumber = contactNumber;
        this.year = year;
        this.age = age;
    }

    // get & set (setter and getter)

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + firstName + " " + lastName + "\nAddress: " + address + "\nEmail Address: " + emailAddress + "\nContact Number: " + contactNumber + "\nYear Start: 20" + year + "\nAge: " + age;
    }
}
