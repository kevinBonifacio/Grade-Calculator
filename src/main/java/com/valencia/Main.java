package com.valencia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of assignments: ");
        int numSubjects = scanner.nextInt();

        double total = 0;

        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter score for assignment " + i + ": ");
            total += scanner.nextDouble();
        }

        double average = total / numSubjects;

        char grade;
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("Total score: " + total);
        System.out.println("Average score: " + average);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}