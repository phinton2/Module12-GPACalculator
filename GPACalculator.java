// PART A
import java.util.Scanner;
import java.util.*;

public class GPACalculator {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        char letterGrade;    // User defined letter grade 
        int creditHours;     // User defined number of credit hours
        char quitCmd;        // Indicates quit/continue

        quitCmd = 'a';

        int qualityPoints = 0;
        int totalCreditHrs = 0;

        // PART B
        /*
        while (quitCmd != 'q') {

            // Get user data
            System.out.print("Enter letter grade: ");
            letterGrade = scnr.nextLine().charAt(0);
            // Error checking, unknown letter grade
            if (getLetterGradeValue(letterGrade) == -1) {
                System.out.println("Invalid letter grade. Try again!");
            } else { // if valid letter grade
                System.out.print("Enter number of credit hours: ");
                creditHours = scnr.nextInt();
                // Error checking negative credit hours
                if (creditHours < 0) { // if invalid credit hours
                    System.out.println("Invalid number of credit hours. Try again!");
                } else {
                    totalCreditHrs += creditHours;
                }
                qualityPoints += getLetterGradeValue(letterGrade) * creditHours;
                System.out.print("\nEnter any key to continue entering grade or 'q' to quit: ");
                quitCmd = scnr.next().charAt(0);
                scnr.nextLine();
            }
        }*/

        // PART C
        do {
            try {
                // Get user data
                System.out.print("Enter letter grade: ");
                letterGrade = scnr.nextLine().charAt(0);
                // Error checking, unknown letter grade
                if (getLetterGradeValue(letterGrade) == -1) {
                    throw new Exception("Invalid letter grade.");
                }
                System.out.print("Enter number of credit hours: ");
                creditHours = scnr.nextInt();
                // Error checking, negative credit hours
                if (creditHours < 0) {
                    throw new Exception("Invalid number of credit hours. Try again!");
                }
                totalCreditHrs += creditHours;

                qualityPoints += getLetterGradeValue(letterGrade) * creditHours;
            } 
            // PART D
            catch (InputMismatchException excpt) {
                // Prints the error message passed by throw statement
                scnr.nextLine(); // consume the new line from the last nextInt call
                System.out.println("Invalid type entered. Please try again!");
            }
            catch (Exception excpt) {
                // Prints the error message passing throw statment
                System.out.println(excpt.getMessage());
                System.out.println("Cannot computer GPA");
            } 
            System.out.print("\nEnter any key to continue entering grade or 'q' to quit: ");
            quitCmd = scnr.next().charAt(0);
            scnr.nextLine();
        } while (quitCmd != 'q');

        // PART E
        do {
            // calculate GPA - Divide the total quality points by the total credit hours
            try {
                double gpa = computeIntGPA(qualityPoints, totalCreditHrs);
                // Print user GPA info
                System.out.println("GPA: " + gpa);
            } catch (ArithmeticException excpt) {
                System.out.println(excpt.getMessage());
                System.out.println("Illegal operation. Cannot compute GPA");
                double gpa = 0;
                System.out.println("GPA: " + gpa);
            }
            if (quitCmd == 'q') {
                quitCmd = 'c';
            }
        } while (quitCmd == 'q');
    }

    private static int getLetterGradeValue(char letterGrade) {
        if (letterGrade == 'a' || letterGrade == 'A') {
            return 4;
        }
        if (letterGrade == 'b' || letterGrade == 'B') {
            return 3;
        }
        if (letterGrade == 'c' || letterGrade == 'C') {
            return 2;
        }
        if (letterGrade == 'd' || letterGrade == 'D') {
            return 1;
        } 
        if (letterGrade == 'f' || letterGrade == 'F') {
            return 0;
        } else {
            return -1;
        }
    }

    // PART E
    private static int computeIntGPA(int qualityPoints, int ceditHours) {
        return qualityPoints / ceditHours;
    }

    private static double computeGPA(int qualityPoints, int ceditHours) {
        return ((double) qualityPoints) / ceditHours;
    }
}
