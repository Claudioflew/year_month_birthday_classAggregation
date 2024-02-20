// Student name: Koichi Nakata (ID: kanakta595)

package org.example;

public class Birthday {
    public static String[] CAKE_ARRAY =
            {"Roll cake", "Mont blanc", "Chocolate cake", "Shortcake", "Cheese cake"};
    private String name;
    private int date;
    private String cake;

    public Birthday() { this("Claudio", 12, 0); }

    public Birthday(String name, int date, int cake) {
        setName(name);
        setDate(date);
        setCake(cake);
    }

    public String getName() { return name; }
    public int getDate() { return date; }
    public String getCake() { return cake; }

    public void setName(String name) { this.name = name; }
    public void setDate(int date) { this.date = date; }
    public void setCake(int cake) {
        if (cake >= 0 && cake < CAKE_ARRAY.length) {
            this.cake = CAKE_ARRAY[cake];
        } else {
            System.out.println("Invalid index for cakes.. This has been set to Mont blanc");
            this.cake = CAKE_ARRAY[0];
        }
    }

    public static String[] getCakeArray() { return CAKE_ARRAY; }

    public void display() {
        System.out.println();
        System.out.printf("  *%d is %s's birthday!\n", getDate(), getName());
        System.out.printf("  *%s is prepared :)\n", getCake());
        System.out.println();
    }
}
