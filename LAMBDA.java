// LAMBDA.java

import java.util.*;

public class LAMBDA {
    private static Scanner scanner = new Scanner(System.in);
    private static List<INSTRUCTOR> instructors = new ArrayList<>();
    private static List<STUDENT> students = new ArrayList<>();
    private static List<SUBJECT> SUBJECTS = new ArrayList<>();
    private static final int MIN_INSTRUCTOR_AGE = 24;
    private static final int MIN_STUDENT_AGE = 17;

    public static void main(String[] args) {
        SHOW_SPL();
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
        String splashText = "Welcome to University Management Profiling System!";
        int padding = (80 - splashText.length()) / 2;
        System.out.println("\n" + "=".repeat(padding) + splashText + "=".repeat(padding));
    }

    private static void SHOW_MENU() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("No.    | Option");
        System.out.println("------+------------------------------------------------------");
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
        System.out.print("Enter last name: ");
        String LAST_NAME = scanner.next();
        System.out.print("Enter first name: ");
        String FIRST_NAME = scanner.next();
        System.out.print("Enter middle name (optional): ");
        String MIDDLE_NAME = scanner.next();
        System.out.print("Enter ADDRESS: ");
        String ADDRESS = scanner.next();
        int AGE;
        do {
            System.out.print("Enter AGE (>= " + MIN_INSTRUCTOR_AGE + "): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid AGE! Please enter a valid AGE.");
                scanner.next();
            }
            AGE = scanner.nextInt();
        } while (AGE < MIN_INSTRUCTOR_AGE);

        String ID = GENERATE_INS_ID(AGE);
        INSTRUCTOR INSTRUCTOR = new INSTRUCTOR(ID, LAST_NAME, FIRST_NAME, MIDDLE_NAME, ADDRESS, AGE);
        instructors.add(INSTRUCTOR);
        System.out.println("INSTRUCTOR added successfully. Details: \n" + INSTRUCTOR);
    }

    private static String GENERATE_INS_ID(int AGE) {
        Random rand = new Random();
        return "INS" + AGE + "-" + (rand.nextInt(9000) + 1000);
    }

    private static void ADD_STUDENT() {
        System.out.print("Enter last name: ");
        String LAST_NAME = scanner.next();
        System.out.print("Enter first name: ");
        String FIRST_NAME = scanner.next();
        System.out.print("Enter middle name (optional): ");
        String MIDDLE_NAME = scanner.next();
        System.out.print("Enter ADDRESS: ");
        String ADDRESS = scanner.next();
        int AGE;
        do {
            System.out.print("Enter AGE (>= " + MIN_STUDENT_AGE + "): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid AGE! Please enter a valid AGE.");
                scanner.next();
            }
            AGE = scanner.nextInt();
        } while (AGE < MIN_STUDENT_AGE);

        String ID = GENERATE_ST_ID(AGE);
        STUDENT STUDENT = new STUDENT(ID, LAST_NAME, FIRST_NAME, MIDDLE_NAME, ADDRESS, AGE);
        students.add(STUDENT);
        System.out.println("STUDENT added successfully. Details: \n" + STUDENT);
    }

    private static String GENERATE_ST_ID(int AGE) {
        Random rand = new Random();
        return "ST" + AGE + "-" + (rand.nextInt(9000) + 1000);
    }

    private static void ADD_SUBJECT() {
        System.out.print("Enter SUBJECT TITLE: ");
        String TITLE = scanner.next();
        System.out.print("Enter SUBJECT DESC: ");
        String DESC = scanner.next();

        SUBJECT SUBJECT = new SUBJECT(TITLE, DESC);
        SUBJECTS.add(SUBJECT);
        System.out.println("SUBJECT added successfully with Details: \n" + SUBJECT);
    }

    private static void ASSIGN_SUB_TO_INS() {
        System.out.print("Enter INSTRUCTOR ID: ");
        String INSTRUCTOR_ID = scanner.next();
        INSTRUCTOR INSTRUCTOR = FIND_INS_ID(INSTRUCTOR_ID);
        if (INSTRUCTOR == null) {
            System.out.println("Invalid INSTRUCTOR ID.");
            return;
        }

        System.out.print("Enter SUBJECT CODE: ");
        String SUBJECT_ID = scanner.next();
        SUBJECT SUBJECT = FIND_SUB_ID(SUBJECT_ID);
        if (SUBJECT == null) {
            System.out.println("Invalid SUBJECT CODE.");
            return;
        }

        INSTRUCTOR.ADD_SUBJECT(SUBJECT);
        System.out.println("SUBJECT assigned to INSTRUCTOR successfully.");
    }

    private static void ADD_SUB_TO_ST() {
        System.out.print("Enter STUDENT ID: ");
        String STUDENT_ID = scanner.next();
        STUDENT STUDENT = FIND_ST_ID(STUDENT_ID);
        if (STUDENT == null) {
            System.out.println("Invalid STUDENT ID.");
            return;
        }

        System.out.print("Enter SUBJECT CODE: ");
        String SUBJECT_ID = scanner.next();
        SUBJECT SUBJECT = FIND_SUB_ID(SUBJECT_ID);
        if (SUBJECT == null) {
            System.out.println("Invalid SUBJECT CODE.");
            return;
        }

        STUDENT.ADD_SUBJECT(SUBJECT);
        System.out.println("SUBJECT added to STUDENT successfully.");
    }

    private static void SHOW_ST_INFO() {
        System.out.print("Enter STUDENT ID: ");
        String STUDENT_ID = scanner.next();
        STUDENT STUDENT = FIND_ST_ID(STUDENT_ID);
        if (STUDENT == null) {
            System.out.println("Invalid STUDENT ID.");
            return;
        }

        System.out.println(STUDENT);
        List<SUBJECT> studentSubjects = STUDENT.GET_SUBS();
        if (studentSubjects.isEmpty()) {
            System.out.println("No SUBJECTS assigned to this STUDENT.");
        } else {
            System.out.println("SUBJECTS Assigned:");
            for (SUBJECT SUBJECT : studentSubjects) {
                System.out.println("- " + SUBJECT);
            }
        }
    }

    private static void SHOW_INS_INFO() {
        System.out.print("Enter INSTRUCTOR ID: ");
        String INSTRUCTOR_ID = scanner.next();
        INSTRUCTOR INSTRUCTOR = FIND_INS_ID(INSTRUCTOR_ID);
        if (INSTRUCTOR == null) {
            System.out.println("Invalid INSTRUCTOR ID.");
            return;
        }

        System.out.println(INSTRUCTOR);
        List<SUBJECT> instructorSubjects = INSTRUCTOR.GET_SUBS();
        if (instructorSubjects.isEmpty()) {
            System.out.println("No SUBJECTS assigned to this INSTRUCTOR.");
        } else {
            System.out.println("SUBJECTS Handled:");
            for (SUBJECT SUBJECT : instructorSubjects) {
                System.out.println("- " + SUBJECT);
            }
        }
    }

    private static INSTRUCTOR FIND_INS_ID(String ID) {
        for (INSTRUCTOR INSTRUCTOR : instructors) {
            if (INSTRUCTOR.getId().equals(ID)) {
                return INSTRUCTOR;
            }
        }
        return null;
    }

    private static STUDENT FIND_ST_ID(String ID) {
        for (STUDENT STUDENT : students) {
            if (STUDENT.getId().equals(ID)) {
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
