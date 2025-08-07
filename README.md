# Exploring Java Date and Time API
## Cadet Name: Rafael Nico T. Maniquiz
-----

### Exercise 1: `LocalDate` and `DateTimeFormatter`

`LocalDate` represents a date without time or a time zone (e.g., 2025-08-21). `DateTimeFormatter` is used to convert this date object into a formatted string.

**TODO**

1.  Declare a local date for **August 21, 2025**.
2.  Format the date using `DateTimeFormatter` so the output is **`21/08/2025`**.
3.  Format the date to show the day of the week, like this: **`Thursday, August 21, 2025`**.

**Code Snippet:**

```java
LocalDate localDate = LocalDate.of(2025, 8, 21);
DateTimeFormatter formatterCustom = DateTimeFormatter.ofPattern("dd/MM/yyy");
DateTimeFormatter formatterFull = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
System.out.println(localDate.format(formatterCustom));
System.out.println(localDate.format(formatterFull));

```

**Output:**

<img src="https://github.com/rick-maniquiz/JC-Exploring-JavaDateTime/blob/39d24176e321a71d30cf45ecb1e22647d556cacd/screenshots/1.png"/>

-----

### Exercise 2: `LocalTime` and `DateTimeFormatter`

`LocalTime` represents a time without a date or time zone (e.g., 14:30:15).

**Code Snippet:**

```java
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeLab {
    public static void main(String[] args) {
        LocalTime now = LocalTime.of(16, 45, 30);

        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("hh:mm:ss a");

        System.out.println("Default format: " + now);
        System.out.println("24-hour format: " + now.format(dtf1));
        System.out.println("12-hour format with AM/PM: " + now.format(dtf2));
    }
}
```

**1. Prediction:**


```
Default format: 16:45:30
24-hour format: 16:45:30
12-hour format with AM/PM: 04:45:30 PM
```

**2. Observation:**

<img src="https://github.com/rick-maniquiz/JC-Exploring-JavaDateTime/blob/39d24176e321a71d30cf45ecb1e22647d556cacd/screenshots/2.png"/>

-----

### Exercise 3: `LocalDateTime` and `DateTimeFormatter`

`LocalDateTime` combines both a date and a time, but still without a time zone.

**Code Snippet:**

```java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeLab {
    public static void main(String[] args) {
        LocalDateTime event = LocalDateTime.of(2025, 11, 27, 19, 0, 0);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy 'at' hh:mm a");

        System.out.println("Default format: " + event);
        System.out.println("Custom format: " + event.format(dtf));
    }
}
```

**1. Prediction:**

```
Default format: 2025-11-27T19:00:00
Custom format: Nov 27, 2025 'at' 07:00 PM
```

**2. Observation:**

<img src="https://github.com/rick-maniquiz/JC-Exploring-JavaDateTime/blob/39d24176e321a71d30cf45ecb1e22647d556cacd/screenshots/3.png"/>

-----

### Exercise 4: The Immutability of Date-Time Objects

This is a critical concept. Methods like `plusDays` or `minusHours` do not change the object they are called on. Instead, they return a **new** object with the modified value.

**Code Snippet:**

```java
import java.time.LocalDate;

public class DateTimeLab {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2025, 9, 1);

        startDate.plusDays(10);

        System.out.println("Start date after trying to modify it: " + startDate);

        LocalDate endDate = startDate.plusDays(10);

        System.out.println("The original start date is still: " + startDate);
        System.out.println("The new end date is: " + endDate);
    }
}
```

**1. Prediction:**


```
The original start date is still: 2025-09-01
The new end date is: 2025-09-11
```

**2. Observation:**

<img src="https://github.com/rick-maniquiz/JC-Exploring-JavaDateTime/blob/39d24176e321a71d30cf45ecb1e22647d556cacd/screenshots/4.png"/>

-----

### Exercise 5: Adding and Subtracting Time (`plus` and `minus`)

You can easily perform date and time arithmetic.

**Code Snippet:**

```java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeLab {
    public static void main(String[] args) {
        LocalDateTime baseTime = LocalDateTime.of(2025, 10, 15, 10, 30, 0);

        LocalDateTime futureTime = baseTime.plusYears(1).plusMonths(2).plusHours(5);
        LocalDateTime pastTime = baseTime.minusWeeks(3).minusDays(3);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("Base time:   " + baseTime.format(dtf));
        System.out.println("Future time: " + futureTime.format(dtf));
        System.out.println("Past time:   " + pastTime.format(dtf));
    }
}
```

**1. Prediction:**

```
Base time:   2025-10-15 10:30
Future time: 2026-12-15 15:30
Past time:   2025-09-21 10:30
```

**2. Observation:**

<img src="https://github.com/rick-maniquiz/JC-Exploring-JavaDateTime/blob/39d24176e321a71d30cf45ecb1e22647d556cacd/screenshots/5.png"/>

-----

### Exercise 6: `Period` - Measuring a Span of Time

A `Period` represents a quantity of time in terms of years, months, and days.

**Code Snippet:**

```java
import java.time.LocalDate;
import java.time.Period;

public class DateTimeLab {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2024, 3, 15);
        LocalDate date2 = LocalDate.of(2026, 7, 20);

        Period period = Period.between(date1, date2);

        System.out.print("The period between the two dates is: ");
        System.out.print(period.getYears() + " years, ");
        System.out.print(period.getMonths() + " months, and ");
        System.out.println(period.getDays() + " days.");
    }
}
```

**1. Prediction:**

What do you think will be the output?

```
The period between the two dates is: 
2 years, 4 months, and 5 days.
```

**2. Observation:**

<img src="https://github.com/rick-maniquiz/JC-Exploring-JavaDateTime/blob/39d24176e321a71d30cf45ecb1e22647d556cacd/screenshots/6.png"/>
