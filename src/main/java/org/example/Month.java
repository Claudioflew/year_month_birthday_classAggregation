package org.example;

public class Month {
    static public final String[] MONTH_DICT = {"Dummy", "January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November", "December"};
    static public final int START_DAY_JAN_1_2021 = 5; // January 1, 2021 was Friday
    private int month;
    private int year;

    public Month() {
        setMonth(1);
        setYear(2021);
    }

    public Month(int month, int year) {
        setMonth(month);
        setYear(year);
    }

    public int getMonth() { return month; }
    public void setMonth(int month) {
        if (month >= 1 && month <= 12) this.month = month;
        else {
            this.month = 1;
            System.out.println("Invalid month value.. The month has been set to 1.");
        }
    }

    public int getYear() { return year; }
    public void setYear(int year) {
        if (year >= 2021) this.year = year;
        else {
            this.year = 2021;
            System.out.println("Invalid month value.. The month has been set to 2021.");
        }
    }

    public void display() {
        displayHeader();
        displayBody();
    }

    private void displayHeader() {
        System.out.printf("\n%14s %-14d\n", MONTH_DICT[month], year);
        System.out.println("-----------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }

    private void displayBody() {
        int startDay = getStartDay();
        int daysInMonth = getNumberOfDaysInMonth(getMonth(), getYear());

        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }
        for (int i = 1; i <= daysInMonth; i++) {
            System.out.printf("%4d", i);
            if ((i + startDay) % 7 == 0) System.out.println();
        }
        System.out.println();
    }

    private int getStartDay() {
        int totalNumbersOfDays = START_DAY_JAN_1_2021 + getTotalNumberOfDays(getMonth(), getYear());
        return totalNumbersOfDays % 7;
    }

    private int getTotalNumberOfDays(int month, int year) {
        int total = 0;
        for (int i = 2021; i < year; i++) {
            total += isLeapYear(i) ? 366 : 365;
        }
        for (int i = 1; i < month; i++) {
            total += getNumberOfDaysInMonth(i, year);
        }
        return total;
    }

    private int getNumberOfDaysInMonth(int month, int year) {
        int[] daysArray = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) daysArray[2] = 29;

        return daysArray[month];
    }

    private boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

}
