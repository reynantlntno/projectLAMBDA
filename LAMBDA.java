// LAMBDA.java

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
        while (true) {
            SHOW_MENU();
            int choice = GET_CHOICE();
            switch (choice) {
                case 1:
                    ADD_INSTRUCTOR();
                    break;
                case 2:
                    ADD_STUDENT();
                    break;
                case 3:
                    ADD_SUBJECT();
                    break;
                case 4:
                    ASSIGN_SUB_TO_INS();
                    break;
                case 5:
                    ADD_SUB_TO_ST();
                    break;
                case 6:
                    SHOW_ST_INFO();
                    break;
                case 7:
                    SHOW_INS_INFO();
                    break;
                case 8:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void SHOW_SPL() {
        double LAMBDA_VERS = 1.0;
        String SPLASH_TXT = " LAMBDA " + LAMBDA_VERS + " ";
        int padding = (60 - SPLASH_TXT.length()) / 2;
        System.out.println("\n" + "=".repeat(padding) + SPLASH_TXT + "=".repeat(padding));
    }

    private static void PROMPT_LOGIN() {
        System.out.print("Please enter your username for record purposes: ");
        String USERNAME = scanner.next();
        System.out.print("Hello " + USERNAME + "!");

    }

    private static void SHOW_MENU() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("No    | Option");
        System.out.println("------+-----------------------------------------------------");
        System.out.println(" 1    | Add INSTRUCTOR");
        System.out.println(" 2    | Add STUDENT");
        System.out.println(" 3    | Add SUBJECT");
        System.out.println(" 4    | Assign SUBJECT to INSTRUCTOR");
        System.out.println(" 5    | Add SUBJECT to STUDENT");
        System.out.println(" 6    | Display STUDENT's Information and SUBJECT Details");
        System.out.println(" 7    | Display INSTRUCTOR's Details and SUBJECTS Handled");
        System.out.println(" 8    | Exit");
        System.out.println("=".repeat(60));
        System.out.print("Enter your choice: ");
    }

    private static int GET_CHOICE() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void ADD_INSTRUCTOR() {
        System.out.println("-".repeat(60));
        System.out.println("INSTRUCTOR ADD: PLEASE CORRECTLY TYPE THE DETAILS!");
        System.out.println("-".repeat(60));
        System.out.print("Enter last name: ");
        String LAST_NAME = scanner.next();
        System.out.print("Enter first name: ");
        String FIRST_NAME = scanner.next();
        System.out.print("Enter middle name (optional): ");
        String MIDDLE_NAME = scanner.next();
        System.out.print("Enter Address ");
        String ADDRESS = scanner.next();
        System.out.print("Enter Email Address ");
        String EMAIL_ADDRESS = scanner.next();
        System.out.print("Enter Contact Number ");
        String CONTACT_NUMBER = scanner.next();
        System.out.print("Enter Start Year: 20");
        int YEAR = scanner.nextInt();
        int AGE;
        do {
            System.out.print("Enter Age (>= " + MIN_INSTRUCTOR_AGE + "): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid Age! Please enter a valid Age.");
                scanner.next();
            }
            AGE = scanner.nextInt();
        } while (AGE < MIN_INSTRUCTOR_AGE);
        

        String ID = GENERATE_INS_ID(YEAR);
        INSTRUCTOR INSTRUCTOR = new INSTRUCTOR(ID, LAST_NAME, FIRST_NAME, MIDDLE_NAME, ADDRESS, EMAIL_ADDRESS, CONTACT_NUMBER, AGE, YEAR);
        INSTRUCTORS.add(INSTRUCTOR);
        System.out.println("INSTRUCTOR added successfully. Details: \n" + INSTRUCTOR);
    }

    private static String GENERATE_INS_ID(int YEAR) {
        Random rand = new Random();
        return "INS" + YEAR + "-" + (rand.nextInt(9000) + 1000);
    }

    private static void ADD_STUDENT() {
        System.out.println("-".repeat(60));
        System.out.println("STUDENT ADD: PLEASE CORRECTLY TYPE THE DETAILS!");
        System.out.println("-".repeat(60));
        System.out.print("Enter last name: ");
        String LAST_NAME = scanner.next();
        System.out.print("Enter first name: ");
        String FIRST_NAME = scanner.next();
        System.out.print("Enter middle name (optional): ");
        String MIDDLE_NAME = scanner.next();
        System.out.print("Enter Address: ");
        String ADDRESS = scanner.next();
        System.out.print("Enter Email Address ");
        String EMAIL_ADDRESS = scanner.next();
        System.out.print("Enter Contact Number ");
        String CONTACT_NUMBER = scanner.next();
        System.out.print("Enter Start Year: 20");
        int YEAR = scanner.nextInt();
        int AGE;
        do {
            System.out.print("Enter Age (>= " + MIN_STUDENT_AGE + "): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid Age! Please enter a valid Age.");
                scanner.next();
            }
            AGE = scanner.nextInt();
        } while (AGE < MIN_STUDENT_AGE);

        String ID = GENERATE_ST_ID(YEAR);
        STUDENT STUDENT = new STUDENT(ID, LAST_NAME, FIRST_NAME, MIDDLE_NAME, ADDRESS, EMAIL_ADDRESS, CONTACT_NUMBER, AGE, YEAR);
        STUDENTS.add(STUDENT);
        System.out.println("Student added successfully. Details: \n" + STUDENT);
    }

    private static String GENERATE_ST_ID(int YEAR) {
        Random rand = new Random();
        return "ST" + YEAR + "-" + (rand.nextInt(9000) + 1000);
    }

    private static void ADD_SUBJECT() {
        System.out.println("-".repeat(60));
        System.out.println("SUBJECT ADD: PLEASE CORRECTLY TYPE THE DETAILS!");
        System.out.println("-".repeat(60));
        System.out.print("Enter Subject Title: ");
        String TITLE = scanner.next();
        System.out.print("Enter Subject Description: ");
        String DESC = scanner.next();

        SUBJECT SUBJECT = new SUBJECT(TITLE, DESC);
        SUBJECTS.add(SUBJECT);
        System.out.println("Subject added successfully with Details: \n" + SUBJECT);
    }

    private static void ASSIGN_SUB_TO_INS() {
        System.out.print("Enter Instructor ID: ");
        String INSTRUCTOR_ID = scanner.next();
        INSTRUCTOR INSTRUCTOR = FIND_INS_ID(INSTRUCTOR_ID);
        if (INSTRUCTOR == null) {
            System.out.println("Invalid Instructor ID.");
            return;
        }

        System.out.print("Enter Subject Code: ");
        String SUBJECT_ID = scanner.next();
        SUBJECT SUBJECT = FIND_SUB_ID(SUBJECT_ID);
        if (SUBJECT == null) {
            System.out.println("Invalid Subject Code.");
            return;
        }

        INSTRUCTOR.ADD_SUBJECT(SUBJECT);
        System.out.println("Subject assigned to Instructor successfully.");
    }

    private static void ADD_SUB_TO_ST() {
        System.out.print("Enter Student ID: ");
        String STUDENT_ID = scanner.next();
        STUDENT STUDENT = FIND_ST_ID(STUDENT_ID);
        if (STUDENT == null) {
            System.out.println("Invalid Student ID.");
            return;
        }

        System.out.print("Enter Subject Code: ");
        String SUBJECT_ID = scanner.next();
        SUBJECT SUBJECT = FIND_SUB_ID(SUBJECT_ID);
        if (SUBJECT == null) {
            System.out.println("Invalid Subject Code.");
            return;
        }

        STUDENT.ADD_SUBJECT(SUBJECT);
        System.out.println("Subject added to Student successfully.");
    }

    private static void SHOW_ST_INFO() {
        System.out.print("Enter Student ID: ");
        String STUDENT_ID = scanner.next();
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
        System.out.print("Enter Instructor ID: ");
        String INSTRUCTOR_ID = scanner.next();
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
            if (SUBJECT.getCode().equals(CODE)) {
                return SUBJECT;
            }
        }
        return null;
    }
}
