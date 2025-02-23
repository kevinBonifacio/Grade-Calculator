package com.valencia;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void getNumberOfAssignments_ValidInput() {
        String input = "3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();

        int result = main.getNumberOfAssignments(scanner);

        assertEquals(3, result);
        scanner.close();
    }

    @Test
    void getNumberOfAssignments_InvalidInput() {
        String input = "abc\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();

        int result = main.getNumberOfAssignments(scanner);

        assertEquals(0, result);
        scanner.close();
    }


    @Test
    void calculateTotalScore() {
        String input = "85\n90\n95\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();

        double result = main.calculateTotalScore(scanner, 3);

        assertEquals(270.0, result, 0.01);
        scanner.close();
    }

    @Test
    void calculateAverage() {
        Main main = new Main();
        assertEquals(90.0, main.calculateAverage(270, 3), 0.01);
        assertEquals(0.0, main.calculateAverage(0, 0), 0.01);
    }

    @Test
    void determineGrade() {
        Main main = new Main();
        assertEquals('A', main.determineGrade(95));
        assertEquals('B', main.determineGrade(85));
        assertEquals('C', main.determineGrade(75));
        assertEquals('D', main.determineGrade(65));
        assertEquals('F', main.determineGrade(50));
    }

    @Test
    void displayResults() {
        Main main = new Main();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        main.displayResults(270, 90, 'A');

        String expectedOutput = "Total score: 270.0\nAverage score: 90.0\nGrade: A\n";
        assertEquals(expectedOutput.replaceAll("\\r\\n", "\n"), outputStream.toString().replaceAll("\\r\\n", "\n"));
    }
}