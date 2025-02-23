package com.valencia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();

        int numSubjects = main.getNumberOfAssignments(scanner);
        double total = main.calculateTotalScore(scanner, numSubjects);
        double average = main.calculateAverage(total, numSubjects);
        char grade = main.determineGrade(average);

        main.displayResults(total, average, grade);

        scanner.close();
    }

    public int getNumberOfAssignments(Scanner scanner) {
        System.out.print("Enter the number of assignments: ");

        if (scanner.hasNextInt()) {
            int numSubjects = scanner.nextInt();
            System.out.println("You entered: " + numSubjects);
            return numSubjects;
        } else {
            System.out.println("No valid input received. Defaulting to 0.");
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
        System.out.println("Total score: " + total);
        System.out.println("Average score: " + average);
        System.out.println("Grade: " + grade);
    }
}
