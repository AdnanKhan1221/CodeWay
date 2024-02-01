package code;
import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter marks obtained (out of 100) in each subject:");
        System.out.print("Number of subjects: ");
        int subjectCount = scanner.nextInt();
        int totalMarks = 0;

        for (int i = 1; i <= subjectCount; i++) {
            System.out.printf("Subject %d: ", i);
            int subjectMark = scanner.nextInt();
            totalMarks += subjectMark;
        }

        double averagePercentage = (double) totalMarks / (subjectCount * 100) * 100;
        String grade;

        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else {
            grade = "E";
        }

        System.out.printf("\nTotal marks: %d\n", totalMarks);
        System.out.printf("Average percentage: %.2f%%\n", averagePercentage);
        System.out.printf("Grade: %s\n", grade);

        scanner.close();
    }
}
