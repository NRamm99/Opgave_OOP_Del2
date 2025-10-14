
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Tools.titlePrinter("MENU", true);
        Tools.printToConsole("""
                1... MobilePhone
                """);

        int userInput = input.nextInt();
        input.nextLine();
        switch (userInput) {
            case 1:
                promptMobileMenu();
                break;
        }
    }

    private static void promptMobileMenu() {
        ArrayList<MobilePhone> mobilePhones = new ArrayList<>();

        mobilePhones.add(new MobilePhone("Samsung", "Galaxy 7", 59.99));
        mobilePhones.add(new MobilePhone("Apple", "iPhone 6s", 599.99));
        mobilePhones.add(new MobilePhone("Huawei", "Honor 8", 9.99));
        mobilePhones.add(new MobilePhone("Gotham", "BatMobile", 169.99));
        while (true) {
            Tools.titlePrinter("PHONE MENU", true);
            Tools.printToConsole("""
                    1... Print Phone list
                    2... Change price
                    """);
            int userInput = input.nextInt();
            input.nextLine();
            switch (userInput) {
                case 1:
                    Tools.clearConsole();
                    printPhones(mobilePhones);
                    Tools.waitForUser(input);
                    break;
                case 2:
                    promptChangePrice(mobilePhones);
                    break;
                default:
                    return;
            }
        }
    }

    private static void printPhones(ArrayList<MobilePhone> mobilePhones) {
        int n = 0;
        Tools.titlePrinter("MOBILE PHONE LIST");
        for (MobilePhone mobilePhone : mobilePhones) {
            n++;
            Tools.printToConsole("#" + n + ": " + mobilePhone.getBrand() + " | " + mobilePhone.getModel() + " | " + "$" + mobilePhone.getPrice());
        }

    }

    private static void promptChangePrice(ArrayList<MobilePhone> mobilePhones) {
        Tools.clearConsole();
        printPhones(mobilePhones);
        Tools.titlePrinter("PRICE CHANGER");
        Tools.printToConsole("Please enter the number of the item you wish to edit...");

        int userInput = input.nextInt();
        input.nextLine();

        MobilePhone phoneToChange = mobilePhones.get(userInput - 1);

        Tools.printToConsole("Succes! You've entered a registered mobile phone:", true);
        Tools.printToConsole(phoneToChange.getBrand() + " | " + phoneToChange.getModel() + " | " + "$" + phoneToChange.getPrice());
        Tools.printToConsole("\nPlease enter the new price for the " + phoneToChange.getModel() + ".");
        System.out.print("$ ");
        mobilePhones.get(userInput - 1).setPrice(input.nextDouble());

        Tools.printToConsole("Succes! Price has been changed!");
        Tools.printToConsole(mobilePhones.get(userInput - 1).getBrand() + " | " + mobilePhones.get(userInput - 1).getModel() + " | " + "$" + mobilePhones.get(userInput - 1).getPrice());
        Tools.waitForUser(input);

    }
}