package tests;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FirstHomeWork {
    @Test
    public void mainFunction() {
        System.out.println("FIRST TASK");
        loanCalculator(BigDecimal.valueOf(100000), BigDecimal.valueOf(20000), BigDecimal.valueOf(5), 6);
        System.out.println();
        System.out.println("SECOND TASK");
        symbolAndWordCounterInRow("Today is a very latvian weather.");
        System.out.println();
        System.out.println("THIRD TASK");
        distanceBetweenTwoPointsCalculator("Paris","Riga",2.295128, 48.857917, 24.078134, 56.938927);
    }

    private void loanCalculator(BigDecimal totalLoanSum, BigDecimal firstPayment, BigDecimal annualPercents, int periodInMonths) {

        BigDecimal remainingSum = totalLoanSum.subtract(firstPayment);
        BigDecimal fixedMonthlyPayment = remainingSum.divide(BigDecimal.valueOf(periodInMonths), 2, RoundingMode.HALF_EVEN);
        BigDecimal monthlyPercents = annualPercents.divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_EVEN);

        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";

        System.out.println(ANSI_RED + "GENERAL LOAN INFORMATION!" + ANSI_RESET);
        System.out.println();
        System.out.println(ANSI_BLUE + "Total loan amount: " + ANSI_RESET + ANSI_PURPLE + totalLoanSum + ANSI_RESET + ANSI_YELLOW + " EUR" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "First payment: " + ANSI_RESET + ANSI_PURPLE + firstPayment + ANSI_RESET + ANSI_YELLOW + " EUR" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "Annual percents: " + ANSI_RESET + ANSI_PURPLE + annualPercents + ANSI_RESET + ANSI_YELLOW + " %" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "Loan period: " + ANSI_RESET + ANSI_PURPLE + periodInMonths + ANSI_RESET + ANSI_YELLOW + " months" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "Loan remainder: " + ANSI_RESET + ANSI_PURPLE + remainingSum + ANSI_RESET + ANSI_YELLOW + " EUR" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "Monthly payment excluding percents: " + ANSI_RESET + ANSI_PURPLE + fixedMonthlyPayment + ANSI_RESET + ANSI_YELLOW + " EUR" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "Monthly percentage ratio: " + ANSI_RESET + ANSI_PURPLE + monthlyPercents + ANSI_RESET + ANSI_YELLOW + " %" + ANSI_RESET);
        System.out.println();
        System.out.println();
        System.out.println(ANSI_RED + "PAYMENT SCHEDULED INFORMATION!" + ANSI_RESET);
        System.out.println();
        BigDecimal starSum = new BigDecimal(String.valueOf(firstPayment));

        for (int i = 0; i < periodInMonths; i++) {
            System.out.println(ANSI_CYAN + (i + 1) + " month payment" + ANSI_RESET);
            BigDecimal monthPayForPercents = remainingSum.multiply(monthlyPercents).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_EVEN);
            BigDecimal overallMontlyPayment = monthPayForPercents.add(fixedMonthlyPayment);
            System.out.println(ANSI_BLUE + "Percents payment: " + ANSI_RESET + ANSI_PURPLE + monthPayForPercents + ANSI_RESET + ANSI_YELLOW + " EUR" + ANSI_RESET);
            System.out.println(ANSI_BLUE + "Overall monthly payment: " + ANSI_RESET + ANSI_PURPLE + overallMontlyPayment + ANSI_RESET + ANSI_YELLOW + " EUR" + ANSI_RESET);
            remainingSum = remainingSum.subtract(fixedMonthlyPayment);
            System.out.println(ANSI_BLUE + "Reminder: " + ANSI_RESET + ANSI_PURPLE + remainingSum + ANSI_RESET + ANSI_YELLOW + " EUR" + ANSI_RESET);
            starSum = starSum.add(overallMontlyPayment);
            System.out.println(ANSI_BLUE + "Final paid sum: " + ANSI_RESET + ANSI_RED + starSum + ANSI_RESET);
            System.out.println();
        }
    }

    private void symbolAndWordCounterInRow(String randomText) {
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_RESET = "\u001B[0m";
        System.out.println("User input text:  " + ANSI_YELLOW + randomText + ANSI_RESET);
        System.out.println("Symbol count in row is: "+randomText.length());
        String [] textMass = randomText.split(" ");
        System.out.println("Word count in row is: "+textMass.length);
    }

    private void distanceBetweenTwoPointsCalculator(String firstLocation,String secondLocation, double firstLatitude, double firstLongitude, double secondLatitude, double secondLongitude) {
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_RESET = "\u001B[0m";
        final double EARTH_RADIUS = 3958.75;
        double deltaLatitude = Math.toRadians(secondLatitude - firstLatitude);
        double deltaLongitude = Math.toRadians(secondLongitude - firstLongitude);
        double aVariable = Math.sin(deltaLatitude / 2) * Math.sin(deltaLatitude / 2) +
                Math.cos(Math.toRadians(firstLatitude)) * Math.cos(Math.toRadians(secondLatitude)) *
                        Math.sin(deltaLongitude / 2) * Math.sin(deltaLongitude / 2);
        double distanceBetweenTwoCoordinates = EARTH_RADIUS * 2 * Math.atan2(Math.sqrt(aVariable), Math.sqrt(1 - aVariable));
        System.out.println("First Location is: "+firstLocation+"/"+firstLatitude+","+firstLongitude);
        System.out.println("Second Location is: "+secondLocation+"/"+secondLatitude+","+secondLongitude);
        System.out.println("Distance between two coordinates: " + ANSI_YELLOW + Math.round(distanceBetweenTwoCoordinates) + ANSI_RESET + " km");
    }
}