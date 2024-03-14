package LAMBDA_ONEFILE;

// LAMBDA.java

// put notes here
// 

import java.util.*;

// Entity.java

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

    static class INSTRUCTOR extends Entity {
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

   static class STUDENT extends Entity {
            private List<SUBJECT> SUBJECTS;
        
            public STUDENT(String ID, String LAST_NAME, String FIRST_NAME, String MIDDLE_NAME, String ADDRESS, String EMAIL_ADDRESS, String CONTACT_NUMBER, int AGE, int YEAR) {
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
                return "STUDENT: \n" + super.toString();
            }

        }

        static class SUBJECT {
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
                    REM_STUDENT();
                    break;
                case 9:
                    REM_INSTRUCTOR();
                    break;
                case 10:
                    System.out.println("hindi pa ready");
                    break;
                case 11:
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
        String SPLASH_TXT = " LAMBDA " + LAMBDA_VERS + " ";
        int padding = (60 - SPLASH_TXT.length()) / 2;
        System.out.println("\n" + "=".repeat(padding) + SPLASH_TXT + "=".repeat(padding));
    }

    private static void PROMPT_LOGIN() {
        System.out.print("Please enter your username for record purposes: ");
        String USERNAME = scanner.next();
        System.out.print("Hello " + USERNAME + "! Please answer the question below: \n");

    }

    private static void LAMBDA_CAPTCHA() {
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
                LAMBDA_CAPTCHA();
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Try again.");
            scanner.nextLine(); 
            LAMBDA_CAPTCHA();
        }
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
        System.out.println(" 8    | Unenroll a STUDENT");
        System.out.println(" 9    | Remove a INSTRUCTOR");
        System.out.println(" 10   | Remove a SUBJECT (Not yet ready hahaha)");
        System.out.println(" 11   | Exit LAMBDA");  
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

        try {
        System.out.print("Enter last name: ");
        String LAST_NAME = scanner.next();
        System.out.print("Enter first name: ");
        String FIRST_NAME = scanner.next();
        System.out.print("Enter middle name (optional): ");
        String MIDDLE_NAME = scanner.next();
        System.out.print("Enter Address: ");
        String ADDRESS = scanner.next();
        System.out.print("Enter Email Address: ");
        String EMAIL_ADDRESS = scanner.next();
        System.out.print("Enter Contact Number: ");
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

        } catch (InputMismatchException e) {
        System.out.println("Invalid input! Try again.");
        scanner.next(); 
        ADD_INSTRUCTOR(); 
        }
    }

    private static String GENERATE_INS_ID(int YEAR) {
        Random rand = new Random();
        return "INS" + YEAR + "-" + (rand.nextInt(9000) + 1000);
    }

    private static void ADD_STUDENT() {
        System.out.println("-".repeat(60));
        System.out.println("STUDENT ADD: PLEASE CORRECTLY TYPE THE DETAILS!");
        System.out.println("-".repeat(60));
    
        try {
            System.out.print("Enter last name: ");
            String LAST_NAME = scanner.next();
            System.out.print("Enter first name: ");
            String FIRST_NAME = scanner.next();
            System.out.print("Enter middle name (optional): ");
            String MIDDLE_NAME = scanner.next();
            System.out.print("Enter Address: ");
            String ADDRESS = scanner.next();
            System.out.print("Enter Email Address: ");
            String EMAIL_ADDRESS = scanner.next();
            System.out.print("Enter Contact Number: ");
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
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Try again.");
            scanner.next(); 
            ADD_STUDENT(); 
        }
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
            if (SUBJECT.GET_CODE().equals(CODE)) {
                return SUBJECT;
            }
        }
        return null;
    }

    private static void REM_STUDENT() {
        System.out.print(" ");
        scanner.nextLine();
        System.out.print("Enter Student ID to unenroll: ");
        String STUDENT_ID = scanner.nextLine();
        STUDENT STUDENT = FIND_ST_ID(STUDENT_ID);
        if (STUDENT == null) {
            System.out.println("Student with ID " + STUDENT_ID + " not found.");
            return;
        }
        STUDENTS.remove(STUDENT);
        System.out.println("Student " + STUDENT_ID + "unenrolled.");
    }

    private static void REM_INSTRUCTOR() {
        System.out.print(" ");
        scanner.nextLine();
        System.out.print("\nEnter Instructor ID to remove: ");
        String INSTRUCTOR_ID = scanner.nextLine();
        INSTRUCTOR INSTRUCTOR = FIND_INS_ID(INSTRUCTOR_ID);
        if (INSTRUCTOR == null) {
        System.out.println("Instructor with ID " + INSTRUCTOR_ID + " not found.");
            return;

        }
        INSTRUCTORS.remove(INSTRUCTOR);
            System.out.println("Student " + INSTRUCTOR_ID + "unenrolled.");
    }

}
    }
}

