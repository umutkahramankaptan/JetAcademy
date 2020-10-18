//put imports you need here

import java.util.Scanner;

class Form {
    String firstName;
    String line2;
    String line3;
    String line4;
    String cuisinePreference;

    public Form() {
        Scanner scanner = new Scanner(System.in);
        this.firstName = scanner.next();
        this.line2 = scanner.next();
        this.line3 = scanner.next();
        this.line4 = scanner.next();
        this.cuisinePreference = scanner.next();
    }

/*
    public Form(String firstName, String line2, String line3, String line4, String cuisinePreference) {
        this.firstName = firstName;
        this.line2 = line2;
        this.line3 = line3;
        this.line4 = line4;
        this.cuisinePreference = cuisinePreference;
    }
*/

    public String getFirstName() {
        return firstName;
    }

    public String getCuisinePreference() {
        return cuisinePreference;
    }
}

class Main {
    public static void main(String[] args) {
        Form application = new Form();

        System.out.printf(
                "The form for %s is completed. We will contact you if we need a chef that cooks %s dishes.\n",
                application.getFirstName(),
                application.getCuisinePreference());
    }
}