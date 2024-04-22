package com.pluralsight.ui;

import com.pluralsight.models.Book;

import java.sql.SQLOutput;
import java.util.Scanner;

public class UserInterface
{
    private Scanner scanner = new Scanner(System.in);

    public void waitForInput()
    {
        System.out.print("Press any key to continue...");
        scanner.next();
        System.out.println();
    }

    public int promptHomeScreenSelection()
    {
        System.out.println();
        System.out.println("Home");
        System.out.println("-".repeat(30));
        System.out.println(" 1) Show Available Books");
        System.out.println(" 2) Show Checked-Out Books");
        System.out.println(" 3) Exit");
        System.out.println();
        System.out.print("What would you like to do? ");
        return Integer.parseInt(scanner.nextLine().strip());
    }

    public int promptAvailableBookCheckout()
    {
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println(" C) Check out a book");
        System.out.println(" X) Go to the home screen");
        System.out.print("Select an option: ");
        String choice = scanner.nextLine().strip().toLowerCase();

        switch(choice)
        {
            case "c":
                System.out.print("Enter the book id: ");
                return Integer.parseInt(scanner.nextLine().strip());
            default:
                return -1;
        }
    }

    public int promptBookCheckin()
    {
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println(" C) Check in a book");
        System.out.println(" X) Go to the home screen");
        System.out.print("Select an option: ");
        String choice = scanner.nextLine().strip().toLowerCase();

        switch(choice)
        {
            case "c":
                System.out.print("Enter the book id: ");
                return Integer.parseInt(scanner.nextLine().strip());
            default:
                return -1;
        }
    }

    public String promptForName()
    {
        System.out.print("Please enter your name: ");
        return scanner.nextLine().strip();
    }

    public void displayAvailableBooks(Book[] books)
    {
        System.out.println();
        System.out.println("Currently Available Books");
        System.out.println("-".repeat(30));
        displayBooks(books, false);
    }

    public void displayCheckedOutBooks(Book[] books)
    {
        System.out.println();
        System.out.println("Currently Checked-Out Books");
        System.out.println("-".repeat(30));
        displayBooks(books, true);
    }

    private void displayBooks(Book[] books, boolean isCheckedOut)
    {
        System.out.printf("%-5s %-13s %-40s %s\n","Id", "ISBN","Title", "Available");
        System.out.printf("%-5s %-13s %-40s %s\n","-".repeat(5), "-".repeat(13),"-".repeat(40), "-".repeat(10));

        for(Book book : books)
        {
            if(book.isCheckedOut() == isCheckedOut)
            {
                System.out.printf("%-5d %-13s %-40s %s\n",
                        book.getId(),
                        book.getIsbn(),
                        book.getTitle(),
                        !book.isCheckedOut());
            }
        }
    }

    public void displayMessage(String message)
    {
        System.out.println();
        System.out.println(message);
    }
}
