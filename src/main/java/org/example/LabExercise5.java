// Student name: Koichi Nakata (ID: kanakta595)

package org.example;

public class LabExercise5 {
    final static int NUM_OF_MONTHS = 12;
    public static void main(String[] args) {
        Year.setNumOfMonths(NUM_OF_MONTHS);
        Year myYear = new Year(2024);

        Birthday myBirthday = new Birthday("Koichi", 12, 0);

        myYear.addMyBirthday(9, myBirthday);

        myYear.display();
    }
}