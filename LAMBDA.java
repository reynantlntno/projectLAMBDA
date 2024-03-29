/* 
   Fuertez, Balce Vince, Quila
   BSIS 1A
   IS 102 Computer Programming 2
   IS 103 Data Structures and Algorithms
*/

// LAMBDA.java
// put notes here (bug notes o kahit ano)


import java.util.*;

public class LAMBDA {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Instructor> instructors = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();
    private static List<Subject> subjects = new ArrayList<>();
    private static final int MIN_INSTRUCTOR_AGE = 24;
    private static final int MAX_INSTRUCTOR_AGE = 70;
    private static final int MIN_STUDENT_AGE = 17;
    private static final int MAX_STUDENT_AGE = 70;
    private static String username;

    public static void main(String[] args) {
        showSplash(); // Display the LAMBDA splash screen
        username = promptLogin(); // Prompt for username
        lambdaCaptcha(); // simple math CAPTCHA
        headerUmps(); // Display header
        while (true) {
            showMenu(); // Display  main menu
            String choice = getChoice(); // Get user choice
            switch (choice) {
                case "1":
                    addInstructor(); // Add new instructor
                    break;
                case "2":
                    addStudent(); // Add new student
                    break;
                case "3":
                    addSubject(); // Add new subject
                    break;
                case "4":
                    assignSubToIns(); // Assign subject to an instructor
                    break;
                case "5":
                    addSubToSt(); // Add subject to a student
                    break;
                case "6":
                    showStInfo(); // Display student info and subjects
                    break;
                case "7":
                    showInsInfo(); // Display instructor info and subjects
                    break;
                case "8":
                    editInstructorDetails(); // Edit instructor details
                    break;
                case "9":
                    editStudentDetails(); // Edit student details
                    break;
                case "10":
                    remStudent(); // Remove a student
                    break;
                case "11":
                    remInstructor(); // Remove an instructor
                    break;
                case "12":
                    remSubject(); // Remove a subject
                    break;
                case "CLEAR":
                    clearScreen(); // Clear the console screen
                    showSplash(); // Display the splash screen again
                    break;
                case "EXIT":
                    clearScreen(); // Clear the console screen
                    System.out.println("Exiting Lambda..."); // Exit the program
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Clear the console screen
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Display LAMBDA splash screen
    private static void showSplash() {
        double lambdaVers = 1.1;
        String lambdaStat = "ALPHA";
        String splashTxt = " LAMBDA " + lambdaVers + " ";
        System.out.print("\n[" + splashTxt +  "     UMPS     " + lambdaStat  + " ]\n");
    }

    // Prompt for username
    private static String promptLogin() {
        System.out.print("Please enter your username for record purposes: ");

        String username = scanner.nextLine();
        
        if (username.length() > 30) {
            System.out.println("Error: Username exceeds 30 characters.");
            return promptLogin();
        } else {
            return username;
        }
    }

    // a simple math CAPTCHA
    private static void lambdaCaptcha() {
        int attempts = 0;
        while (attempts < 2) {
            try {
                System.out.print("Please answer the question below: \n");
                System.out.print("\n -- 10 * 10 = ");
                int product = scanner.nextInt();
                if (product == 100) {
                    System.out.print("Correct Answer! \n");
                    clearScreen();
                    showSplash();
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

    // Display header
    private static void headerUmps() {
        System.out.print("Welcome to University Management Profiling System!");
    }

    // Display main menu
    private static void showMenu() {
        System.out.print("\nLogged in as: " + username);

        System.out.print("\n==============================================================\n");
        System.out.println("No     | Option");
        System.out.println("-------+------------------------------------------------------");
        System.out.println(" 1     | Add Instructor");
        System.out.println(" 2     | Add Student");
        System.out.println(" 3     | Add Subject");
        System.out.println(" 4     | Assign Subject to Instructor");
        System.out.println(" 5     | Add Subject to Student");
        System.out.println(" 6     | Display Student's Information and Subject Details");
        System.out.println(" 7     | Display Instructor's Details and Subjects Handled");
        System.out.println(" 8     | Edit Instructor Details");
        System.out.println(" 9     | Edit Student Details");
        System.out.println(" 10    | Unenroll a Student");
        System.out.println(" 11    | Remove an Instructor");
        System.out.println(" 12    | Remove a Subject");
        System.out.println(" CLEAR | Clear Screen");
        System.out.println(" EXIT  | Exit Lambda");
        System.out.print("==============================================================\n");
        System.out.print("Enter your choice: ");
    }

    // Get user choice
    private static String getChoice() {
        while (!scanner.hasNext()) {
            System.out.println("Invalid input! Please enter a number.");
            scanner.next();
        }
        clearScreen();
        return scanner.next();
    }

    private static void addInstructor() {
        System.out.print("\n==============================================================\n");
        System.out.println("Instructor Add: Please Correctly Type the Details!");
        System.out.print("==============================================================\n");

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
                
                if (age > MAX_INSTRUCTOR_AGE) {
                    System.out.println("Warning: Maximum allowable age is " + MAX_INSTRUCTOR_AGE + ".");
                }
                else if (age < MIN_INSTRUCTOR_AGE) {
                    System.out.println("Does not meet the minimum age requirement.");
                }
            } while (age < MIN_INSTRUCTOR_AGE || age > MAX_INSTRUCTOR_AGE);

            String id = generateInsId(year);
            Instructor instructor = new Instructor(id, lastName, firstName, middleName, address, emailAddress,
                    contactNumber, age, year);
            instructors.add(instructor);
            System.out.println("\nInstructor added successfully! \nHere are the details: \n" + "-----------------------------\n" + instructor);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter valid data.");
            scanner.nextLine();
            addInstructor();
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

    private static String generateInsId(int year) {
        Random rand = new Random();
        return "INS" + year + "-" + (rand.nextInt(9000) + 1000);
    }

    private static void addStudent() {
           System.out.print("\n==============================================================\n");
        System.out.println("Student Add: Please Correctly Type the Details!");
           System.out.print("==============================================================\n");

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
                if (age > MAX_STUDENT_AGE) {
                    System.out.println("Warning: Maximum allowable age is " + MAX_STUDENT_AGE + ".");
                }
                else if (age < MIN_STUDENT_AGE) {
                    System.out.println("Does not meet the minimum age requirement.");
                }
            } while (age < MIN_STUDENT_AGE || age > MAX_STUDENT_AGE);

            String id = generateStId(year);
            Student student = new Student(id, lastName, firstName, middleName, address, emailAddress,
                    contactNumber, age, year);
            students.add(student);
            System.out.println("\nStudent added successfully! \nHere are the details: \n" + "-----------------------------\n" + student);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Try again.");
            scanner.nextLine();
            addStudent();
        }
    }

    private static String generateStId(int year) {
        Random rand = new Random();
        return "ST" + year + "-" + (rand.nextInt(9000) + 1000);
    }

    private static void addSubject() {
        System.out.print("\n==============================================================\n");
        System.out.println("Subject Add: Please Correctly Type the Details!");
        System.out.print("==============================================================\n");
        scanner.nextLine();
        System.out.print("Enter Subject Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Subject Description: ");
        String desc = scanner.nextLine();
        Subject subject = new Subject(title, desc);
        subjects.add(subject);
        System.out.println("\nSubject added successfully!\nHere are the details: \n" + "-----------------------------\n" + subject);
    }

    private static void assignSubToIns() {
        scanner.nextLine();
        System.out.print("Enter Instructor ID: ");
        String instructorId = scanner.nextLine();
        Instructor instructor = findInsId(instructorId);
        if (instructor == null) {
            System.out.println("Invalid Instructor ID.");
            return;
        }

        System.out.print("Enter Subject Code: ");
        String subjectId = scanner.nextLine();
        Subject subject = findSubId(subjectId);
        if (subject == null) {
            System.out.println("Invalid Subject Code.");
            return;
        }

        instructor.addSubject(subject);
        System.out.println("Subject assigned to Instructor successfully.");

    }

    private static void addSubToSt() {
        scanner.nextLine();
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        Student student = findStId(studentId);
        if (student == null) {
            System.out.println("Invalid Student ID.");
            return;
        }

        System.out.print("Enter Subject Code: ");
        String subjectId = scanner.nextLine();
        Subject subject = findSubId(subjectId);
        if (subject == null) {
            System.out.println("Invalid Subject Code.");
            return;
        }

        student.addSubject(subject);
        System.out.println("Subject added to Student successfully.");
    }

    private static void showStInfo() {
        scanner.nextLine();
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        Student student = findStId(studentId);
        if (student == null) {
            System.out.println("Invalid Student ID.");
            return;
        }

        System.out.println(student);
        List<Subject> studentSubjects = student.getSubjects();
        if (studentSubjects.isEmpty()) {
            System.out.println("No Subjects assigned to this Student.");
        } else {
            System.out.println("Subjects Assigned:");
            for (Subject subject : studentSubjects) {
                System.out.println("- " + subject);
            }
        }
    }

    private static void showInsInfo() {
        scanner.nextLine();
        System.out.print("Enter Instructor ID: ");
        String instructorId = scanner.nextLine();
        Instructor instructor = findInsId(instructorId);
        if (instructor == null) {
            System.out.println("Invalid Instructor ID.");
            return;
        }

        System.out.println(instructor);
        List<Subject> instructorSubs = instructor.getSubjects();
        if (instructorSubs.isEmpty()) {
            System.out.println("No Subjects assigned to this Instructor.");
        } else {
            System.out.println("Subjects Handled:");
            for (Subject subject : instructorSubs) {
                System.out.println("- " + subject);
            }
        }
    }

    private static Instructor findInsId(String id) {
        for (Instructor instructor : instructors) {
            if (instructor.getId().equals(id)) {
                return instructor;
            }
        }
        return null;
    }

    private static Student findStId(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    private static Subject findSubId(String code) {
        for (Subject subject : subjects) {
            if (subject.getCode().equals(code)) {
                return subject;
            }
        }
        return null;
    }

    private static void remStudent() {
        scanner.nextLine();
        System.out.print("Enter Student ID to unenroll: ");
        String studentId = scanner.nextLine();
        Student student = findStId(studentId);
        if (student == null) {
            System.out.println("Student with ID " + studentId + " not found.");
            return;
        }
        students.remove(student);
        System.out.println("Student " + studentId + " unenrolled.");
    }

    private static void remInstructor() {
        scanner.nextLine();
        System.out.print("\nEnter Instructor ID to remove: ");
        String instructorId = scanner.nextLine();
        Instructor instructor = findInsId(instructorId);
        if (instructor == null) {
            System.out.println("Instructor with ID " + instructorId + " not found.");
            return;
        }
        instructors.remove(instructor);
        System.out.println("Instructor " + instructorId + " removed.");
    }

    private static void remSubject() {
        scanner.nextLine();
        System.out.print("\nEnter Subject Code to remove: ");
        String subjectId = scanner.nextLine();
        Subject subject = findSubId(subjectId);
        if (subject == null) {
            System.out.println("Subject with Code " + subjectId + " not found.");
            return;
        }
        subjects.remove(subject);
        System.out.println("Subject " + subjectId + " removed.");
    }

    private static void editInstructorDetails() {
        scanner.nextLine();
        System.out.print("Enter Instructor ID to edit: ");
        String instructorId = scanner.nextLine();
        Instructor instructor = findInsId(instructorId);
        if (instructor == null) {
            System.out.println("Instructor with ID " + instructorId + " not found.");
            return;
        }
    
        System.out.println("Choose which attribute to edit:");
        System.out.println("1     | Last Name");
        System.out.println("2     | First Name");
        System.out.println("3     | Middle Name");
        System.out.println("4     | Address");
        System.out.println("5     | Email Address");
        System.out.println("6     | Contact Number");
        System.out.println("7     | Age");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
    
        switch (choice) {
            case 1:
                // Edit last name
                System.out.print("Enter new last name: ");
                String newLastName = scanner.nextLine().trim();
                instructor.setLastName(newLastName);
                break;
            case 2:
                // Edit first name
                System.out.print("Enter new first name: ");
                String newFirstName = scanner.nextLine().trim();
                instructor.setFirstName(newFirstName);
                break;
            case 3:
                // Edit middle name
                System.out.print("Enter new middle name: ");
                String newMiddleName = scanner.nextLine().trim();
                instructor.setMiddleName(newMiddleName);
                break;
            case 4:
                // Edit address
                System.out.print("Enter new address: ");
                String newAddress = scanner.nextLine().trim();
                instructor.setAddress(newAddress);
                break;
            case 5:
                System.out.print("Enter new email address: ");
                String newEmailAddress = scanner.nextLine().trim();
                instructor.setEmailAddress(newEmailAddress);
                break;
            case 6:
                System.out.print("Enter new contact number: ");
                String newContactNumber = scanner.nextLine().trim();
                instructor.setContactNumber(newContactNumber);
                break;
            case 7:
                // Edit age
                int newAge;
                do {
                    System.out.print("Enter new age (>= " + MIN_INSTRUCTOR_AGE + "): ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid Age! Please enter a valid Age.");
                        scanner.nextLine();
                    }
                    newAge = scanner.nextInt();
                    if (newAge > MAX_INSTRUCTOR_AGE) {
                        System.out.println("Warning: Maximum allowable age is " + MAX_INSTRUCTOR_AGE + ".");
                    } else if (newAge < MIN_INSTRUCTOR_AGE) {
                        System.out.println("Does not meet the minimum age requirement.");
                    }
                } while (newAge < MIN_INSTRUCTOR_AGE || newAge > MAX_INSTRUCTOR_AGE);
                instructor.setAge(newAge);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }
    
        System.out.println("Instructor details updated successfully.");
    }
    
    private static void editStudentDetails() {
        scanner.nextLine();
        System.out.print("Enter Student ID to edit: ");
        String studentId = scanner.nextLine();
        Student student = findStId(studentId);
        if (student == null) {
            System.out.println("Student with ID " + studentId + " not found.");
            return;
        }
    
        System.out.println("Choose which attribute to edit:");
        System.out.println("1     | Last Name");
        System.out.println("2     | First Name");
        System.out.println("3     | Middle Name");
        System.out.println("4     | Address");
        System.out.println("5     | Email Address");
        System.out.println("6     | Contact Number");
        System.out.println("7     | Age");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
    
        switch (choice) {
            case 1:
                // Edit last name
                System.out.print("Enter new last name: ");
                String newLastName = scanner.nextLine().trim();
                student.setLastName(newLastName);
                break;
            case 2:
                // Edit first name
                System.out.print("Enter new first name: ");
                String newFirstName = scanner.nextLine().trim();
                student.setFirstName(newFirstName);
                break;
            case 3:
                // Edit middle name
                System.out.print("Enter new middle name: ");
                String newMiddleName = scanner.nextLine().trim();
                student.setMiddleName(newMiddleName);
                break;
            case 4:
                // Edit address
                System.out.print("Enter new address: ");
                String newAddress = scanner.nextLine().trim();
                student.setAddress(newAddress);
                break;
            case 5:
                System.out.print("Enter new email address: ");
                String newEmailAddress = scanner.nextLine().trim();
                student.setEmailAddress(newEmailAddress);
                break;
            case 6:
                System.out.print("Enter new contact number: ");
                String newContactNumber = scanner.nextLine().trim();
                student.setContactNumber(newContactNumber);
                break;
            case 7:
                // Edit age
                int newAge;
                do {
                    System.out.print("Enter new age (>= " + MIN_STUDENT_AGE + "): ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid Age! Please enter a valid Age.");
                        scanner.nextLine();
                    }
                    newAge = scanner.nextInt();
                    if (newAge > MAX_STUDENT_AGE) {
                        System.out.println("Warning: Maximum allowable age is " + MAX_STUDENT_AGE + ".");
                    } else if (newAge < MIN_STUDENT_AGE) {
                        System.out.println("Does not meet the minimum age requirement.");
                    }
                } while (newAge < MIN_STUDENT_AGE || newAge > MAX_STUDENT_AGE);
                student.setAge(newAge);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }
    
        System.out.println("Student details updated successfully.");
    }
}    