// LAMBDA.java

// put notes here
// ** scanner.next should be added

import java.util.*;

public class LAMBDA {
    private static Scanner scanner = new Scanner(System.in);
    private static List<INSTRUCTOR> INSTRUCTORS = new ArrayList<>();
    private static List<STUDENT> STUDENTS = new ArrayList<>();
    private static List<SUBJECT> SUBJECTS = new ArrayList<>();
    private static final int MIN_INSTRUCTOR_AGE = 24;
    private static final int MIN_STUDENT_AGE = 17;

    public static void main(String[] args) {
        SHOW_SPL();
        PROMPT_LOGIN();
        LAMBDA_CAPTCHA();
        while (true) {
            SHOW_MENU();
            String choice = GET_CHOICE();
            switch (choice) {
                case "1":
                    ADD_INSTRUCTOR();
                    break;
                case "2":
                    ADD_STUDENT();
                    break;
                case "3":
                    ADD_SUBJECT();
                    break;
                case "4":
                    ASSIGN_SUB_TO_INS();
                    break;
                case "5":
                    ADD_SUB_TO_ST();
                    break;
                case "6":
                    SHOW_ST_INFO();
                    break;
                case "7":
                    SHOW_INS_INFO();
                    break;
                case "8":
                    REM_STUDENT();
                    break;
                case "9":
                    REM_INSTRUCTOR();
                    break;
                case "10":
                    REM_SUBJECT();
                    break;
                case "11":
                    EDIT_INSTRUCTOR_DETAILS();
                    break;
                case "12":
                    EDIT_STUDENT_DETAILS();
                    break;
                case "CLEAR":
                    CLEAR_SCREEN();
                    SHOW_SPL();
                    break;
                case "EXIT":
                    CLEAR_SCREEN();
                    System.out.println("Exiting LAMBDA...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void CLEAR_SCREEN() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void SHOW_SPL() {
        double LAMBDA_VERS = 1.0;
        String LAMBDA_STAT = "ALPHA";
        String SPLASH_TXT = " LAMBDA " + LAMBDA_VERS + " ";
        System.out.print("\n[" + SPLASH_TXT +  "   UMPS         " + LAMBDA_STAT  + " ]\n");
    }

    private static void PROMPT_LOGIN() {
        System.out.print("Please enter your username for record purposes: ");
        String USERNAME = scanner.nextLine();
        System.out.print("Hello " + USERNAME + "! Please answer the question below: \n");

    }

    private static void LAMBDA_CAPTCHA() {
        int attempts = 0;
        while (attempts < 2) {
            try {
                System.out.print("\n10 * 10 = ");
                int PRODUCT = scanner.nextInt();
                if (PRODUCT == 100) {
                    System.out.print("Correct Answer! \n");
                    CLEAR_SCREEN();
                    SHOW_SPL();
                    return;
                } else {
                    System.out.print("Wrong Answer! \n");
                    attempts++;
                    if (attempts == 2) {
                        System.out.println("Maximum attempts reached. Exiting...");
                        System.exit(0);
                    }
                    System.out.println("You have " + (2 - attempts) + " attempts remaining.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Try again.");
                scanner.nextLine();
            }
        }
    }

    private static void SHOW_MENU() {

        System.out.println("\n" + "=".repeat(62));
        System.out.println("No     | Option");
        System.out.println("-------+------------------------------------------------------");
        System.out.println(" 1     | Add INSTRUCTOR");
        System.out.println(" 2     | Add STUDENT");
        System.out.println(" 3     | Add SUBJECT");
        System.out.println(" 4     | Assign SUBJECT to INSTRUCTOR");
        System.out.println(" 5     | Add SUBJECT to STUDENT");
        System.out.println(" 6     | Display STUDENT's Information and SUBJECT Details");
        System.out.println(" 7     | Display INSTRUCTOR's Details and SUBJECTS Handled");
        System.out.println(" 8     | Unenroll a STUDENT");
        System.out.println(" 9     | Remove a INSTRUCTOR");
        System.out.println(" 10    | Remove a SUBJECT");
        System.out.println(" 11    | Edit INSTRUCTOR Details");
        System.out.println(" 12    | Edit STUDENT Details");
        System.out.println(" CLEAR | Clear Screen");
        System.out.println(" EXIT  | Exit LAMBDA");
        System.out.println("=".repeat(62));
        System.out.print("Enter your choice: ");
    }

    private static String GET_CHOICE() {
        while (!scanner.hasNext()) {
            System.out.println("Invalid input! Please enter a number.");
            scanner.next();
        }
        return scanner.next();
    }

    private static void ADD_INSTRUCTOR() {
        System.out.println("-".repeat(62));
        System.out.println("INSTRUCTOR ADD: PLEASE CORRECTLY TYPE THE DETAILS!");
        System.out.println("-".repeat(62));

        try {
            scanner.nextLine();
            System.out.print("Enter last name: ");
            String lastName = scanner.nextLine().trim();
            if (lastName.isEmpty()) {
                throw new IllegalArgumentException("Last name cannot be empty.");
            }
            if (!isValidName(lastName)) {
                throw new IllegalArgumentException("Last name cannot contain numeric characters.");
            }

            System.out.print("Enter first name: ");
            String firstName = scanner.nextLine().trim();
            if (firstName.isEmpty()) {
                throw new IllegalArgumentException("First name cannot be empty.");
            }
            if (!isValidName(firstName)) {
                throw new IllegalArgumentException("First name cannot contain numeric characters.");
            }

            System.out.print("Enter middle name (optional): ");
            String middleName = scanner.nextLine().trim();
            if (!isValidName(middleName)) {
                throw new IllegalArgumentException("Middle name cannot contain numeric characters.");
            }

            System.out.print("Enter Address: ");
            String address = scanner.nextLine().trim();

            System.out.print("Enter Email Address: ");
            String emailAddress = scanner.nextLine().trim();

            System.out.print("Enter Contact Number: ");
            String contactNumber = scanner.nextLine().trim();

            System.out.print("Enter Start Year: 20");
            int year = scanner.nextInt();
            int age;
            do {
                System.out.print("Enter Age (>= " + MIN_INSTRUCTOR_AGE + "): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid Age! Please enter a valid Age.");
                    scanner.nextLine();
                }
                age = scanner.nextInt();
            } while (age < MIN_INSTRUCTOR_AGE);

            String ID = GENERATE_INS_ID(year);
            INSTRUCTOR instructor = new INSTRUCTOR(ID, lastName, firstName, middleName, address, emailAddress,
                    contactNumber, age, year);
            INSTRUCTORS.add(instructor);
            System.out.println("INSTRUCTOR added successfully. Details: \n" + instructor);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter valid data.");
            scanner.nextLine();
            ADD_INSTRUCTOR();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static boolean isValidName(String name) {
        for (char c : name.toCharArray()) {
            if (Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private static String GENERATE_INS_ID(int YEAR) {
        Random rand = new Random();
        return "INS" + YEAR + "-" + (rand.nextInt(9000) + 1000);
    }

    private static void ADD_STUDENT() {
           System.out.print("\n==============================================================");
        System.out.println("STUDENT ADD: PLEASE CORRECTLY TYPE THE DETAILS!");
           System.out.print("\n==============================================================");

        try {
            scanner.nextLine();
            System.out.print("Enter last name: ");
            String lastName = scanner.nextLine().trim();
            if (lastName.isEmpty()) {
                throw new IllegalArgumentException("Last name cannot be empty.");
            }
            if (!isValidName(lastName)) {
                throw new IllegalArgumentException("Last name cannot contain numeric characters.");
            }

            System.out.print("Enter first name: ");
            String firstName = scanner.nextLine().trim();
            if (firstName.isEmpty()) {
                throw new IllegalArgumentException("First name cannot be empty.");
            }
            if (!isValidName(firstName)) {
                throw new IllegalArgumentException("First name cannot contain numeric characters.");
            }

            System.out.print("Enter middle name (optional): ");
            String middleName = scanner.nextLine().trim();
            if (!isValidName(middleName)) {
                throw new IllegalArgumentException("Middle name cannot contain numeric characters.");
            }

            System.out.print("Enter Address: ");
            String address = scanner.nextLine().trim();

            System.out.print("Enter Email Address: ");
            String emailAddress = scanner.nextLine().trim();

            System.out.print("Enter Contact Number: ");
            String contactNumber = scanner.nextLine().trim();

            System.out.print("Enter Start Year: 20");
            int year = scanner.nextInt();

            int age;
            do {
                System.out.print("Enter Age (>= " + MIN_STUDENT_AGE + "): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid Age! Please enter a valid Age.");
                    scanner.nextLine();
                }
                age = scanner.nextInt();
            } while (age < MIN_STUDENT_AGE);

            String ID = GENERATE_ST_ID(year);
            STUDENT student = new STUDENT(ID, lastName, firstName, middleName, address, emailAddress,
                    contactNumber, age, year);
            STUDENTS.add(student);
            System.out.println("Student added successfully. Details: \n" + student);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Try again.");
            scanner.nextLine();
            ADD_STUDENT();
        }
    }

    private static String GENERATE_ST_ID(int YEAR) {
        Random rand = new Random();
        return "ST" + YEAR + "-" + (rand.nextInt(9000) + 1000);
    }

    private static void ADD_SUBJECT() {
        System.out.println("-".repeat(62));
        System.out.println("SUBJECT ADD: PLEASE CORRECTLY TYPE THE DETAILS!");
        System.out.println("-".repeat(62));
        scanner.nextLine();
        System.out.print("Enter Subject Title: ");
        String TITLE = scanner.nextLine();
        System.out.print("Enter Subject Description: ");
        String DESC = scanner.nextLine();
        SUBJECT SUBJECT = new SUBJECT(TITLE, DESC);
        SUBJECTS.add(SUBJECT);
        System.out.println("Subject added successfully with Details: \n" + SUBJECT);
    }

    private static void ASSIGN_SUB_TO_INS() {
        scanner.nextLine();
        System.out.print("Enter Instructor ID: ");
        String INSTRUCTOR_ID = scanner.nextLine();
        INSTRUCTOR INSTRUCTOR = FIND_INS_ID(INSTRUCTOR_ID);
        if (INSTRUCTOR == null) {
            System.out.println("Invalid Instructor ID.");
            return;
        }

        System.out.print("Enter Subject Code: ");
        String SUBJECT_ID = scanner.nextLine();
        SUBJECT SUBJECT = FIND_SUB_ID(SUBJECT_ID);
        if (SUBJECT == null) {
            System.out.println("Invalid Subject Code.");
            return;
        }

        INSTRUCTOR.ADD_SUBJECT(SUBJECT);
        System.out.println("Subject assigned to Instructor successfully.");

    }

    private static void ADD_SUB_TO_ST() {
        scanner.nextLine();
        System.out.print("Enter Student ID: ");
        String STUDENT_ID = scanner.nextLine();
        STUDENT STUDENT = FIND_ST_ID(STUDENT_ID);
        if (STUDENT == null) {
            System.out.println("Invalid Student ID.");
            return;
        }

        System.out.print("Enter Subject Code: ");
        String SUBJECT_ID = scanner.nextLine();
        SUBJECT SUBJECT = FIND_SUB_ID(SUBJECT_ID);
        if (SUBJECT == null) {
            System.out.println("Invalid Subject Code.");
            return;
        }

        STUDENT.ADD_SUBJECT(SUBJECT);
        System.out.println("Subject added to Student successfully.");
    }

    private static void SHOW_ST_INFO() {
        scanner.nextLine();
        System.out.print("Enter Student ID: ");
        String STUDENT_ID = scanner.nextLine();
        STUDENT STUDENT = FIND_ST_ID(STUDENT_ID);
        if (STUDENT == null) {
            System.out.println("Invalid Student ID.");
            return;
        }

        System.out.println(STUDENT);
        List<SUBJECT> studentSubjects = STUDENT.GET_SUBS();
        if (studentSubjects.isEmpty()) {
            System.out.println("No Subjects assigned to this Student.");
        } else {
            System.out.println("Subjects Assigned:");
            for (SUBJECT SUBJECT : studentSubjects) {
                System.out.println("- " + SUBJECT);
            }
        }
    }

    private static void SHOW_INS_INFO() {
        scanner.nextLine();
        System.out.print("Enter Instructor ID: ");
        String INSTRUCTOR_ID = scanner.nextLine();
        INSTRUCTOR INSTRUCTOR = FIND_INS_ID(INSTRUCTOR_ID);
        if (INSTRUCTOR == null) {
            System.out.println("Invalid Instructor ID.");
            return;
        }

        System.out.println(INSTRUCTOR);
        List<SUBJECT> INSTRUCTOR_SUBS = INSTRUCTOR.GET_SUBS();
        if (INSTRUCTOR_SUBS.isEmpty()) {
            System.out.println("No Subjects assigned to this Instructor.");
        } else {
            System.out.println("SUBJECTS Handled:");
            for (SUBJECT SUBJECT : INSTRUCTOR_SUBS) {
                System.out.println("- " + SUBJECT);
            }
        }
    }

    private static INSTRUCTOR FIND_INS_ID(String ID) {
        for (INSTRUCTOR INSTRUCTOR : INSTRUCTORS) {
            if (INSTRUCTOR.GET_ID().equals(ID)) {
                return INSTRUCTOR;
            }
        }
        return null;
    }

    private static STUDENT FIND_ST_ID(String ID) {
        for (STUDENT STUDENT : STUDENTS) {
            if (STUDENT.GET_ID().equals(ID)) {
                return STUDENT;
            }
        }
        return null;
    }

    private static SUBJECT FIND_SUB_ID(String CODE) {
        for (SUBJECT SUBJECT : SUBJECTS) {
            if (SUBJECT.GET_CODE().equals(CODE)) {
                return SUBJECT;
            }
        }
        return null;
    }

    private static void REM_STUDENT() {
        scanner.nextLine();
        System.out.print("Enter Student ID to unenroll: ");
        String STUDENT_ID = scanner.nextLine();
        STUDENT STUDENT = FIND_ST_ID(STUDENT_ID);
        if (STUDENT == null) {
            System.out.println("Student with ID " + STUDENT_ID + " not found.");
            return;
        }
        STUDENTS.remove(STUDENT);
        System.out.println("Student " + STUDENT_ID + " unenrolled.");
    }

    private static void REM_INSTRUCTOR() {
        scanner.nextLine();
        System.out.print("\nEnter Instructor ID to remove: ");
        String INSTRUCTOR_ID = scanner.nextLine();
        INSTRUCTOR INSTRUCTOR = FIND_INS_ID(INSTRUCTOR_ID);
        if (INSTRUCTOR == null) {
            System.out.println("Instructor with ID " + INSTRUCTOR_ID + " not found.");
            return;
        }
        INSTRUCTORS.remove(INSTRUCTOR);
        System.out.println("Instructor " + INSTRUCTOR_ID + " removed.");
    }

    private static void REM_SUBJECT() {
        scanner.nextLine();
        System.out.print("\nEnter Subject Code to remove: ");
        String SUBJECT_ID = scanner.nextLine();
        SUBJECT SUBJECT = FIND_SUB_ID(SUBJECT_ID);
        if (SUBJECT == null) {
            System.out.println("Subject with Code " + SUBJECT_ID + " not found.");
            return;
        }
        SUBJECTS.remove(SUBJECT);
        System.out.println("SUBJECT " + SUBJECT_ID + " removed.");
    }

    private static void EDIT_INSTRUCTOR_DETAILS() {
        scanner.nextLine();
        System.out.print("Enter Instructor ID to edit details: ");
        String INSTRUCTOR_ID = scanner.nextLine();
        INSTRUCTOR INSTRUCTOR = FIND_INS_ID(INSTRUCTOR_ID);
        if (INSTRUCTOR == null) {
            System.out.println("Invalid Instructor ID.");
            return;
        }

        System.out.println("Enter new details for the instructor:");
        System.out.print("Last Name: ");
        String LAST_NAME = scanner.nextLine();
        INSTRUCTOR.SET_LASTNAME(LAST_NAME);
        System.out.print("First Name: ");
        String FIRST_NAME = scanner.nextLine();
        INSTRUCTOR.SET_FIRSTNAME(FIRST_NAME);
        System.out.print("Middle Name (optional): ");
        String MIDDLE_NAME = scanner.nextLine();
        INSTRUCTOR.SET_MIDDLENAME(MIDDLE_NAME);
        System.out.print("Address: ");
        String ADDRESS = scanner.nextLine();
        INSTRUCTOR.SET_ADDRESS(ADDRESS);
        System.out.print("Email Address: ");
        String EMAIL_ADDRESS = scanner.nextLine();
        INSTRUCTOR.SET_EMAILADD(EMAIL_ADDRESS);
        System.out.print("Contact Number: ");
        String CONTACT_NUMBER = scanner.nextLine();
        INSTRUCTOR.SET_CONTACTNUM(CONTACT_NUMBER);

        System.out.println("Instructor details updated successfully.");
    }
    private static void EDIT_STUDENT_DETAILS() {
        scanner.nextLine();
        System.out.print("Enter Student ID to edit details: ");
        String STUDENT_ID = scanner.nextLine();
        STUDENT STUDENT = FIND_ST_ID(STUDENT_ID);
        if (STUDENT == null) {
            System.out.println("Invalid Student ID.");
            return;
        }
    
        System.out.println("Enter new details for the Student:");
        System.out.print("Last Name: ");
        String LAST_NAME = scanner.nextLine();
        STUDENT.SET_LASTNAME(LAST_NAME);
        System.out.print("First Name: ");
        String FIRST_NAME = scanner.nextLine();
        STUDENT.SET_FIRSTNAME(FIRST_NAME);
        System.out.print("Middle Name (optional): ");
        String MIDDLE_NAME = scanner.nextLine();
        STUDENT.SET_MIDDLENAME(MIDDLE_NAME);
        System.out.print("Address: ");
        String ADDRESS = scanner.nextLine();
        STUDENT.SET_ADDRESS(ADDRESS);
        System.out.print("Email Address: ");
        String EMAIL_ADDRESS = scanner.nextLine();
        STUDENT.SET_EMAILADD(EMAIL_ADDRESS);
        System.out.print("Contact Number: ");
        String CONTACT_NUMBER = scanner.nextLine();
        STUDENT.SET_CONTACTNUM(CONTACT_NUMBER);
    
        System.out.println("Student details updated successfully.");
    }
}    

