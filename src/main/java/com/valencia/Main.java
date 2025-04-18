package com.valencia;

import java.util.Random;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger("GRADES");
    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();

        logger.info("Application started");

        int numSubjects = main.getNumberOfAssignments(scanner);
        double total = main.calculateTotalScore(scanner, numSubjects);
        double average = main.calculateAverage(total, numSubjects);
        char grade = main.determineGrade(average);

        main.displayResults(total, average, grade);

        logger.info("Application finished");
        scanner.close();
    }

    public int getNumberOfAssignments(Scanner scanner) {
        System.out.print("Enter the number of assignments: ");

        if (scanner.hasNextInt()) {
            int numSubjects = scanner.nextInt();
            logger.info("Number of assignments: {}", numSubjects);
            return numSubjects;
        } else {
            logger.error("No valid input received.");
            return 0;
        }
    }

    public double calculateTotalScore(Scanner scanner, int numSubjects) {
        double total = 0;
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter score for assignment " + i + ": ");
            total += scanner.nextDouble();
        }
        return total;
    }

    public double calculateAverage(double total, int numSubjects) {
        return (numSubjects > 0) ? total / numSubjects : 0;
    }

    public char determineGrade(double average) {
        if (average >= 90) return 'A';
        if (average >= 80) return 'B';
        if (average >= 70) return 'C';
        if (average >= 60) return 'D';
        return 'F';
    }

    public void displayResults(double total, double average, char grade) {
        logger.info("Total score: {}", total);
        logger.info("Average score: {}", average);
        logger.info("Grade: {}", grade);
    }
}
