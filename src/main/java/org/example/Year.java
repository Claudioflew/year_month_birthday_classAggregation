// Student name: Koichi Nakata (ID: kanakta595)

package org.example;

public class Year {
    private static String[] ZODIAC_DICT =
            {"Monkey", "Rooster", "Dog", "Pig", "Rat", "Ox",
             "Tiger", "Rabbit", "Dragon", "Snake", "Horse", " Goat"};
    private static int NUM_OF_MONTHS;

    private int year;
    private Month[] monthArray;
    private String zodiac;

    public Year() { this(2021); }
    public Year(int year) {
        setYear(year);
        setMonthArray();
        setZodiac();
    }

    public int getYear() { return year; }
    public Month[] getMonthArray() { return monthArray; }
    public String getZodiac() { return zodiac; }

    public void setYear(int year) {
        if (year >= 2021 && year <= 2050) this.year = year;
        else {
            System.out.println("Invalid year.. This has been set up to 2021");
            this.year = 2021;
        }
    }

    private void setMonthArray() {
        monthArray = new Month[getNumOfMonths()];
        for (int i = 0; i < getNumOfMonths(); i++) {
            monthArray[i] = new Month(i+1, year);
        }
    }

    private void setZodiac() {
        int index = getYear() % 12;
        zodiac = ZODIAC_DICT[index];
    }

    public static void setNumOfMonths(int NUM_OF_MONTHS) { Year.NUM_OF_MONTHS = NUM_OF_MONTHS; }
    public static int getNumOfMonths() { return NUM_OF_MONTHS; }

    public void addMyBirthday(int month, Birthday myBirthday) {
        if (month >= 1 && month <= 12) {
            getMonthArray()[month-1].setMyBirthday(myBirthday);
        } else {
            System.out.println("Invalid month.. Please try again.");
        }
    }
    public void display() {
        System.out.println();
        System.out.printf("     %d: Year of %s\n", getYear(), getZodiac());
        for (Month month : getMonthArray()) {
            month.display();
        }
    }
}
