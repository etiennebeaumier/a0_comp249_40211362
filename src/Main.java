// ---------------------------------
// Assignment #0
// Question: 1
// Written by: Étienne Beaumier 40211362
// ----------------------------------

/*
 * This is the class representing a bookstore. The user can select many options that will
 * alter the inventory of the bookstore, like changing the price of a book, adding a book, display
 * all books by a specific author, or display all books under a certain price.
 * For some options, a password is required. Failure to get it correctly will differ depending
 * on the option chose by the user.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int maxBooks = 0;
        final String PASSWORD = "249";
        int counterOpt1 = 0;
        int counterOpt2 = 0;

        System.out.println("----------------------" +
                "\nWelcome to the bookstore program\n" +
                "----------------------");
        System.out.print("Please enter the maximum number of books that can be stored in the inventory: ");
        maxBooks = scn.nextInt();

        if (maxBooks <= 0) {
            maxBooks = 1;
            System.out.println("Invalid input, the maximum number of books has been set to 1.");
        }

        Book[] inventory = new Book[maxBooks];

        while (true) {
            System.out.print("\nWhat do you want to do? \n    1. Enter new books (password required) \n    " +
                    "2. Change information of a book (password required) \n    " +
                    "3. Display all books by a specific author \n    " +
                    "4. Display all books under a certain a price. \n    " +
                    "5. Display all books in the inventory \n    " +
                    "6. Quit \nPlease enter your choice > ");

            int choice = scn.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Please enter the password: ");
                    String input = scn.next();
                    counterOpt1++;

                    while (!input.equals(PASSWORD)) {
                        System.out.print("Invalid password! Please enter the password: ");
                        input = scn.next();
                        counterOpt1++;
                        if (counterOpt1 == 12) {
                            System.out.println("Program detected suspicious activities and will terminate immediately!");
                            System.exit(0);
                        } else if (counterOpt1 % 3 == 0) {
                            break;
                        }
                    }
                    if (input.equals(PASSWORD)) {
                        if (Book.findNumberOfCreatedBooks() == maxBooks) {
                            System.out.println("The inventory is full");
                            break;
                        }
                        System.out.print("Input the number of books you want to add: ");
                        int bookAdded = scn.nextInt();
                        while (bookAdded > maxBooks - Book.findNumberOfCreatedBooks()) {
                            System.out.print("The number of books added must not exceed the remaining space in the inventory; \nInput the number of books you want to add: ");
                            bookAdded = scn.nextInt();
                        }
                        for (int i = 0; i < bookAdded; i++) {
                            System.out.print("Please enter the title of the book: ");
                            String title = scn.next();
                            System.out.print("Please enter the author of the book: ");
                            String author = scn.next();
                            System.out.print("Please enter the ISBN of the book: ");
                            long ISBN = scn.nextLong();
                            System.out.print("Please enter the price of the book: ");
                            double price = scn.nextDouble();
                            inventory[Book.findNumberOfCreatedBooks()] = new Book(title, author, ISBN, price);
                            System.out.println("Book added");
                            System.out.println(inventory[Book.findNumberOfCreatedBooks() - 1].toString());
                        }
                    }
                    break;
                case 2:
                    System.out.print("Please enter the password: ");
                    input = scn.next();
                    counterOpt2++;

                    while (!input.equals(PASSWORD)) {
                        counterOpt2++;
                        System.out.print("Invalid password! Please enter the password: ");
                        input = scn.next();
                        if (counterOpt2 % 3 == 0) {
                            break;
                        }
                    }
                    if (input.equals(PASSWORD)) {
                        if (Book.findNumberOfCreatedBooks() == 0) {
                            System.out.println("No books in inventory\n");
                            break;
                        }
                        System.out.print("Enter the book number you want to update: ");
                        int bookChoice = scn.nextInt();
                        while (bookChoice >= Book.findNumberOfCreatedBooks() || bookChoice < 0) {
                            System.out.println("Invalid book number. Please enter a valid book number: ");
                            bookChoice = scn.nextInt();
                        }
                        while (inventory[bookChoice] == null || bookChoice > Book.findNumberOfCreatedBooks()) {
                            System.out.println("Do you want to: \n    1. Re-enter another book" +
                                    "\n    2. Go back to the main menu");
                            choice = scn.nextInt();
                            switch (choice) {
                                case 1:
                                    System.out.print("Enter the book number you want to update: ");
                                    bookChoice = scn.nextInt();
                                    break;
                                case 2:
                                    break;
                                default:
                                    System.out.println("Invalid input. Re-enter a choice: ");
                                    choice = scn.nextInt();
                                    break;
                            }
                        }
                        System.out.println("Book #" + bookChoice);
                        System.out.println(inventory[bookChoice].toString());
                        int attributeChoice;
                        do {
                            System.out.print("\nWhat information would you like to change? \n    1. Author \n    2. Title \n    " +
                                    "3. ISBN \n    4. Price \n    5. Quit\nEnter your choice > ");
                            attributeChoice = scn.nextInt();

                            switch (attributeChoice) {
                                case 1:
                                    System.out.println("Enter the new author name: ");
                                    String newAuthor = scn.next();
                                    inventory[bookChoice].setAuthor(newAuthor);
                                    System.out.println("Author name has been updated");
                                    System.out.println(inventory[bookChoice].toString());
                                    break;
                                case 2:
                                    System.out.println("Enter the new title: ");
                                    String newTitle = scn.next();
                                    inventory[bookChoice].setTitle(newTitle);
                                    System.out.println("Title has been updated");
                                    System.out.println(inventory[bookChoice].toString());
                                    break;
                                case 3:
                                    System.out.println("Enter the new ISBN: ");
                                    long newISBN = scn.nextLong();
                                    inventory[bookChoice].setISBN(newISBN);
                                    System.out.println("ISBN has been updated");
                                    System.out.println(inventory[bookChoice].toString());
                                    break;
                                case 4:
                                    System.out.println("Enter the new price: ");
                                    double newPrice = scn.nextDouble();
                                    inventory[bookChoice].setPrice(newPrice);
                                    System.out.println("Price has been updated");
                                    System.out.println(inventory[bookChoice].toString());
                                    break;
                                case 5:
                                    break;
                                default:
                                    System.out.println("Invalid input. Re-enter a choice: ");
                                    break;
                            }
                        } while (attributeChoice != 5);
                    }
                    break;
                case 3:
                    if (Book.findNumberOfCreatedBooks() == 0) {
                        System.out.println("No books in inventory\n");
                    } else {
                        boolean authorExists = false;
                        while (!authorExists) {
                            System.out.print("Enter an author. The following books were written by this author: ");
                            String author = scn.next();
                            for (Book value : inventory) {
                                if (value != null && value.getAuthor().equals(author)) {
                                    System.out.println(value.getTitle());
                                    authorExists = true;
                                }
                            }
                            if (!authorExists) {
                                System.out.println("No books found by this author. Please try again.");
                            }
                        }
                    }
                    break;
                case 4:
                    if (Book.findNumberOfCreatedBooks() == 0) {
                        System.out.println("No books in inventory\n");
                    } else {
                        System.out.print("Enter a price. The following books have lower prices: ");
                        double lowestPrice = scn.nextDouble();
                        for (Book book : inventory) {
                            if (book.getPrice() < lowestPrice) {
                                System.out.println(book.getTitle());
                            }
                        }
                    }
                    break;
                case 5:
                    if (Book.findNumberOfCreatedBooks() == 0) {
                        System.out.println("No books in inventory\n");
                    } else {
                        for (int i = 0; i < Book.findNumberOfCreatedBooks(); i++) {
                            System.out.println(inventory[i].toString());
                        }
                    }
                    break;
                case 6:
                    System.out.println("Program terminated");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input\n");
                    break;
            }
        }

    }
}