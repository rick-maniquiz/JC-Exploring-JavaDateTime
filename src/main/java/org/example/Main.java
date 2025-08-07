package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n--- Exercise 1 ---");
        {
            LocalDate localDate = LocalDate.of(2025, 8, 21);
            DateTimeFormatter formatterCustom = DateTimeFormatter.ofPattern("dd/MM/yyy");
            DateTimeFormatter formatterFull = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
            System.out.println(localDate.format(formatterCustom));
            System.out.println(localDate.format(formatterFull));
        }

        System.out.println("\n--- Exercise 2 ---");
        {
            LocalTime now = LocalTime.of(16, 45, 30);

            DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH:mm:ss");
            DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("hh:mm:ss a");

            System.out.println("Default format: " + now);
            System.out.println("24-hour format: " + now.format(dtf1));
            System.out.println("12-hour format with AM/PM: " + now.format(dtf2));
        }

        System.out.println("\n--- Exercise 3 ---");
        {
            LocalDateTime event = LocalDateTime.of(2025, 11, 27, 19, 0, 0);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy 'at' hh:mm a");

            System.out.println("Default format: " + event);
            System.out.println("Custom format: " + event.format(dtf));
        }

        System.out.println("\n--- Exercise 4 ---");
        {
            LocalDate startDate = LocalDate.of(2025, 9, 1);

            startDate.plusDays(10);

            System.out.println("Start date after trying to modify it: " + startDate);

            LocalDate endDate = startDate.plusDays(10);

            System.out.println("The original start date is still: " + startDate);
            System.out.println("The new end date is: " + endDate);
        }

        System.out.println("\n--- Exercise 5 ---");
        {
            LocalDateTime baseTime = LocalDateTime.of(2025, 10, 15, 10, 30, 0);

            LocalDateTime futureTime = baseTime.plusYears(1).plusMonths(2).plusHours(5);
            LocalDateTime pastTime = baseTime.minusWeeks(3).minusDays(3);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            System.out.println("Base time:   " + baseTime.format(dtf));
            System.out.println("Future time: " + futureTime.format(dtf));
            System.out.println("Past time:   " + pastTime.format(dtf));
        }

        System.out.println("\n--- Exercise 6 ---");
        {
            LocalDate date1 = LocalDate.of(2024, 3, 15);
            LocalDate date2 = LocalDate.of(2026, 7, 20);

            Period period = Period.between(date1, date2);

            System.out.print("The period between the two dates is: ");
            System.out.print(period.getYears() + " years, ");
            System.out.print(period.getMonths() + " months, and ");
            System.out.println(period.getDays() + " days.");
        }
    }
}