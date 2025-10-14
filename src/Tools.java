import java.util.Scanner;

public class Tools {

    public static void clearConsole() {
        for (int n = 0; n < 20; n++) {
            System.out.println();
        }
    }

    public static void waitForUser(Scanner input) {
        System.out.println("\nPress enter to continue...");
        input.nextLine();
    }

    public static void printToConsole(String text, boolean clear) {
        if (clear) {
            clearConsole();
        }
        System.out.println(text);
    }

    public static void printToConsole(String text) {
        printToConsole(text, false);
    }

    public static void titlePrinter(String title) {
        printToConsole("---------- " + title + " ----------");
    }

    public static void titlePrinter(String title, boolean clear) {
        if (clear) {
            printToConsole("---------- " + title + " ----------", true);
        } else {
            printToConsole("---------- " + title + " ----------");
        }
    }
}
