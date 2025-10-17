import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Tools.titlePrinter("MENU", true);
        Tools.printToConsole("""
                1... Opgave 1: Definere og bruge en simpel klasse
                2... Opgave 2: Brug af Java biblioteksklasser
                3... Opgave 3: Arrays af objekter
                4... Opgave 4: Indkapsling og brug af getter- og setter-metoder
                """);

        int userInput = input.nextInt();
        input.nextLine();
        switch (userInput) {
            case 1:
                promptMobileMenu();
                break;
            case 2:
                promptOpgToMenu();
                break;
            case 3:
                promptOpgTreMenu();
                break;
            case 4:
                promptOpgFireMenu();
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

    private static void promptOpgToMenu() {
        Date today = new Date();

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int n = 0; n < 5; n++) {
            numbers.add((int) (Math.random() * 10));
        }

        Tools.printToConsole(today.toString(), true);
        System.out.println();
        int n = 1;
        for (int number : numbers) {
            Tools.printToConsole("#" + n + ": " + number);
            n++;
        }

        System.out.println();
        Tools.waitForUser(input);

    }

    private static void promptOpgTreMenu() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Nichlas Ramm", 26, "260899M"));
        students.add(new Student("Emma Jensen", 22, "150302F"));
        students.add(new Student("Lucas Sørensen", 25, "031298M"));
        students.add(new Student("Freja Nielsen", 21, "080504F"));
        students.add(new Student("Magnus Pedersen", 23, "191201M"));
        students.add(new Student("Clara Møller", 24, "290399F"));
        students.add(new Student("Oliver Andersen", 27, "041197M"));
        students.add(new Student("Sofie Kristensen", 20, "120505F"));
        students.add(new Student("Noah Rasmussen", 28, "070696M"));
        students.add(new Student("Ida Thomsen", 23, "231201F"));

        printStudents(students);
    }

    private static void printStudents(ArrayList<Student> students) {
        Tools.titlePrinter("STUDENTS");
        for (Student student : students) {
            Tools.printToConsole(student.getName() + " | age: " + student.getAge() + " | ID: " + student.getStudentID());
        }
    }

    private static void promptOpgFireMenu() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Hairy Potter: The Last Shave    ", "JK Rolling              ", 10.99));
        books.add(new Book("The Hobbit: Return of the Snacks", "J.R.R. Tollkin          ", 12.49));
        books.add(new Book("To Grill a Mockingbird          ", "Harper Steam            ", 9.75));
        books.add(new Book("Fifty Shades of Earl Grey       ", "Tea L. James            ", 11.50));
        books.add(new Book("The Great Catsby                ", "F. Scoot Fitzpurrald    ", 8.99));
        books.add(new Book("Lord of the Fries               ", "J.R. Grease Tolkien     ", 13.25));
        books.add(new Book("Pride and Protein Shakes        ", "Jane Gainz              ", 10.49));
        books.add(new Book("The Catcher in the Fry          ", "J.D. Snacklinger        ", 9.25));
        books.add(new Book("Gone with the Wine              ", "Margaret Drinkson       ", 14.10));
        books.add(new Book("A Game of Cones                 ", "George R.R. Cream       ", 12.99));
        printBooks(books);
    }

    private static void printBooks(ArrayList<Book> books) {
        Tools.titlePrinter("BOOKS");
        for (Book book : books) {
            Tools.printToConsole(book.getTitle() + " | By: " + book.getAuthor() + " | Price: $" + book.getPrice());
        }
    }
}